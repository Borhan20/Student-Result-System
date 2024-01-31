package StudentResultSystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RemoveTeacher extends Stage {

    public RemoveTeacher(){
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setMinHeight(400);
        root.setMinWidth(700);
        root.setHgap(10);
        root.setVgap(10);

        //creating back button for back to previous page
        Button back = new Button("back");
        Button remove = new Button("remove");

        //some textfield and label
        Label AddTeacher = new Label("Removing teacher");
        Label Name = new Label("teacher Name");
        TextField t1 = new TextField();
        Label semester = new Label("Semester");
        TextField t2 = new TextField();
        Label year = new Label("Year");
        TextField t3 = new TextField();
        Label label = new Label();
        Label Course = new Label("course");
        TextField t4 = new TextField();

        //creating new stage
        Stage stage = new Stage();

        //adding all row grid
        root.addRow(0, AddTeacher);
        root.addRow(1, Name, t1);
        root.addRow(2, semester, t2);
        root.addRow(3,Course,t4);
        root.addRow(4,year,t3);
        root.addRow(5,remove);
        root.addRow(6,back);
        root.addRow(7,label);

        //set an action for add student
        remove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String sem = semester.getText();
                String ye = year.getText();
                if((sem.equals("1st")||(sem.equals("2nd")))) {
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
                AdminOption  adminOption = new AdminOption();
                stage.close();
            }
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Admin teacher Update page");
        stage.show();
    }
}
