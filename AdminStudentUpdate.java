package StudentResultSystem;

import com.sun.deploy.xml.BadTokenException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import static java.lang.Integer.parseInt;

public class AdminStudentUpdate extends Stage {
    public AdminStudentUpdate() {

        //creating grid
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setMinHeight(400);
        root.setMinWidth(700);
        root.setVgap(10);
        root.setHgap(10);

        //creating back button for back to previous page
        Button back = new Button("back");
        Button Add = new Button("add");

        //some textfield and label
        Label addStudent = new Label("Adding new student");
        Label Name = new Label("Student Name");
        TextField t1 = new TextField();
        Label semester = new Label("Semester");
        TextField t2 = new TextField();
        Label year = new Label("Year");
        TextField t3 = new TextField();
        Label label = new Label();

        //creating new stage
        Stage stage = new Stage();

        //adding all row grid
        root.addRow(0, addStudent);
        root.addRow(1, Name, t1);
        root.addRow(2, semester, t2);
        root.addRow(3,year,t3);
        root.addRow(4,Add);
        root.addRow(5,back);
        root.addRow(6,label);

        //set an action for add student
        Add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String sem = semester.getText();
                String ye = year.getText();
                if((sem.equals("1st"))){
                    label.setText("success");
                }
                else{
                    label.setText("something went wrong");
                }
            }
        });

        //setting an action for back button
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               AdminOption adminOption = new AdminOption();
               stage.close();
            }
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Student Update by Admin");
        stage.show();
    }
}
