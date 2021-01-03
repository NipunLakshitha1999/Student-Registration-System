package lk.ijse.DTO;

import lk.ijse.Entity.CourseEntity;
import lk.ijse.Entity.StudentEntity;

import java.util.Date;

public class RegistrationDTO {
    private String RegNO;
    private String RegDate;
    private double RegFee;
    private int BNo;
    private String studentID;
    private String CourseID;
    private StudenDTO studenDTO;
    private CourseDTO courseDTO;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String regNO, String regDate, double regFee, int BNo, StudenDTO studenDTO, CourseDTO courseDTO) {
        RegNO = regNO;
        RegDate = regDate;
        RegFee = regFee;
        this.BNo = BNo;
        this.studenDTO = studenDTO;
        this.courseDTO = courseDTO;
    }
    public RegistrationDTO(String regNO, String regDate, double regFee, int BNo, String studentID,String courseID) {
        RegNO = regNO;
        RegDate = regDate;
        RegFee = regFee;
        this.BNo = BNo;
        this.studentID=studentID;
        this.CourseID=courseID;
    }


    public String getRegNO() {
        return RegNO;
    }

    public void setRegNO(String regNO) {
        RegNO = regNO;
    }

    public String getRegDate() {
        return RegDate;
    }

    public void setRegDate(String regDate) {
        RegDate = regDate;
    }

    public double getRegFee() {
        return RegFee;
    }

    public void setRegFee(double regFee) {
        RegFee = regFee;
    }

    public int getBNo() {
        return BNo;
    }

    public void setBNo(int BNo) {
        this.BNo = BNo;
    }

    public StudenDTO getStudenDTO() {
        return studenDTO;
    }

    public void setStudenDTO(StudenDTO studenDTO) {
        this.studenDTO = studenDTO;
    }

    public CourseDTO getCourseDTO() {
        return courseDTO;
    }

    public void setCourseDTO(CourseDTO courseDTO) {
        this.courseDTO = courseDTO;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }
}
