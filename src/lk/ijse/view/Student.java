package lk.ijse.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Student extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("StudentFram.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("srudent");
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);


    }
}
