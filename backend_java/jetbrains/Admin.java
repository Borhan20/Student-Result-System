package com.jetbrains;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import static com.jetbrains.Admin.calculateResult;

/**
 * Class Admin
 */
public class Admin  {

  //
  // Fields
  //

  /**
   * 																																																				
   */
  public static int maxStudent = 1000;
  public static int stuCount = 0;
  public static int teaCount =0;
  public static ArrayList<Student> studentList = new ArrayList<Student>();
  public static ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
  public static int credit = 3;
  public static String passdefault = "1234";
  //
  // Constructors
  //


  public static void addStudent (String name,  String ID, String password,String semester, String year, String crs, String crs2)
  {
    Student st = new Student( name, ID,password, semester,  year, crs,  crs2);

    //writing student info in a file

    try{
      PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\studentLogin.txt",true)));
      //output.println(name);
      output.println(ID);
      output.println("1234");
      output.close();
    }
    catch (IOException e)
    {
      System.out.println(e);
    }

    System.out.println("Student Added");
    studentList.add(st);

  }

  public static void addTeacher (String name, String ID, String password, String crs)
  {
    Teacher t = new Teacher(  name,  ID, password, crs);
    System.out.println("Adding teacher");

    //writing teacher info in a file

    try{
      PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\teacherLogin.txt",true)));
      //output.println(name);

      output.println(ID);
      output.println("1234");
      output.close();
    }
    catch (IOException e)
    {
      System.out.println(e);
    }

    System.out.println("Teacher Added");
    teacherList.add(t);
  }



  public static void updateMarks(String filename) {
    java.io.File file = new java.io.File(filename);
    Scanner in = null;
    try {
      in = new Scanner(file);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    String crsname = in.next();

    while (in.hasNext()) {

      System.out.println("asdfgas");
      String nm = in.next();
      String num = in.next();
      double numb = Double.parseDouble(num);
      System.out.println(nm+" "+num);
      for (int i = 0; i < studentList.size(); i++) {
        if (nm.equals(studentList.get(i).getName())) {
          System.out.println(nm);
          studentList.get(i).addMaks(crsname, numb);
          break;
        }
      }

    }
  }

  public static void adminLogin(String received, Socket s, DataInputStream dis, DataOutputStream dos) {

    try {


      String username = dis.readUTF();
      String pass = dis.readUTF();

      //opening admin file to check log in
      java.io.File adminFile = new java.io.File("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\adminLogin.txt");
      Scanner in = new Scanner(adminFile);

      String matchName = in.next();
      String matchPass = in.next();

      //matching admin's name and password

      //System.out.println(matchName+matchPass);
      if (matchName.equals(username) && matchPass.equals(pass)) {

        // Admin admin1 = new Admin(matchName,  matchPass);
        System.out.println("Successful admin login");

        //computing result
        int resultCompletedFlag = 1;

        //checking whether all teachers have uploaded result
        for (int i = 0; i < teacherList.size(); i++) {
          if (teacherList.get(i).getResulltUploaded()) {
            continue;
          } else resultCompletedFlag = 0;
        }


        //login success message
        dos.writeUTF("Success");
        dos.flush();

        if (resultCompletedFlag == 1) {
                            /*
                                if All teacher have uploaded result ,
                                then calculate result
                             */
          calculateResult();
        }
        while (true) {
          received = dis.readUTF();
          System.out.println("received in while " + received);

          //adding a student

          if (received.equals("add Student")) {

            //System.out.println("");

            //adding student until back button is pressed
            while (!received.equals("Exit To Admin Option")) {
              received = dis.readUTF();
              System.out.println("received in addstu  " + received);
              if (received.equals("Add Pressed")) {
                String nme = dis.readUTF();
                String id = dis.readUTF();
                String sems = dis.readUTF();
                String year = dis.readUTF();
                String crs1 = dis.readUTF();
                String crs2 = dis.readUTF();
                System.out.println(nme + id);
                addStudent(nme, id, passdefault, sems, year, crs1, crs2);

                System.out.println("array list" + studentList.get(0).getName() + studentList.get(0).getID());
              }
            }
          } else if (received.equals("Exit To Admin Log In")) {
            break;
          }


          //adding a teacher

          else if (received.equals("add Teacher")) {

            while (!received.equals("Exit To Admin Option")) {
              received = dis.readUTF();
              System.out.println("received in addstu  " + received);
              if (received.equals("Add Pressed")) {

                String nme = dis.readUTF();

                String id = dis.readUTF();
                String crs = dis.readUTF();
                System.out.println(nme + id);

                addTeacher(nme, id, passdefault, crs);
              }
            }

          }

        }

        //invalid password or username message
      } else {
        dos.writeUTF("not Success");
        dos.flush();
      }


    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void teacherLogin(String received, Socket s, DataInputStream dis, DataOutputStream dos) {

    try {

      System.out.println("teacher log in trying ");
      String name = dis.readUTF();
      String passTeacher = dis.readUTF();
      int successFlag = 0;
      int i;
      System.out.println("teacher send"+name+passTeacher);

      //checking whether username or password is valid
      for( i=0;i<teacherList.size();i++)
      {
        if(teacherList.get(i).getID().equals(name)&&teacherList.get(i).getPassword().equals(passTeacher))
        {
          System.out.println("Teacher "+name+" Login successfull");
          dos.writeUTF("Success");
          dos.flush();
          successFlag = 1;
          break;
        }
      }
                    /*
                    java.io.File teacherFile = new java.io.File("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\teacherLogin.txt");
                    Scanner in = new Scanner(teacherFile);

                    while (in.hasNext()) {
                        String matchName = in.next();
                        String pass = in.next();

                        System.out.println(matchName + name + pass + passTeacher);
                        if (matchName.equals(name) && pass.equals(passTeacher)) {
                            System.out.println("Teacher " + name + " Login successfull");
                            dos.writeUTF("Success");
                            dos.flush();
                            successFlag = 1;
                            break;
                        }
                    }*/

      //invalid username or password message
      if (successFlag == 0) {
        dos.writeUTF("Not Success");
        dos.flush();
      } else {

        while(true) {
          received = dis.readUTF();
          if(received.equals("Teacher Information")) {
                                /*
                                dos.writeUTF(studentList.get(i).getName());
                                dos.flush();

                                dos.writeUTF(studentList.get(i).getID());
                                dos.flush();

                                dos.writeUTF(studentList.get(i).getSemester());
                                dos.flush();

                                dos.writeUTF(studentList.get(i).getYear());
                                dos.flush();
                                */
          }

          //editing teacher's information
          else if(received.equals("go to EditInformation"))
          {

            String input = null;
            input = dis.readUTF();

            while(true) {

              if (input.equals("edit")) {
                System.out.println("going to edit page");

                //setting new name, id, password or contacts etc
                input = dis.readUTF();
                System.out.println(input);
                teacherList.get(i).setName(input);

                input = dis.readUTF();
                teacherList.get(i).setID(input);

                input = dis.readUTF();
                teacherList.get(i).setPassword(input);

                input = dis.readUTF();
                teacherList.get(i).setContact(input);

                input = dis.readUTF();
              }
              else break;

            }

          }

          //updating marks
          else if(received.equals("go to updateMarks"))
          {
            received = dis.readUTF();
            System.out.println(received);

            byte[] b = new  byte[2000];
            FileInputStream fileInputStream = (FileInputStream) s.getInputStream();
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\"+teacherList.get(i).getName()+".txt");
            fileInputStream.read(b,0,b.length);
            fileOutputStream.write(b,0,b.length);

            //whether teacher uploaded or not

            teacherList.get(i).setResulltUploaded(true);

            //updating students' marks through a file
            updateMarks("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\"+teacherList.get(i).getName()+".txt");
          }

          //go to front page
          else if(received.equals("go to home"))
          {
            break;
          }
        }


      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void studentLogin(String received, Socket s, DataInputStream dis, DataOutputStream dos) {

    try {
      System.out.println("student log in trying ");

      String name = dis.readUTF();
      String passStudent = dis.readUTF();
      int successFlag = 0;
      int i;
      System.out.println(name + passStudent);

      //checking whether username or password is valid
      for (i = 0; i < studentList.size(); i++) {
        if (studentList.get(i).getID().equals(name) && studentList.get(i).getPassword().equals(passStudent)) {
          System.out.println("Student " + name + " Login successfull");
          dos.writeUTF("Success");
          dos.flush();
          successFlag = 1;
          break;
        }
      }

                    /*
                    java.io.File studentFile = new java.io.File("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\studentLogin.txt");
                    Scanner in = new Scanner(studentFile);

                    while (in.hasNext()) {
                        String matchName = in.next();
                        String pass = in.next();

                        System.out.println(matchName + name + pass + passStudent);
                        if (matchName.equals(name) && pass.equals(passStudent)) {
                            System.out.println("Teacher " + name + " Login successfull");
                            dos.writeUTF("Success");
                            dos.flush();
                            successFlag = 1;
                            break;
                        }
                    }*/

      if (successFlag == 0) {
        dos.writeUTF("Not Success");
        dos.flush();
      } else {

        while (true) {
          received = dis.readUTF();
          System.out.println("view " + received);
          if (received.equals("go to StudentInformation")) {
            dos.writeUTF(studentList.get(i).getName());
            dos.flush();

            dos.writeUTF(studentList.get(i).getID());
            dos.flush();

            dos.writeUTF(studentList.get(i).getSemester());
            dos.flush();

            dos.writeUTF(studentList.get(i).getYear());
            dos.flush();


          }

          //editing student's information
          else if (received.equals("go to EditInformation")) {

            String input = null;
            input = dis.readUTF();

            while (true) {

              if (input.equals("edit")) {
                System.out.println("going to edit page");
                input = dis.readUTF();
                System.out.println(input);
                studentList.get(i).setName(input);

                input = dis.readUTF();
                studentList.get(i).setID(input);

                input = dis.readUTF();
                studentList.get(i).setPassword(input);

                input = dis.readUTF();
                studentList.get(i).setContact(input);

                input = dis.readUTF();
              } else break;

            }

          }

          //student trying to view report card
          else if (received.equals("view result")) {
            System.out.println(studentList.get(i).getTakenCourse(0));
            dos.writeUTF(studentList.get(i).getTakenCourse(0));
            dos.flush();
            System.out.println(studentList.get(i).getTakenCourse(1));
            dos.writeUTF(studentList.get(i).getTakenCourse(1));
            dos.flush();

            dos.writeUTF(studentList.get(i).getName());
            dos.flush();

            dos.writeUTF(studentList.get(i).getSemester());
            dos.flush();

            dos.writeUTF(studentList.get(i).getYear());
            dos.flush();

            dos.writeUTF(studentList.get(i).getCgpa());
            dos.flush();


          } else if (received.equals("go to home")) {
            break;
          }
        }

      }
    }catch(Exception e){
        System.out.println(e);
      }
    }


      //calculating result


  public static void calculateResult()
  {

    double marks;

      for(int i=0;i<studentList.size();i++)
      {
        double cg = 0;
        double sum = 0;
        double totalCredit = 0;
         HashMap<String, Double> stumark = new HashMap<>();
        stumark = studentList.get(i).getMarks();
        for(int j=0;j<2;j++) {

          String crsname = studentList.get(i).getTakenCourse(j);
          marks = stumark.get(crsname);
          //System.out.println(studentList[i].getName()+" "+crs.getName()+" "+marks);
          sum+= cgForNum(marks)*credit;
          totalCredit = totalCredit+ credit;
        }
        cg = sum / totalCredit;
        studentList.get(i).setcgpa(cg);
        System.out.println(studentList.get(i).getName()+" "+studentList.get(i).getCgpa());

      }
  }

    //Grading result

  public static double cgForNum(double num)
  {
    if(num>=80)
      return 4.00;
    else if(num>=75)
      return 3.75;
    else if(num>=70)
      return 3.5;
    if(num>=65)
      return 3.25;
    else if(num>=60)
      return 3.00;
    else if(num>=55)
      return 2.75;
    else if(num>=50)
      return 2.5;
    if(num>=45)
      return 2.25;
    else if(num>=40)
      return 2.00;
    else
      return 0;
  }
  public void resetSystem()
  {
  }


}
