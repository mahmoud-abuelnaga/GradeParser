import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void testNulls() {
        subj = new Subject(null, null, 0);

        assertTrue(subj.getName() == "");
        assertTrue(subj.getCode() == "");
        assertEquals(0, subj.getFullMark());
        System.out.println();
        assertEquals("Subject Name:  Max Mark: 0", subj.toString());
    }

    @Test
    public void testEmpty() {
        subj = new Subject("", "", 0);

        assertTrue(subj.getName() == "");
        assertTrue(subj.getCode() == "");
        assertEquals(0, subj.getFullMark());
        System.out.println();
        assertEquals("Subject Name:  Max Mark: 0", subj.toString());
    }


    @Test
    public void TestNull() {
        assertNull(subj);
    }
}