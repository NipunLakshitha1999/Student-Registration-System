package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.BO.BOFactory;
import lk.ijse.BOCustom.StudentBO;
import lk.ijse.BOCustomImpl.StudentBOImpl;
import lk.ijse.DTO.StudenDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentCotroller implements Initializable {
    StudentBO studentBO= (StudentBO) BOFactory.getBOType(BOFactory.BoType.STUDENT);
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConfigureStudentTable();
        loadStudentTable();
    }

    private void loadStudentTable() {
        try {
            ObservableList<StudenDTO> list= FXCollections.observableList(new StudentBOImpl().getStudentDetail());
            StudentTable.setItems(list);
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }
    }


    @FXML
    private AnchorPane tblStudent;

    @FXML
    private TableView<StudenDTO> StudentTable;

    @FXML
    private TextField txtStudentID;

    @FXML
    private TextField txtStudentName;

    @FXML
    private TextField txtStudentAddress;

    @FXML
    private TextField txtStudentContact;

    @FXML
    private TextField txtStudentDOB;

    @FXML
    private TextField txtStudentGender;

    @FXML
    private TextField txtStudent;

    @FXML
    private Button btnNavSTStudent;

    @FXML
    private Button btnNavSTRegistration;

    @FXML
    private Button btnNavSTCourse;

    @FXML
    private Button btnSaveStudent;

    @FXML
    private Button btnUpdateStudent;

    @FXML
    private Button btnDeleteStudent;


    @FXML
    void Key_Pressed_txtStudent(KeyEvent event) {

    }

    @FXML
    void Key_Pressed_txtStudentGender(KeyEvent event) {

    }

    @FXML
    void Key_Pressed_txtStudentAddress(KeyEvent event) {

    }

    @FXML
    void Key_Pressed_txtStudentContact(KeyEvent event) {

    }

    @FXML
    void Key_Pressed_txtStudentDOB(KeyEvent event) {

    }

    @FXML
    void Key_Pressed_txtStudentID(KeyEvent event) {

    }

    @FXML
    void On_Action_BtnNavSTCourse(ActionEvent event) {

    }

    @FXML
    void On_Action_BtnNavSTRegistration(ActionEvent event) {

    }

    @FXML
    void On_Action_BtnNavSTStudent(ActionEvent event) {

    }

    @FXML
    void btnDeleteStudent_Press(ActionEvent event) {
        String id=txtStudentID.getText();
        try {
            boolean deleteStudentResult = studentBO.deleteStudent(id);
            loadStudentTable();
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }

    }

    @FXML
    void btnSaveStudent_Press(ActionEvent event) {
        String id=txtStudentID.getText();
        String name=txtStudentName.getText();
        String address=txtStudentAddress.getText();
        int contact=Integer.parseInt(txtStudentContact.getText());
        String date=txtStudentDOB.getText();
        String gender=txtStudentGender.getText();

        try {
            boolean addStudentResult = studentBO.addStudent(new StudenDTO(id,name,address,contact,date,gender));
            loadStudentTable();
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }

    }
    

    @FXML
    void btnUpdateStudent_Press(ActionEvent event) {
        String id=txtStudentID.getText();
        String name=txtStudentName.getText();
        String address=txtStudentAddress.getText();
        int contact=Integer.parseInt(txtStudentContact.getText());
        String date=txtStudentDOB.getText();
        String gender=txtStudentGender.getText();

        try {
            boolean updateStudentResult = studentBO.updateStudent(new StudenDTO(id, name, address, contact, date, gender));
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }

    }

    @FXML
    void key_Pressed_txtStudentName(KeyEvent event) {

    }

    private void ConfigureStudentTable() {
        StudentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("SID"));
        StudentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("SName"));
        StudentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("SAddress"));
        StudentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("SContact"));
        StudentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("SDOB"));
        StudentTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("SGender"));
    }
}
