package lk.ijse.DTO;

import lk.ijse.Entity.StudentEntity;

public class StudenDTO {
    private String SID;
    private String SName;
    private String SAddress;
    private int SContact;
    private String SDOB;
    private String SGender;

    public StudenDTO(StudentEntity studentEntity) {
    }

    public StudenDTO(String SID, String SName, String SAddress, int SContact, String SDOB, String SGender) {
        this.SID = SID;
        this.SName = SName;
        this.SAddress = SAddress;
        this.SContact = SContact;
        this.SDOB = SDOB;
        this.SGender = SGender;
    }


    public String getSID() {
        return SID;
    }

    public void setSID(String SID) {
        this.SID = SID;
    }

    public String getSName() {
        return SName;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }

    public String getSAddress() {
        return SAddress;
    }

    public void setSAddress(String SAddress) {
        this.SAddress = SAddress;
    }

    public int getSContact() {
        return SContact;
    }

    public void setSContact(int SContact) {
        this.SContact = SContact;
    }

    public String getSDOB() {
        return SDOB;
    }

    public void setSDOB(String SDOB) {
        this.SDOB = SDOB;
    }

    public String getSGender() {
        return SGender;
    }

    public void setSGender(String SGender) {
        this.SGender = SGender;
    }
}
