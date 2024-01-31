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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
public class UpdatebyTeacher extends Stage {

    public UpdatebyTeacher (String TeacherID){
        HBox hBox  = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setMinHeight(400);
        hBox.setMinWidth(700);
        hBox.setSpacing(30);


        Button UpdateMarks = new Button("Update marks");
        Button edit = new Button("Edit Information");
        Button back = new Button("back");

        hBox.getChildren().addAll(UpdateMarks,edit,back);

        Stage stage =new Stage();
        Scene scene = new Scene(hBox);

        edit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditTeachersInformation editTeachersInformation = new EditTeachersInformation(TeacherID);
                stage.close();
            }
        });
        UpdateMarks.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MarkUpdateByTeacher markUpdateByTeacher = new MarkUpdateByTeacher(TeacherID);
                stage.close();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TeacherLogin teacherLogin = new TeacherLogin();
                stage.close();
            }
        });

        stage.setScene(scene);
        stage.setTitle("Update by teacher");
        stage.show();

    }
}
