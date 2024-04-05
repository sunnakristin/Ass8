package is.hi.hbv202g.assignment8;

import org.junit.Test;

public class StudentTest {
    
    @Test
    public void setFeePaidTest() {
        Student student = new Student("John", false);
        student.setFeePaid(true);
        assert student.isFeePaid() == true;
    }
    @Test
    public void isFeePaidTest() {
        Student student = new Student("John", true);
        assert student.isFeePaid() == true;
    }
}
