package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import lk.ijse.BO.BOFactory;
import lk.ijse.BOCustom.CourseBO;
import lk.ijse.BOCustomImpl.CourseBOImpl;
import lk.ijse.DTO.CourseDTO;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CourseController implements Initializable {

    CourseBO cusBO = (CourseBO) BOFactory.getBOType(BOFactory.BoType.COURSE);
    
    @FXML
    public TableView<CourseDTO> tblCourse;
    
    @FXML
    private TextField txtCourseCode;
    
    @FXML
    private TextField txtCourseName;
    
    @FXML
    private TextField txtCouseType;
    
    @FXML
    private TextField txtCourseDuration;
    
    @FXML
    private TextField txtCouseFee;
    
    @FXML
    private Button btnCSSave;
    
    @FXML
    private Button btnCSUpdate;
    
    @FXML
    private Button btnCSDelete;
    
    @FXML
    private TextField txtSearchCourse;
    
    @FXML
    private Button btnSearchCourse;
    
    @FXML
    private Button btnCSRegistration;
    
    @FXML
    private Button btnCSStudent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConfigureCourseTable( );
        loadCourseTable( );
    }

    private void loadCourseTable() {
        try {
            ArrayList<CourseDTO> courseDetail = new CourseBOImpl( ).getCourseDetail( );
            tblCourse.setItems(FXCollections.observableArrayList(courseDetail));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace( );
        }
    }

    private void ConfigureCourseTable() {
        tblCourse.getColumns( ).get(0).setCellValueFactory(new PropertyValueFactory<>("CCode"));
        tblCourse.getColumns( ).get(1).setCellValueFactory(new PropertyValueFactory<>("CName"));
        tblCourse.getColumns( ).get(2).setCellValueFactory(new PropertyValueFactory<>("CType"));
        tblCourse.getColumns( ).get(3).setCellValueFactory(new PropertyValueFactory<>("CDuration"));
        tblCourse.getColumns( ).get(4).setCellValueFactory(new PropertyValueFactory<>("CFee"));
    }

    @FXML
    void Key_Press_txtCourseCode(KeyEvent event) {

    }

    @FXML
    void Key_Press_txtCourseDuration(KeyEvent event) {

    }

    @FXML
    void Key_Press_txtCourseName(KeyEvent event) {

    }

    @FXML
    void Key_Press_txtCouseFee(KeyEvent event) {

    }

    @FXML
    void Key_Press_txtCouseType(KeyEvent event) {

    }

    @FXML
    void clickbtnSearchCourse(ActionEvent event) {

    }

    @FXML
    void btn_Press_btnCSDelete(ActionEvent event) {
        String code = txtCourseCode.getText( );
        try {
            cusBO.deleteCourse(code);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace( );
        }

    }

    @FXML
    void btn_Press_btnCSSave(ActionEvent event) {
        String code = txtCourseCode.getText( );
        String name = txtCourseName.getText( );
        String type = txtCouseType.getText( );
        int duration = Integer.parseInt(txtCourseDuration.getText( ));
        double fee = Integer.parseInt(txtCouseFee.getText( ));
        try {
            boolean cusSave = cusBO.addCourse(new CourseDTO(code, name, type, duration, fee));
            loadCourseTable( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        }


    }

    @FXML
    void btn_Press_btnCSUpdate(ActionEvent event) {
        String code = txtCourseCode.getText( );
        String name = txtCourseName.getText( );
        String type = txtCouseType.getText( );
        int duration = Integer.parseInt(txtCourseDuration.getText( ));
        double fee = Integer.parseInt(txtCouseFee.getText( ));

        try {
            boolean cusUpdate = cusBO.updateCourse(new CourseDTO(code, name, type, duration, fee));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace( );
        }

    }

    public void click_btnSearchCourse(ActionEvent actionEvent) {
        String StID = txtSearchCourse.getText( );
        try {
            ArrayList<CourseDTO> courseDetailOfStudent = new CourseBOImpl( ).getCourseDetailOfStudent(StID);
            tblCourse.setItems(FXCollections.observableArrayList(courseDetailOfStudent));
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace( );
        }


    }

    public void btnClickbtnCSStudent(ActionEvent actionEvent) {
    }

    public void tnClickbtnCSRegistration(ActionEvent actionEvent) {
    }
}
