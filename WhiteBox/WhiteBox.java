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
