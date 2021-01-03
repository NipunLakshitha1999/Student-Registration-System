package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.BOCustomImpl.CourseBOImpl;
import lk.ijse.BOCustomImpl.RegistrataionBOImpl;
import lk.ijse.BOCustomImpl.StudentBOImpl;
import lk.ijse.DTO.CourseDTO;
import lk.ijse.DTO.RegistrationDTO;
import lk.ijse.DTO.RegistrationResultDTO;
import lk.ijse.DTO.StudenDTO;
import lk.ijse.view.Student;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private TextField txtRegNo;
    @FXML
    private TextField txtRegDate;
    @FXML
    private TextField txtRegFee;
    @FXML
    private ComboBox<String> ComboStudentID;
    @FXML
    private ComboBox<String> ComboCourseOCde;
    @FXML
    private TextField txtBatchNo;
    @FXML
    private Button btnNavRGStudent;
    @FXML
    private Button btnNavRGRegistration;
    @FXML
    private Button btnNavRGCourse;
    @FXML
    private Button btnSaveRegistration;
    @FXML
    private Button btnUpdateRegistration;
    @FXML
    private Button btnDeleteRegistration;

    @FXML
    private TableColumn<RegistrationResultDTO, String> no;

    @FXML
    private TableColumn<RegistrationResultDTO, String> date;

    @FXML
    private TableColumn<RegistrationResultDTO, String> fee;

    @FXML
    private TableColumn<RegistrationResultDTO, String> batct;

    @FXML
    private TableColumn<RegistrationResultDTO, String> S_ID;

    @FXML
    private TableColumn<?, ?> C_ID;

    @FXML
    private TableView<RegistrationDTO> tblRegTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tblRegTable.getColumns( ).get(0).setCellValueFactory(new PropertyValueFactory<>("RegNO"));
        tblRegTable.getColumns( ).get(1).setCellValueFactory(new PropertyValueFactory<>("RegDate"));
        tblRegTable.getColumns( ).get(2).setCellValueFactory(new PropertyValueFactory<>("RegFee"));
        tblRegTable.getColumns( ).get(3).setCellValueFactory(new PropertyValueFactory<>("BNo"));
        tblRegTable.getColumns( ).get(4).setCellValueFactory(new PropertyValueFactory<>("studentID"));
        tblRegTable.getColumns( ).get(5).setCellValueFactory(new PropertyValueFactory<>("CourseID"));

        loadStudentID( );
        loadCourseID( );
        loadRegistrationTable( );

    }

    private void loadRegistrationTable() {
        try {
            ArrayList<RegistrationDTO> registrationDetail = new RegistrataionBOImpl( ).getRegistrationDetail( );
            tblRegTable.setItems(FXCollections.observableArrayList(registrationDetail));
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }

    }

    private void loadCourseID() {
        try {
            ObservableList<String> csIDList = FXCollections.observableList(new CourseBOImpl( ).getCourseID( ));
            ComboCourseOCde.setItems(csIDList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }
    }

    private void loadStudentID() {
        try {
            ObservableList<String> stIDList = FXCollections.observableList(new StudentBOImpl( ).getStudentID( ));
            ComboStudentID.setItems(stIDList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }
    }


    @FXML
    void Drop_ComboStudentID(ActionEvent event) {

    }

    @FXML
    void Key_Press_btnNavRGCourse(ActionEvent event) {

    }

    @FXML
    void Key_Press_btnNavRGRegistration(ActionEvent event) {

    }

    @FXML
    void Key_Press_btnNavRGStudent(ActionEvent event) {

    }

    @FXML
    void Key_Press_txtRegDate(KeyEvent event) {

    }

    @FXML
    void Key_Press_txtRegFee(KeyEvent event) {

    }

    @FXML
    void Key_Press_txtRegNo(KeyEvent event) {

    }

    @FXML
    void btn_Press_btnDeleteRegistration(ActionEvent event) {

        String regNo = txtRegNo.getText( );
    }

    @FXML
    void btn_Press_btnSaveRegistration(ActionEvent event) {
//        no.setCellValueFactory(new PropertyValueFactory<>("RegNO"));
//        date.setCellValueFactory(new PropertyValueFactory<>("RegDate"));
//        fee.setCellValueFactory(new PropertyValueFactory<>("RegFee"));
//        batct.setCellValueFactory(new PropertyValueFactory<>("BNo"));
//        S_ID.setCellValueFactory(new PropertyValueFactory<>("sID"));
//        C_ID.setCellValueFactory(new PropertyValueFactory<>("cID"));


        String regNo = txtRegNo.getText( );
        String regDate = txtRegDate.getText( );
        double regFee = Double.parseDouble(txtRegFee.getText( ));
        int bNo = Integer.parseInt(txtBatchNo.getText( ));
        String sID = ComboStudentID.getSelectionModel( ).getSelectedItem( );
        String cID = ComboCourseOCde.getSelectionModel( ).getSelectedItem( );

        RegistrationDTO regSave = new RegistrationDTO(regNo, regDate, regFee, bNo, new StudenDTO(sID, "", "", 0, "", ""), new CourseDTO(cID, "", "", 0, 0));

        try {
            boolean regSaveUpdate = new RegistrataionBOImpl( ).addRegistration(regSave);
            loadRegistrationTable( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }
    }

    @FXML
    void btn_Press_btnUpdateRegistration(ActionEvent event) {


    }
}
