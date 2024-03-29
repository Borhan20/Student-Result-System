/*
 * Student result System application
 *
 * version : 1.00
 *
 * Copyright protected
 *
 * author name : 1. Arnob
 *               2. Zulker
 *               3. Borhan
 *
 */


package com.jetbrains;

import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.net.*;



public class Main {


    public static void main(String[] args) throws IOException {





       //connect  with the client

        ServerSocket ss = new ServerSocket(504);
        // running infinite loop for getting
        // client request
        while (true) {
            Socket s = null;

            try {
                // socket object to receive incoming client requests
                s = ss.accept();

                System.out.println("A new client is connected : " + s);

                // obtaining input and out streams
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

         //       System.out.println("Assigning new thread for this client");

                // create a new thread object
                Thread t = new ClientHandler(s, dis, dos);

                // Invoking the start() method
                t.start();

            } catch (Exception e) {
                s.close();
                e.printStackTrace();
            }


        }
    }
}
