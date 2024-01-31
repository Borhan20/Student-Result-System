package com.jetbrains;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.net.*;

import static com.jetbrains.Admin.*;

public class ClientHandler extends Thread
{

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    String passdefault = "1234";


    // Constructor
    // connecting to network
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run()
    {
        String received;
        String toReturn;
        Admin admin = new Admin(s,dis,dos);
        while (true) {
            try {

                // receive the answer from client
                received = dis.readUTF();

                System.out.println(received);
                //admin tries to log in
                if (received.equals("adminTryToLog")) {

                    admin.adminLogin(received,s,dis,dos);

                    //teacher is trying to log in
                } else if (received.equals("teacherTryToLogIn")) {

                    admin.teacherLogin(received,s,dis,dos);

                }
                //student trying to log in
                else if (received.equals("studentTryToLogIn")) {

                    admin.studentLogin(received,s,dis,dos);


                } else if (received.equals("Exit To Home")) {

                }

                //shut program if close button is pressed
                else if(received.equals("Shut Program"))
                {
                    break;
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }


            try
        {
            // closing resources
            this.dis.close();
            this.dos.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
