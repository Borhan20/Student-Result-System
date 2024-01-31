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

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Formatter;


public class MarkUpdateByTeacher extends Stage {
    public MarkUpdateByTeacher(String TeacherID) {

        //creating Gridpane
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setMinWidth(700);
        root.setMinHeight(400);
        root.setVgap(10);
        root.setHgap(10);

        //creating two button
        Button back = new Button("back");
       // Button submit = new Button("submit");
        Button upload = new Button("UploadFile");
        Button manually = new Button("Manually");

        //creating some textfield and level usign maping

        Label setResult = new Label("Set Result");
        Label year = new Label("year: ");
        TextField txt1 = new TextField();
        Label semester = new Label("Semester");
        TextField txt2 = new TextField();
        Label course = new Label("Course");
        TextField txt3 = new TextField();

        Label label = new Label();

        //creating new stage
        Stage stage = new Stage();

        //submit button action using event handler
        upload.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {


                String y = txt1.getText();
                //int y1 = Integer.parseInt(y);
                String s = txt2.getText();
            }
        });

        manually.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String y = txt1.getText();
                String s = txt2.getText();

                ManuallyTeacherMarkUpdate manuallyTeacherMarkUpdate = new ManuallyTeacherMarkUpdate(TeacherID);
                stage.close();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UpdatebyTeacher updatebyTeacher =new UpdatebyTeacher(TeacherID);
                stage.close();
            }
        });

        //addding all row grid
        root.addRow(0, setResult);
        root.addRow(1, year, txt1);
        root.addRow(2, semester, txt2);
        root.addRow(3,course,txt3);
        root.addRow(4,upload);
        root.addRow(5,manually);
        root.addRow(6,label);
        root.addColumn(10, back);


        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Updated marks by Teacher");
        stage.show();
    }


}
