package lk.ijse.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Registration extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass( ).getResource("RegistrationFram.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Registration");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
