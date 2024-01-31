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
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class EditStudentInformation extends Stage {

    public EditStudentInformation(String roll){

        GridPane pane  = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setMinHeight(400);
        pane.setMinWidth(700);
        pane.setHgap(10);
        pane.setVgap(10);


        Label label = new Label("Edit Information");

        Label User_id = new Label("User ID");
        TextField textField = new TextField();
        Label Password = new Label("Password");
        TextField textField1 = new TextField();
        Label Name = new Label("Student Name");
        TextField textField2 = new TextField();
        Label ContactNO = new Label("Contact No");
        TextField textField3 = new TextField();

        //Label Adress = new Label("Address");
        //TextField textField4 = new TextField();
        Label BloodGroup = new Label("Blood Group");
        TextField textField5 = new TextField();
        Label comment = new Label();

        try{

            File stId_pass = new File("C:/Users/borhan/Desktop/StudentResultSystemFileDocument/StudentResult.txt");
            Formatter formatter = new Formatter(stId_pass);
            Scanner scanner = new Scanner(stId_pass);
            String uName = textField.getText();
            String pWord = textField1.getText();
            while(scanner.hasNext()){

                String u = scanner.next();
                String p= scanner.next();
                String r = scanner.next();

                if(r.equals(roll)){
                    formatter.format("%s %s %s\r\n",uName,pWord,r);
                    break;
                }

            }
            formatter.close();

        }catch(Exception e) {
            System.out.println(e);
        }


        try{

            File file = new File("C:/Users/borhan/Desktop/StudentResultSystemFileDocument/StudentResult.txt");


        }catch (Exception e) {
            System.out.println(e);
        }

        Button submit = new Button("submit");
        Button back = new Button("back");

        pane.addRow(0,label);
        pane.addRow(1,User_id,textField);
        pane.addRow(2,Password,textField1);
        pane.addRow(3,Name,textField2);
        pane.addRow(4,ContactNO,textField3);
       // pane.addRow(5,Adress,textField4);
        pane.addRow(5,BloodGroup,textField5);
        pane.addRow(6,submit,back);


        Stage stage = new Stage();
        Scene scene = new Scene(pane);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentInformation studentInformation = new StudentInformation(roll);
                stage.close();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Editing page of student information");
        stage.show();

    }
}
