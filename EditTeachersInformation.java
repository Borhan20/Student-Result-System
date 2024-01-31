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

public class EditTeachersInformation extends Stage {

    public EditTeachersInformation(String TeacherID){
        GridPane pane  = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setMinHeight(400);
        pane.setMinWidth(700);
        pane.setVgap(10);
        pane.setHgap(10);

        Label label = new Label("Edit Information");

        Label User_id = new Label("User ID");
        TextField textField = new TextField();
        Label Password = new Label("Password");
        TextField textField1 = new TextField();
        Label Name = new Label("Teacher Name");
        TextField textField2 = new TextField();
        Label ContactNO = new Label("Contact No");
        TextField textField3 = new TextField();

        Label Adress = new Label("Address");
        TextField textField4 = new TextField();
        Label BloodGroup = new Label("Blood Group");
        TextField textField5 = new TextField();
        Label comment = new Label();

        Button submit = new Button("submit");
        Button back = new Button("back");

        pane.addRow(0,label);
        pane.addRow(1,User_id,textField);
        pane.addRow(2,Password,textField1);
        pane.addRow(3,Name,textField2);
        pane.addRow(4,ContactNO,textField3);
        pane.addRow(5,Adress,textField4);
        pane.addRow(6,BloodGroup,textField5);
        pane.addRow(7,submit,back);


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
                UpdatebyTeacher updatebyTeacher = new UpdatebyTeacher(TeacherID);
                stage.close();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Editing page of Teacher's information");
        stage.show();

    }
}
