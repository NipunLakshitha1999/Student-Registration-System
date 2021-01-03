package lk.ijse.Entity;

import javax.persistence.*;

@Entity
public class RegitrationEntity {
    @Id
    private String RegNO;
    private String RegDate;
    private double RegFee;
    private int BNo;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "StudentID",referencedColumnName = "StID",nullable = false)
    private StudentEntity studentEntity;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "CourseID",referencedColumnName = "CsCode",nullable = false)
    private CourseEntity courseEntity;

    public RegitrationEntity() {
    }

    public RegitrationEntity(String regNO, String regDate, double regFee, int BNo, StudentEntity studentEntity, CourseEntity courseEntity) {
        RegNO = regNO;
        RegDate = regDate;
        RegFee = regFee;
        this.BNo = BNo;
        this.studentEntity = studentEntity;
        this.courseEntity = courseEntity;
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

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    public CourseEntity getCourseEntity() {
        return courseEntity;
    }

    public void setCourseEntity(CourseEntity courseEntity) {
        this.courseEntity = courseEntity;
    }

    @Override
    public String toString() {
        return "RegitrationEntity{" +
                "RegNO='" + RegNO + '\'' +
                ", RegDate='" + RegDate + '\'' +
                ", RegFee=" + RegFee +
                ", BNo=" + BNo +
                ", studentEntity=" + studentEntity +
                ", courseEntity=" + courseEntity +
                '}';
    }
}
