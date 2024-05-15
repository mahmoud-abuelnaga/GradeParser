package WhiteBox;

import modules.InputValidator;
import modules.Student;
import modules.StudentMarks;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.*;

public class WhiteBox {

    private Student student;

    @Test
    public void testGetGPA_over100() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30 , 45);
        assertEquals("Not allowed", studentMarks.getGPA());
    }

    @Test
    public void testAllZeroMarks() {
        StudentMarks studentMarks = new StudentMarks(student, 0, 0, 0, 0);
        assertEquals("0", studentMarks.getGPA());
    }

    @Test
    public void testAllMaximumMarks() {
        StudentMarks studentMarks = new StudentMarks(student, 100, 100, 100, 100);
        assertEquals("Not allowed", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_negative() {
        StudentMarks studentMarks = new StudentMarks(student, 0, 0, 0 , -1);
        assertEquals("0", studentMarks.getGPA());
    }


@Test
    public void testGetGPA_Four() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30 , 40);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_ThreePointSeven() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 40);

        assertEquals("3.7", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_TwoPointThree() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 25);

        assertEquals("2.3", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_OnePointThree() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 20, 25);

        assertEquals("1.3", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_OnePointSeven() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 20, 28);

        assertEquals("1.7", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_TwoPointSeven() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 29);

        assertEquals("2.7", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_Two() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 20);

        assertEquals("2", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_One() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 10, 20);

        assertEquals("1", studentMarks.getGPA());
    }


    
    //for condition coverage
    @Test
    public void testValidMidterm() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validMidterm(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validMidterm(20));
        assertFalse("Should return false for negative mark", InputValidator.validMidterm(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validMidterm(21));
    }

    @Test
    public void testValidSubjectName() {
        assertFalse("Should return false for null input", InputValidator.validSubjectName(null));
        assertFalse("Should return false for empty string", InputValidator.validSubjectName(""));
        assertFalse("Should return false for leading space", InputValidator.validSubjectName(" Database Systems"));
        assertTrue("Should return true for valid name", InputValidator.validSubjectName("Software Testing"));
        assertFalse("Should return false for alphanumeric input", InputValidator.validSubjectName("Software Testing Part4"));
        assertFalse("Should return false for invalid input", InputValidator.validSubjectName(" Software 4Testing"));

    }
}
