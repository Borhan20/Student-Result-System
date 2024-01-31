package com.jetbrains;

import com.jetbrains.Person;

import java.util.HashMap;

/**
 * Class Student
 */
public class Student extends Person {

  //
  // Fields
  //


  protected String rollNo;
  protected int coursecnt = 0;
  protected String[] taken = new String[3];

  protected String semester = "--";
  protected String year = "--";
  protected String mobile = "--";
  protected HashMap<String, Double> marks = new HashMap<>();
  protected double cgpa =0 ;
  //
  // Constructors
  //
  public Student (String name, String ID,String password,String semester, String year, String crs, String crs2) {

    super(name,  ID,password);

    this.semester = semester;
    this.year = year;
    taken[0] = crs;
    taken[1] = crs2;
  };


  // adding courses in array

  public void addCourse(String course)
  {
    taken[coursecnt++] = course;
  }

  public void addMaks(String crs, double mark)
  {
    marks.put(crs,mark);
    System.out.println(crs+mark);
  }
  // prints the list of taken courses

  /*
  public void takenCourses()
  {
    System.out.println(taken[0].getName());
    System.out.println(taken[1].getName());
  }
*/
  public String getTakenCourse(int ind)
  {
    //System.out.println(taken[ind].getName());
    return taken[ind];
  }

  //getting student ID

  public  String getID()
  {
    return super.ID;
  }
  //getting cgpa
  public String getCgpa()
  {
    if(cgpa == 0)
    {
      return "Result Not published yet";
    }
    String cg = Double.toString(cgpa);
    return cg;
  }

  //setting cgpa

  public void setcgpa(double cg)
  {
    cgpa = cg;
  }

  //showing cgpa

  public void showCG()
  {
    System.out.println("Name : "+name+" "+cgpa);
  }



  public String getName()
  {
    return super.name;
  }

  public String getPassword()
  {
    return super.password;
  }

  public String getSemester()
  {
    return semester;
  }

  public String getYear()
  {
    return year;
  }

  public void setPassword(String password)
  {
    super.password = password;
  }

  public void setSemester(String semester)
  {
    this.semester = semester;
  }

  public void setYear(String year)
  {
    this.year=year;
  }

  public void  setName(String name)

  {
    super.name  = name;
  }

  public void setContact(String contact)
  {
    super.mobile = contact;
  }

  public void setID(String Id)
  {
    super.ID = Id;
  }

  public HashMap<String, Double> getMarks() {
    return marks;
  }

  public void viewReport()
  {
  }


}
