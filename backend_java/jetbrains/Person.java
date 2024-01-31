package com.jetbrains;

/**
 * Class Person
 */
import java.util.*;
import java.io.*;
public class Person {

  //
  // Fields
  //

  protected String name;
  protected  String password;
  protected String mobile;
  protected String email;
  protected String ID;
  
  //
  // Constructors
  //
  public Person (String name,  String ID,String password ) {

    this.name = name;
    this.ID = ID;
    this.password = password;

  };

  //logging in ...
  public void logIn( String ID,String pass) throws FileNotFoundException {
    java.io.File file = new java.io.File("C:\\Users\\USER\\IdeaProjects\\Student Result System\\src\\com\\jetbrains\\studentLogin.txt");
    Scanner in = new Scanner(file);
    //System.out.println("asche");
    while(in.hasNext()) {


      String nam = in.next();

      String passw = in.next();
      String id = in.next();
      //System.out.println(nam+" "+passw+" "+id);
      if (passw.equals(password) && id.equals(ID)) {
        System.out.println("Login successful "+name);
        break;
      }
    }
  }


  public void viewInformation()
  {
  }


}
