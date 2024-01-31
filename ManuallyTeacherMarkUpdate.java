package StudentResultSystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ManuallyTeacherMarkUpdate extends Stage {
    public ManuallyTeacherMarkUpdate(String TeacherID){

        HBox hBox = new HBox();
        hBox.setMinWidth(700);
        hBox.setMinHeight(400);
        hBox.setAlignment(Pos.CENTER);

        Button back = new Button("back");
        Button submit = new Button("submit");

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setMinHeight(300);
        vBox.setMinWidth(200);
        vBox.setSpacing(20);

        Label label = new Label("Student Roll:");
        TextField textField = new TextField();
        textField.setMinHeight(150);
        textField.setMinWidth(60);
        vBox.getChildren().addAll(label,textField,submit);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(20);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setMinHeight(300);
        vBox1.setMinWidth(200);

        Label label1 = new Label("Student Marks");
        TextField textField1 = new TextField();
        textField1.setMinHeight(150);
        textField1.setMinWidth(60);

        vBox1.getChildren().addAll(label1,textField1,back);

        hBox.getChildren().addAll(vBox,vBox1);

        Scene scene = new Scene(hBox);
        Stage stage = new Stage();

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MarkUpdateByTeacher markUpdateByTeacher = new MarkUpdateByTeacher(TeacherID);
                stage.close();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Manually mark update");
        stage.show();


    }
}
