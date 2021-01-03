package lk.ijse.BOCustom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.StudenDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface StudentBO extends SuperBO {

    public boolean addStudent(StudenDTO studenDTO) throws ClassNotFoundException, SQLException;
    public boolean updateStudent(StudenDTO studenDTO) throws ClassNotFoundException,SQLException;
    public boolean deleteStudent(String id) throws ClassNotFoundException,SQLException;
    public ArrayList getStudentID() throws ClassNotFoundException,SQLException;
    public ArrayList getStudentDetail() throws ClassNotFoundException,SQLException;
}
