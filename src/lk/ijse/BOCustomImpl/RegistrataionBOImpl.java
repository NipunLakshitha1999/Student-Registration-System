package lk.ijse.BOCustomImpl;

import lk.ijse.BOCustom.RegistrationBO;
import lk.ijse.DAO.HibernateUtil;
import lk.ijse.DTO.CourseDTO;
import lk.ijse.DTO.RegistrationDTO;
import lk.ijse.DTO.RegistrationResultDTO;
import lk.ijse.DTO.StudenDTO;
import lk.ijse.Entity.CourseEntity;
import lk.ijse.Entity.RegitrationEntity;
import lk.ijse.Entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrataionBOImpl implements RegistrationBO {

    Session session = HibernateUtil.getSessionFactory( ).openSession( );

    @Override
    public boolean addRegistration(RegistrationDTO registrationDTO) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        StudentEntity studentEntity = session.get(StudentEntity.class, registrationDTO.getStudenDTO().getSID());
        CourseEntity courseEntity = session.get(CourseEntity.class, registrationDTO.getCourseDTO().getCCode());
        RegitrationEntity regDe = new RegitrationEntity(registrationDTO.getRegNO( ), registrationDTO.getRegDate( ), registrationDTO.getRegFee( ), registrationDTO.getBNo( ), studentEntity, courseEntity);
        System.out.println(regDe);
        session.save(regDe);
        tr.commit( );
        session.close( );
        return false;
    }

    @Override
    public boolean updateRegistration(RegistrationDTO registrationDTO) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean deleteRegistration(String id) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public ArrayList<RegistrationDTO> getRegistrationDetail() throws ClassNotFoundException, SQLException {

        Transaction tr = session.beginTransaction( );
        List<RegitrationEntity> rsIDlIst = session.createNativeQuery("SELECT * FROM regitrationentity", RegitrationEntity.class).list( );
        ArrayList<RegistrationDTO> listID = new ArrayList<>( );

        for (RegitrationEntity rsID : rsIDlIst) {
            StudenDTO s=new StudenDTO(rsID.getStudentEntity().getStID(),rsID.getStudentEntity().getStName(),rsID.getStudentEntity().getStAddress(),rsID.getStudentEntity().getStContact(),rsID.getStudentEntity().getStDOB(),rsID.getStudentEntity().getStGender());
            CourseDTO c=new CourseDTO(rsID.getCourseEntity().getCsCode(),rsID.getCourseEntity().getCsName(),rsID.getCourseEntity().getCsType(),rsID.getCourseEntity().getCsDuration(),rsID.getCourseEntity().getCsFee());
            listID.add(new RegistrationDTO(rsID.getRegNO( ), rsID.getRegDate( ), rsID.getRegFee( ), rsID.getBNo( ),s.getSID(),c.getCCode()));

        }

        tr.commit( );
        session.close( );
        return listID;

    }
}
