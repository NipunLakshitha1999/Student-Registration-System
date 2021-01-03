package lk.ijse.BOCustom;

import lk.ijse.BO.SuperBO;
import lk.ijse.DTO.CourseDTO;
import lk.ijse.DTO.RegistrationDTO;
import lk.ijse.DTO.RegistrationResultDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RegistrationBO extends SuperBO {

    public boolean addRegistration(RegistrationDTO registrationDTO) throws ClassNotFoundException, SQLException;
    public boolean updateRegistration(RegistrationDTO registrationDTO) throws ClassNotFoundException,SQLException;
    public boolean deleteRegistration(String id) throws ClassNotFoundException,SQLException;
    public ArrayList<RegistrationDTO> getRegistrationDetail() throws ClassNotFoundException,SQLException;
}
