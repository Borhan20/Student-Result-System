package StudentResultSystem;


//needed import

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

import javax.jws.soap.SOAPBinding;

public class AdminLogin extends Stage {
    public AdminLogin() {

        //creating borderpane
        BorderPane pane = new BorderPane();
        pane.setMinHeight(400);
        pane.setMinWidth(700);
        // pane.setStyle("-fx-background-color:white");

        //creating vBox with some attribute
        VBox vBox = new VBox();
        vBox.setMinHeight(100);
        vBox.setMinWidth(Region.USE_COMPUTED_SIZE);
        vBox.setStyle("-fx-border-color:black;-fx-border-width:0 0 1 0;-fx-background-color:whitesmoke");

        //creating another vBox with some attribute
        VBox vBox1 = new VBox();
        vBox1.setMinHeight(Region.USE_COMPUTED_SIZE);
        vBox1.setMinWidth(Region.USE_COMPUTED_SIZE);
        vBox1.setAlignment(Pos.CENTER);
        vBox1.setSpacing(20);

        //creating text field
        TextField User_ID = new TextField();
        User_ID.setPromptText("username");
        User_ID.setMaxWidth(200);
        Label label = new Label();

        //creating password field for getting password
        PasswordField PassWord = new PasswordField();
        PassWord.setPromptText("password");
        PassWord.setMaxWidth(200);

        //creating two button for submit and back to previous
        Button btn = new Button("submit");
        Button back = new Button("back");

        //creating a new stage
        Stage stage = new Stage();

        //set an action for submit button
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = User_ID.getText();
                String password = PassWord.getText();
                if (username.equals("java") && password.equals("12345")) {
                    label.setText("success");
                    AdminOption adminOption = new AdminOption();
                    stage.close();

                } else {
                    label.setText("wrong please try again");
                }
            }
        });


        //set an action for back button
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Home home = new Home();
                home.start(stage);
                //stage.close();
            }
        });

        vBox1.getChildren().addAll(User_ID, PassWord, btn, back, label);
        pane.setTop(vBox);
        pane.setCenter(vBox1);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Admin login page");
        stage.show();
    }


}
