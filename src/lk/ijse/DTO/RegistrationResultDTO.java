package lk.ijse.DTO;

import lk.ijse.Entity.CourseEntity;
import lk.ijse.Entity.StudentEntity;

public class RegistrationResultDTO {
    private String RegNO;
    private String RegDate;
    private double RegFee;
    private int BNo;
    private String sID;
    private String cID;

    public RegistrationResultDTO() {
    }

    public RegistrationResultDTO(String regNO, String regDate, double regFee, int BNo, String sID, String cID) {
        RegNO = regNO;
        RegDate = regDate;
        RegFee = regFee;
        this.BNo = BNo;
        this.sID = sID;
        this.cID = cID;
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

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    @Override
    public String toString() {
        return "RegistrationResultDTO{" +
                "RegNO='" + RegNO + '\'' +
                ", RegDate='" + RegDate + '\'' +
                ", RegFee=" + RegFee +
                ", BNo=" + BNo +
                ", sID='" + sID + '\'' +
                ", cID='" + cID + '\'' +
                '}';
    }
}
