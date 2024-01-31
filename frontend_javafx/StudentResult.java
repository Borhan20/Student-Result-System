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

import java.io.File;
import java.util.Scanner;

public class StudentResult extends Stage {
    public StudentResult(String roll) {

        //creating grid
        GridPane root = new GridPane();

        root.setAlignment(Pos.CENTER);
        root.setMinHeight(400);
        root.setMinWidth(700);
        root.setVgap(10);
        root.setHgap(10);

        //creating some textfield and label using mapping
        Label Credit = new Label("Credit per sub 3");

        Label Name = new Label("Student Name     :         ");
        Text text1 = new Text();
        text1.setText("--");
        Label Institution = new Label("Institution            :         ");
        Text text2 = new Text("--");
        Label Semester = new Label("Semester              :         ");
        Text text3 = new Text("--");

        Label Year = new Label("Year                :         ");
        Text text10 = new Text();
        Label contactNo = new Label("Contact No         :        ");
        Text text11 = new Text();

        Label Blood = new Label("Blood group:         :         ");
        Text text12 = new Text();

        Label course1 = new Label("Course1                :         ");
        Text text4 = new Text("--");
        Label course2 = new Label("Course2                :         ");
        Text text5 = new Text("--");
        Label course3 = new Label("Course3                :         ");
        Text text6 = new Text("--");
        Label course4 = new Label("Course4                :         ");
        Text text7 = new Text("--");
        Label course5 = new Label("Course5                :         ");
        Text text8 = new Text("--");
        Label CumulativeCgpa = new Label("Cumulative CGPA:         ");
        Text text9 = new Text("--");
        try {
            File Result = new File("C:/Users/borhan/Desktop/StudentResultSystemFileDocument/StudentResult.txt");
            Scanner input = new Scanner(Result);
            while(input.hasNext()){
                String name = input.next();
                String r = input.next();
                if(r.equals(roll)) {
                    text1.setText(name);
                    text2.setText(input.next());
                    text3.setText(input.next());
                    text10.setText(input.next());
                    text11.setText(input.next());
                    text12.setText(input.next());
                    text4.setText(input.next());
                    text5.setText(input.next());
                    text6.setText(input.next());
                    text7.setText(input.next());
                    text8.setText(input.next());
                    text9.setText(input.next());
                    break;
                }
                String c = input.nextLine();
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e);
        }



        //creating back  button for previous page
       // Button edit = new Button("edit iformation");
        Button download = new Button("download");
        Button back = new Button("back");

        //adding all row grid
        root.addRow(0, Credit);
        root.addRow(1, Name, text1);
        root.addRow(2, Institution, text2);
        root.addRow(3, Semester, text3);
        root.addRow(4,Year,text10);
        root.addRow(5,contactNo,text11);
        root.addRow(6,Blood,text12);
        root.addRow(7, course1, text4);
        root.addRow(8, course2, text5);
        root.addRow(9, course3, text6);
        root.addRow(10, course4, text7);
        root.addRow(11, course5, text8);
        root.addRow(12, CumulativeCgpa, text9);
        root.addRow(13, back);

        root.addColumn(12,download);


        //creating new stage
        Stage stage = new Stage();

        download.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        //back button action using event handler
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StudentInformation studentInformation =new StudentInformation(roll);
                stage.close();
            }
        });


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Studet Resulting page");
        stage.show();
    }


}
