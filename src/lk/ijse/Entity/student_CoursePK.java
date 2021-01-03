package lk.ijse.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class student_CoursePK implements Serializable {

    private String StID;
    private String Ccode;
}
