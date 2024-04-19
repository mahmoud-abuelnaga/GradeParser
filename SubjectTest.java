import org.junit.Test;
import static org.junit.Assert.*;

public class SubjectTest {

    Subject subj;

    @Test
    public void getName() {
        subj=new Subject("Math","M01",100);
        assertEquals("Math",subj.getName());
    }

    @Test
    public void getCode() {
        subj=new Subject("Math","M01",100);
        assertEquals("M01",subj.getCode());

    }

    @Test
    public void getFullMark() {
        subj=new Subject("Math","M01",100);
        assertEquals(100,subj.getFullMark());

    }

    @Test
    public void testToString() {
        subj=new Subject("Math","M01",100);
        String expected = "Subject Name: Math Max Mark: 100";

        assertEquals(expected, subj.toString());

    }


    @Test
    public void TestNull() {
        assertNull(subj);
    }
}