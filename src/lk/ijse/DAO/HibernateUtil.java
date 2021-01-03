package lk.ijse.DAO;

import lk.ijse.Entity.CourseEntity;
import lk.ijse.Entity.RegitrationEntity;
import lk.ijse.Entity.StudentEntity;
import lk.ijse.view.Course;
import lk.ijse.view.Registration;
import lk.ijse.view.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry sReg = new StandardServiceRegistryBuilder( ).loadProperties("application.properties").build( );

        Metadata mData = new MetadataSources(sReg).addAnnotatedClass(CourseEntity.class)
                .addAnnotatedClass(StudentEntity.class)
                .addAnnotatedClass(RegitrationEntity.class)
                .getMetadataBuilder().build( );

        return mData.getSessionFactoryBuilder().build();
    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
