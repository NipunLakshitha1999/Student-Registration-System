package lk.ijse.BO;

import lk.ijse.BOCustomImpl.CourseBOImpl;
import lk.ijse.BOCustomImpl.RegistrataionBOImpl;
import lk.ijse.BOCustomImpl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){}

    public enum BoType{
        STUDENT,REGISTRATION,COURSE
    }
    public static  SuperBO getBOType(BoType type){
        switch (type){
            case COURSE:return  new CourseBOImpl();
            case REGISTRATION: return  new RegistrataionBOImpl();
            case STUDENT:return new StudentBOImpl();
            default:return null;
        }
    }
}
