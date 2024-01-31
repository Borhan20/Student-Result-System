package StudentResultSystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;
import java.lang.String;


public class StudentInformation extends Stage {

    public StudentInformation(String roll){

        GridPane pane  = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setMinHeight(400);
        pane.setMinWidth(700);
        pane.setHgap(10);
        pane.setVgap(10);



        Label Name = new Label("Student Name     :         ");
        Text text1 = new Text();
        text1.setText("--");
        Label Institution = new Label("Institution            :         ");
        Text text2 = new Text("--");
        Label Semester = new Label("Semester              :         ");
        Text text3 = new Text("--");

        Label Year = new Label("Year                   :        ");
        Text text10 = new Text("--");
        Label contactNo = new Label("Contact No         :        ");
        Text text11 = new Text();

        Label Blood = new Label("Blood group:       :         ");
        Text text12 = new Text();


        try{
            File information = new File("C:/Users/borhan/Desktop/StudentResultSystemFileDocument/StudentResult.txt");
            Scanner input = new Scanner(information);
            while(input.hasNext()) {
                String n = input.next();
                String r = input.next();
                String i= input.next();
                String s = input.next();
                String y = input.next();
                String con= input.next();
                String bd = input.next();
               // System.out.println(n+" "+r+" "+i+" "+s+" "+y);
                if (r.equals(roll)) {
                    text1.setText(n);
                    text2.setText(i);
                    text3.setText(s);
                    text10.setText(y);
                    text11.setText(con);
                    text12.setText(bd);
                    break;
                }
                //String c = input.   nextLine();
                String c1 = input.next();
                String c2 =input.next();
                String c3 = input.next();
                String c4 = input.next();
                String c5 = input.next();
            }
            input.close();

        } catch (Exception e) {
            System.out.println(e);
        }


        Label Req = new Label("Request to change information");


        Button edit = new Button("edit Information");
        Button back = new Button("back");
        Button viewResult = new Button("View result");

        pane.addRow(1, Name, text1);
        pane.addRow(2, Institution, text2);
        pane.addRow(3, Semester, text3);
        pane.addRow(4,Year,text10);
        pane.addRow(5,contactNo,text11);
        pane.addRow(6,Blood,text12);
        pane.addRow(7,edit,back);
        pane.addRow(8, viewResult);


        Stage stage =new Stage();
        Scene scene = new Scene(pane);

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditStudentInformation editStudentInformation = new EditStudentInformation(roll);
                stage.close();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentLogin studentLogin = new StudentLogin();
                stage.close();
            }
        });

        viewResult.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentResult studentResult = new StudentResult(roll);
                stage.close();
            }
        });


        stage.setScene(scene);
        stage.setTitle("Student information");

        stage.show();
    }
}
