
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

public class IntegrationTestMarksSheet {
    @Test
    public void testMarksSheetIntegration() {
        Subject subject = new Subject("Chemistry", "CHE101", 100);
        Student student = new Student("Alice Johnson", "2109876");
        StudentMarks marks = new StudentMarks(student, 25, 25, 25, 25);

        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(subject);
        sheet.addMark(marks);

        assertEquals("Chemistry", sheet.getSubject().getName());
        assertEquals(100, sheet.getSubject().getFullMark());
        assertEquals(1, sheet.getMarks().size());
    }
}
