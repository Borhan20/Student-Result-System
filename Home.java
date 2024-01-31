package StudentResultSystem;

import com.sun.glass.ui.Size;
import javafx.application.Application;
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

public class Home extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //creataing hBox
        HBox  hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(50);
        hBox.setMinHeight(400);
        hBox.setMinWidth(700);


        VBox vBox = new VBox();
        Text  text = new Text();
        text.setText("STUDENT RESULT PROCESSING:");
        text.setStyle("-fx-background-color:whitsmoke");

        //creating Three button for teacher,student and admin login
        Button btn1 = new Button("Teacher");
        Button btn2 = new Button("Student");
        Button btn3 = new Button("Admin");

        //add all in hBox
        hBox.getChildren().addAll(text,btn1,btn2,btn3);

        //creating button action for student login
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //creating StudentLogin object for student
                StudentLogin  studentLogin = new StudentLogin();
                primaryStage.close();
            }
        });

        //creating button action for teacher login
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //creating Teacher login object for login teacher
                TeacherLogin teacherLogin = new TeacherLogin();
                primaryStage.close();
            }
        });

        //creating button action for admin update
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                //creating Admin login object for admin login
                AdminLogin adminLogin = new AdminLogin();
                primaryStage.close();
            }
        });
        Scene scene = new Scene(hBox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Home page");
        primaryStage.show();
    }
}
