package com.jetbrains;

import com.jetbrains.Person;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 * Class Teacher
 */
public class Teacher extends Person {

  //
  // Fields
  //

  protected String rank;

  protected String takingCourse;
  protected  HashMap<String, Double> marks = new HashMap<>();
  protected boolean resultUploaded = false;
  //
  // Constructors
  //
  public Teacher (String name,  String ID, String password, String crs) {

    super(name,   ID , password);
    takingCourse = crs;

  };

  //teacher adding marks

  public void addMarks( String fileName) throws FileNotFoundException {
    java.io.File file = new java.io.File(fileName);
    Scanner in = new Scanner(file);

    while(in.hasNext()) {

      String nm = in.next();
      double num = in.nextDouble();
      //System.out.println(nm+" "+num);
      marks.put(nm,num);
    }


    //System.out.println(takingCourse.getName()+" "+marks.get("tarek11"));
  }

  public  String getID()
  {
    return super.ID;
  }

  public String getName()
  {
    return super.name;
  }

  public String getPassword()
  {
    return  password;
  }


  public void setPassword(String password)
  {
    super.password = password;
  }


  public void  setName(String name)

  {
    super.name  = name;
  }


  public void setID(String Id)
  {
    super.ID = Id;
  }

  public void setContact(String contact)
  {
    super.mobile = contact;
  }

  public void setResulltUploaded(boolean b)
  {
    resultUploaded = b;
  }
  public boolean getResulltUploaded()
  {
    return resultUploaded ;
  }




}
