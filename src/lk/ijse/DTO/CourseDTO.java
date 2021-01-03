package lk.ijse.DTO;

import lk.ijse.Entity.CourseEntity;

public class CourseDTO {
    private String CCode;
    private String CName;
    private String CType;
    private int CDuration;
    private double CFee;

    public CourseDTO() {
    }

    public CourseDTO(CourseEntity courseEntity) {
    }

    public CourseDTO(String CCode, String CName, String CType, int CDuration, double CFee) {
        this.CCode = CCode;
        this.CName = CName;
        this.CType = CType;
        this.CDuration = CDuration;
        this.CFee = CFee;
    }

    public String getCCode() {
        return CCode;
    }

    public void setCCode(String CCode) {
        this.CCode = CCode;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCType() {
        return CType;
    }

    public void setCType(String CType) {
        this.CType = CType;
    }

    public int getCDuration() {
        return CDuration;
    }

    public void setCDuration(int CDuration) {
        this.CDuration = CDuration;
    }

    public double getCFee() {
        return CFee;
    }

    public void setCFee(double CFee) {
        this.CFee = CFee;
    }
}
