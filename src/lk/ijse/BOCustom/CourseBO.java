package lk.ijse.BOCustom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.CourseDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CourseBO extends SuperBO {

    public boolean addCourse(CourseDTO courseDTO) throws ClassNotFoundException, SQLException;
    public boolean updateCourse(CourseDTO courseDTO) throws ClassNotFoundException,SQLException;
    public boolean deleteCourse(String id) throws ClassNotFoundException,SQLException;
    public ArrayList getCourseID() throws ClassNotFoundException,SQLException;
    public ArrayList<CourseDTO> getCourseDetail() throws ClassNotFoundException,SQLException;
    public ArrayList<CourseDTO> getCourseDetailOfStudent(String id) throws ClassNotFoundException,SQLException;

}
