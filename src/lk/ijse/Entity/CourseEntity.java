package lk.ijse.Entity;

import lk.ijse.DTO.CourseDTO;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class CourseEntity {
    @Id
    private String CsCode;
    private String CsName;
    private String CsType;
    private int CsDuration;
    private double CsFee;

    @OneToMany(mappedBy = "courseEntity",cascade = CascadeType.ALL)
    private List<RegitrationEntity> regitrationEntity;

    public CourseEntity() {
    }

    public CourseEntity(CourseDTO courseDTO) {
    }

    public CourseEntity(String csCode, String csName, String csType, int csDuration, double csFee) {
        CsCode = csCode;
        CsName = csName;
        CsType = csType;
        CsDuration = csDuration;
        CsFee = csFee;
    }

    public String getCsCode() {
        return CsCode;
    }

    public void setCsCode(String csCode) {
        CsCode = csCode;
    }

    public String getCsName() {
        return CsName;
    }

    public void setCsName(String csName) {
        CsName = csName;
    }

    public String getCsType() {
        return CsType;
    }

    public void setCsType(String csType) {
        CsType = csType;
    }

    public int getCsDuration() {
        return CsDuration;
    }

    public void setCsDuration(int csDuration) {
        CsDuration = csDuration;
    }

    public double getCsFee() {
        return CsFee;
    }

    public void setCsFee(double csFee) {
        CsFee = csFee;
    }

    public List<RegitrationEntity> getRegitrationEntity() {
        return regitrationEntity;
    }

    public void setRegitrationEntity(List<RegitrationEntity> regitrationEntity) {
        this.regitrationEntity = regitrationEntity;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "CsCode='" + CsCode + '\'' +
                ", CsName='" + CsName + '\'' +
                ", CsType='" + CsType + '\'' +
                ", CsDuration=" + CsDuration +
                ", CsFee=" + CsFee +
                '}';
    }
}
