import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class IntegrationTestStudentMarks {
    @Test
    public void testStudentMarksWithStudent() {
        Student student = new Student("Fawzy Faker", "2133381");
        StudentMarks marks = new StudentMarks(student, 10, 20, 30, 40);
        assertEquals("Fawzy Faker", marks.getStudent().getName());
        assertEquals("2133381", marks.getStudent().getNumber());
        assertEquals(100, marks.getTotal()); 
    }

    @Test
    public void testGradeCalculation() {
        Student student = new Student("Fawzy Faker", "2133381");
        StudentMarks marks = new StudentMarks(student, 25, 25, 25, 25); 
        assertEquals("A+", marks.getGrade()); 
    }

    @Test
    public void testGPACalculation() {
        Student student = new Student("Fawzy Faker", "2133381");
        StudentMarks marks = new StudentMarks(student, 20, 20, 30, 30); 
        assertEquals("4", marks.getGPA()); 
    }

    @Test
    public void testPartialMarks() {
        Student student = new Student("Fawzy Faker", "2133381");
        StudentMarks marks = new StudentMarks(student, 0, 15, 10, 5); 
        assertEquals(30, marks.getTotal());
        assertEquals("F", marks.getGrade()); 
    }

    @Test
    public void testEdgeCaseMarks() {
        Student student = new Student("Fawzy Faker", "2133381");
        StudentMarks marks = new StudentMarks(student, 0, 0, 0, 0); 
        assertEquals(0, marks.getTotal());
        assertEquals("F", marks.getGrade()); 

        marks = new StudentMarks(student, 25, 25, 25, 25); 
        assertEquals(100, marks.getTotal());
        assertEquals("A+", marks.getGrade()); 
    }

}
