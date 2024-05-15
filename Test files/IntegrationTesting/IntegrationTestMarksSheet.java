
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class IntegrationTestMarksSheet {
    @Test
    public void testMarksSheetIntegration() {
        Subject subject = new Subject("Chemistry", "PHY105", 100);
        Student student = new Student("Fawzy Bash", "2109876");
        StudentMarks marks = new StudentMarks(student, 25, 25, 25, 25);

        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(subject);
        sheet.addMark(marks);

        assertEquals("Chemistry", sheet.getSubject().getName());
        assertEquals(100, sheet.getSubject().getFullMark());
        assertEquals(1, sheet.getMarks().size());
    }
    @Test
    public void testMultipleStudents() {
        Subject subject = new Subject("Physics", "PHY106", 100);
        Student student1 = new Student("Fawzy Bash", "2109377");
        Student student2 = new Student("David M4faker", "2149878");
        StudentMarks marks1 = new StudentMarks(student1, 20, 20, 30, 30);
        StudentMarks marks2 = new StudentMarks(student2, 25, 25, 25, 25);

        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(subject);
        sheet.addMark(marks1);
        sheet.addMark(marks2);

        assertEquals("Physics", sheet.getSubject().getName());
        assertEquals(100, sheet.getSubject().getFullMark());
        assertEquals(2, sheet.getMarks().size());
        assertEquals("Fawzy Bash", sheet.getMarks().get(0).getStudent().getName());
        assertEquals("David M4faker", sheet.getMarks().get(1).getStudent().getName());
    }
    @Test
    public void testNoMarksEntry() {
        Subject subject = new Subject("Mathematics", "Mee101", 100);
        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(subject);

        assertEquals("Mathematics", sheet.getSubject().getName());
        assertEquals(0, sheet.getMarks().size());
    }
    @Test
    public void testFullMarksAndZeroMarks() {
        Subject subject = new Subject("Biology", "PHY104", 100);
        Student student1 = new Student("David M4faker", "2144879");
        Student student2 = new Student("Fawzy Faker", "2144880");
        StudentMarks marks1 = new StudentMarks(student1, 0, 0, 0, 0); 
        StudentMarks marks2 = new StudentMarks(student2, 25, 25, 25, 25); 

        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(subject);
        sheet.addMark(marks1);
        sheet.addMark(marks2);

        assertEquals(2, sheet.getMarks().size());
        assertEquals(0, sheet.getMarks().get(0).getTotal());
        assertEquals(100, sheet.getMarks().get(1).getTotal());
    }
    @Test
    public void testGradeAndGPACalculation() {
        Subject subject = new Subject("Computer Science", "CSE131", 100);
        Student student = new Student("Fawzy Faker", "2133381");
        StudentMarks marks = new StudentMarks(student, 15, 15, 35, 35); 

        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(subject);
        sheet.addMark(marks);

        assertEquals("A+", sheet.getMarks().get(0).getGrade()); 
        assertEquals("4", sheet.getMarks().get(0).getGPA());    
    }

}
