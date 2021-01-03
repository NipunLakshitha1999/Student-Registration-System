package lk.ijse.BOCustomImpl;

import lk.ijse.BOCustom.StudentBO;
import lk.ijse.DAO.HibernateUtil;
import lk.ijse.DTO.StudenDTO;
import lk.ijse.Entity.StudentEntity;
import lk.ijse.view.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    Session session = HibernateUtil.getSessionFactory( ).openSession( );

    @Override
    public boolean addStudent(StudenDTO studenDTO) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        session.save(new StudentEntity(studenDTO.getSID( ), studenDTO.getSName( ), studenDTO.getSAddress( ), studenDTO.getSContact( ), studenDTO.getSDOB( ), studenDTO.getSGender( )));
        tr.commit( );
        session.close( );
        return true;
    }

    @Override
    public boolean updateStudent(StudenDTO studenDTO) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        session.update(new StudentEntity(studenDTO.getSID( ), studenDTO.getSName( ), studenDTO.getSAddress( ), studenDTO.getSContact( ), studenDTO.getSDOB( ), studenDTO.getSGender( )));
        tr.commit( );
        session.close( );
        return true;


    }

    @Override
    public boolean deleteStudent(String id) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        StudentEntity DeleteID = session.get(StudentEntity.class, id);
        session.delete(DeleteID);
        tr.commit( );
        session.close( );
        return true;

    }

    @Override
    public ArrayList getStudentID() throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        List<StudentEntity> stIDlIst = session.createNativeQuery("SELECT * FROM studententity", StudentEntity.class).list( );
        ArrayList listID=new ArrayList();

        for(StudentEntity sID:stIDlIst){
            listID.add(sID.getStID());

        }
        return listID;
    }

    @Override
    public ArrayList<StudenDTO> getStudentDetail() throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        List<StudentEntity> stIDlIst = session.createNativeQuery("SELECT * FROM studententity", StudentEntity.class).list( );
        ArrayList<StudenDTO> listID=new ArrayList();

        for(StudentEntity sID:stIDlIst){
            listID.add(new StudenDTO(sID.getStID(),sID.getStName(),sID.getStAddress(),sID.getStContact(),sID.getStDOB(),sID.getStGender()));

        }
        return listID;
    }
}
