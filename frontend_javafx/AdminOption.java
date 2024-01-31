package StudentResultSystem;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminOption extends Stage {

    public AdminOption(){
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(50);
        hBox.setMinHeight(Region.USE_COMPUTED_SIZE);
        hBox.setMinWidth(Region.USE_COMPUTED_SIZE);



        VBox vBox = new VBox();
        vBox.setMinHeight(400);
        vBox.setMinWidth(700);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        Text text = new Text();
        text.setText("ADMIN OPTION SELECTING");
        text.setStyle("-fx-background-color:whitsmoke");

        //creating Three button for teacher,student and admin login
        Button btn2 = new Button("Add Student");
        Button btn1 = new Button("Add Teacher");
        Button btn3 =  new Button("Remove Student");
        Button btn4 = new Button("Remove Teacher");
        Button back = new Button("back");
        //Button btn3 = new Button("Admin");

        //add all in hBox
        hBox.getChildren().addAll(text,btn1,btn2);


        HBox hBox1 = new HBox();
        hBox1.setAlignment(Pos.CENTER);
        hBox1.setMinWidth(Region.USE_COMPUTED_SIZE);
        hBox1.setMinHeight(Region.USE_COMPUTED_SIZE);
        hBox1.setSpacing(50);

        hBox1.getChildren().addAll(btn3,btn4,back);

        vBox.getChildren().addAll(hBox,hBox1);

        Stage stage = new Stage();

        //creating button action for student login
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //creating StudentLogin object for student
                AdminStudentUpdate adminStudentUpdate = new AdminStudentUpdate();
                stage.close();
            }
        });

        //creating button action for teacher login
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //creating Teacher login object for login teacher
                AdminTeacherUpdate adminTeacherUpdate = new AdminTeacherUpdate();
                stage.close();
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            RemoveStudent removeStudent = new RemoveStudent();
            stage.close();
            }
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RemoveTeacher removeTeacher = new RemoveTeacher();
                stage.close();
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AdminLogin adminLogin = new AdminLogin();
                stage.close();
            }
        });

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.setTitle("Admin page");
        stage.show();
    }
}
