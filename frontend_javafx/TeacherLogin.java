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
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class TeacherLogin extends Stage {

    public TeacherLogin() {
        //creating borderpane for some attribute
        BorderPane pane = new BorderPane();
        pane.setMinHeight(400);
        pane.setMinWidth(700);
        // pane.setStyle("-fx-background-color:white");
        VBox vBox = new VBox();
        vBox.setMinHeight(100);
        vBox.setMinWidth(Region.USE_COMPUTED_SIZE);
        vBox.setStyle("-fx-border-color:black;-fx-border-width:0 0 1 0;-fx-background-color:whitesmoke");

        //creating vBox with some attribute
        VBox vBox1 = new VBox();
        vBox1.setMinHeight(Region.USE_COMPUTED_SIZE);
        vBox1.setMinWidth(Region.USE_COMPUTED_SIZE);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(20);

        //creating TextField with some attribute
        TextField User_ID = new TextField();
        User_ID.setPromptText("username");
        User_ID.setMaxWidth(200);
        Label label = new Label();

        //creating passwordfield with some attribute
        PasswordField PassWord = new PasswordField();
        PassWord.setPromptText("password");
        PassWord.setMaxWidth(200);
        Button btn = new Button("submit");
        Button back = new Button("back");

        //creating stage
        Stage stage = new Stage();

        //button action
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = User_ID.getText();
                String password = PassWord.getText();
                try {
                    File tID_Pass = new File("C:/Users/borhan/Desktop/StudentResultSystemFileDocument/StudentID_Pass.txt");
                    // if(stID_Pass.exists()) System.out.println("file exists");
                    // else System.out.println("file doesnot exists");
                    Scanner input = new Scanner(tID_Pass);
                    while(input.hasNext()) {
                        String u = input.next();
                        String p = input.next();
                        String id = input.next();
                        //System.out.println(u+" "+p);
                        if(username.equals(u) && password.equals(p)){
                             UpdatebyTeacher updatebyTeacher = new UpdatebyTeacher(id);
                            stage.close();
                        }

                    }
                    input.close();
                    label.setText("something went wrong");
                }catch (Exception e) {
                    System.out.println(e);
                }
                label.setText("");
            }
        });

        //back button action for previous page
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Home home = new Home();
                home.start(stage);
                //stage.close();
            }
        });

        //adding all
        vBox1.getChildren().addAll(User_ID, PassWord, btn,back, label);
        pane.setTop(vBox);
        pane.setCenter(vBox1);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Teacher login page");
        stage.show();



    }
}
