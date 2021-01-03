package lk.ijse.BOCustomImpl;

import lk.ijse.BOCustom.CourseBO;
import lk.ijse.DAO.HibernateUtil;
import lk.ijse.DTO.CourseDTO;
import lk.ijse.Entity.CourseEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    Session session = HibernateUtil.getSessionFactory( ).openSession( );

    @Override
    public boolean addCourse(CourseDTO courseDTO) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        CourseEntity cSave = new CourseEntity(courseDTO.getCCode( ), courseDTO.getCName( ), courseDTO.getCType( ), courseDTO.getCDuration( ), courseDTO.getCFee( ));
        session.save(cSave);
        tr.commit( );
        session.close( );
        return true;
    }

    @Override
    public boolean updateCourse(CourseDTO courseDTO) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        CourseEntity cUpdate = new CourseEntity(courseDTO.getCCode( ), courseDTO.getCName( ), courseDTO.getCType( ), courseDTO.getCDuration( ), courseDTO.getCFee( ));
        session.update(cUpdate);
        tr.commit( );
        session.close( );
        return true;
    }

    @Override
    public boolean deleteCourse(String id) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        CourseEntity code = session.get(CourseEntity.class, id);
        session.delete(code);
        tr.commit( );
        session.close( );
        return false;
    }

    @Override
    public ArrayList getCourseID() throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        List<CourseEntity> csIDlIst = session.createNativeQuery("SELECT * FROM courseentity", CourseEntity.class).list( );
        ArrayList listID = new ArrayList( );

        for (CourseEntity cID : csIDlIst) {
            listID.add(cID.getCsCode( ));

        }
        return listID;
    }

    @Override
    public ArrayList<CourseDTO> getCourseDetail() throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        List<CourseEntity> coIDlIst = session.createNativeQuery("SELECT * FROM courseentity", CourseEntity.class).list( );
        ArrayList<CourseDTO> listID = new ArrayList( );

        for (CourseEntity cID : coIDlIst) {
            listID.add(new CourseDTO(cID.getCsCode( ), cID.getCsName( ), cID.getCsType( ), cID.getCsDuration( ), cID.getCsFee( )));

        }
        return listID;
    }

    @Override
    public ArrayList<CourseDTO> getCourseDetailOfStudent(String id) throws ClassNotFoundException, SQLException {
        Transaction tr = session.beginTransaction( );
        NativeQuery<CourseEntity> nativeQuery = session.createNativeQuery("select CsCode,CsName,CsType,CsDuration,CsFee from studententity s,courseentity c,  regitrationentity r where s.StID=r.StudentID AND r.CourseID=c.CsCode AND  s.StID=:code GROUP BY c.CsCode ", CourseEntity.class);
        nativeQuery.setParameter("code", "id");
        List<CourseEntity> list = nativeQuery.list( );
        ArrayList<CourseDTO> listID = new ArrayList<>();

        for (CourseEntity cID : list) {
            listID.add(new CourseDTO(cID.getCsCode( ), cID.getCsName( ), cID.getCsType( ), cID.getCsDuration( ), cID.getCsFee( )));
            System.out.println(new CourseDTO(cID.getCsCode( ), cID.getCsName( ), cID.getCsType( ), cID.getCsDuration( ), cID.getCsFee( )).toString());
        }
        return listID;
    }
}
