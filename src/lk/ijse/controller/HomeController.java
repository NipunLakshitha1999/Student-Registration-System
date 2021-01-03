package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.view.Registration;
import lk.ijse.view.Student;
import javafx.scene.Parent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;

public class HomeController implements Initializable {


    @FXML
    private TextField txtHomeSearch;
    @FXML
    private Button btnHomeCourse;

    @FXML
    private Button btnHomeSearchCourse;

    @FXML
    private Button btnHomeStudent;

    @FXML
    private Button btnHomeRegistration;

    private AnchorPane anchorPane;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void ClickbtnHomeStudent(ActionEvent actionEvent) {
        try {
            Parent root= FXMLLoader.load(getClass( ).getResource("../view/StudentFram.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Student");
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage() );
        }

    }

    public void ClickbtnHomeRegistration(ActionEvent actionEvent) {
        try {
            Parent root= FXMLLoader.load(getClass( ).getResource("../view/RegistrationFram.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Regitration");
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage() );
        }
    }

    public void ClickbtnHomeCourse(ActionEvent actionEvent) {
        try {
            Parent root= FXMLLoader.load(getClass( ).getResource("../view/Course.fxml"));
            Stage stage=new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Course");
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage() );
        }
    }

    public void ClickbtnHomeSearchCourse(ActionEvent actionEvent) {
        String id=txtHomeSearch.getId();
        
    }
}
