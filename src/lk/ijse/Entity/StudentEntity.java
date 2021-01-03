package lk.ijse.Entity;

import lk.ijse.DTO.StudenDTO;
import lk.ijse.view.Registration;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class StudentEntity {
    @Id
    private String StID;
    private String StName;
    private String StAddress;
    private int StContact;
    private String StDOB;
    private String StGender;

    @OneToMany(mappedBy = "studentEntity",cascade = CascadeType.ALL)
    private List<RegitrationEntity> regitrationEntity;

    public StudentEntity() {
    }

    public StudentEntity(StudenDTO studenDTO) {
    }

    public StudentEntity(String stID, String stName, String stAddress, int stContact, String stDOB, String stGender) {
        StID = stID;
        StName = stName;
        StAddress = stAddress;
        StContact = stContact;
        StDOB = stDOB;
        StGender = stGender;
    }

    public String getStID() {
        return StID;
    }

    public void setStID(String stID) {
        StID = stID;
    }

    public String getStName() {
        return StName;
    }

    public void setStName(String stName) {
        StName = stName;
    }

    public String getStAddress() {
        return StAddress;
    }

    public void setStAddress(String stAddress) {
        StAddress = stAddress;
    }

    public int getStContact() {
        return StContact;
    }

    public void setStContact(int stContact) {
        StContact = stContact;
    }

    public String getStDOB() {
        return StDOB;
    }

    public void setStDOB(String stDOB) {
        StDOB = stDOB;
    }

    public String getStGender() {
        return StGender;
    }

    public void setStGender(String stGender) {
        StGender = stGender;
    }

    public List<RegitrationEntity> getRegitrationEntity() {
        return regitrationEntity;
    }

    public void setRegitrationEntity(List<RegitrationEntity> regitrationEntity) {
        this.regitrationEntity = regitrationEntity;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "StID='" + StID + '\'' +
                ", StName='" + StName + '\'' +
                ", StAddress='" + StAddress + '\'' +
                ", StContact=" + StContact +
                ", StDOB='" + StDOB + '\'' +
                ", StGender='" + StGender + '\'' +
                '}';
    }
}
