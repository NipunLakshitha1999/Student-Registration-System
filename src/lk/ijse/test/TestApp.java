package lk.ijse.test;

import lk.ijse.DAO.HibernateUtil;
import lk.ijse.Entity.CourseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TestApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory( );
        Session session = sessionFactory.openSession( );
        Transaction transaction = session.beginTransaction( );
        CourseEntity courseEntity = new CourseEntity("CS001", "GDSE", "jkisd", 2, 200);
        session.save(courseEntity);
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
