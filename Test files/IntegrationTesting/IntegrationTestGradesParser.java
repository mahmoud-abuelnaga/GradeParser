import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.*;

public class IntegrationTestGradesParser {
    private File tempFile;

    @Before
    public void setUp() throws IOException {
        tempFile = new File("testGradesParser.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("Physics, PHY104, 100\nFooz Deryf, 2088866s, 10, 10, 20, 60");
        }
    }

    @After
    public void tearDown() {
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    public void testGradesParserIntegration() throws Exception {
        MarksSheet sheet = GradesParser.parse(tempFile.getAbsolutePath());

        assertNotNull(sheet);
        assertEquals("Physics", sheet.getSubject().getName());
        assertEquals("PHY104", sheet.getSubject().getCode());
        assertEquals(100, sheet.getSubject().getFullMark());
        assertNotNull(sheet.getMarks());
        assertEquals(1, sheet.getMarks().size());
        StudentMarks marks = sheet.getMarks().get(0);
        assertNotNull(marks);
        assertEquals("Fooz Deryf", marks.getStudent().getName());
        assertEquals("2088866s", marks.getStudent().getNumber());
        assertEquals(10, marks.getActivities());
        assertEquals(10, marks.getOral());
        assertEquals(20, marks.getMidterm());
        assertEquals(60, marks.getFinal());
    }

    @Test
    public void testInvalidSubjectDetails() throws IOException, Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("123, PHY@02, 34566\nFooz DFAR, 2008886s, 10, 10, 20, 60");
        }

        MarksSheet sheet = GradesParser.parse(tempFile.getAbsolutePath());

        assertEquals("Unknown", sheet.getSubject().getName());
        assertEquals("Unknown", sheet.getSubject().getCode());
        assertEquals(100, sheet.getSubject().getFullMark());
    }

    @Test
    public void testInvalidStudentDetails() throws IOException, Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("Physics, PHY106, 100\nFooz 123, 2001866!, 10, 10, 20, 60");
        }

        MarksSheet sheet = GradesParser.parse(tempFile.getAbsolutePath());

        StudentMarks marks = sheet.getMarks().get(0);
        assertEquals("Unknown", marks.getStudent().getName());
        assertEquals("Unknown", marks.getStudent().getNumber());
    }

    @Test
    public void testInvalidScores() throws IOException, Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("Physics, PHY102, 100\nFooz Dfer, 2001866s, -10, 222, 120, -1");
        }

        MarksSheet sheet = GradesParser.parse(tempFile.getAbsolutePath());

        StudentMarks marks = sheet.getMarks().get(0);
        assertEquals(0, marks.getActivities());
        assertEquals(0, marks.getOral());
        assertEquals(0, marks.getMidterm());
        assertEquals(0, marks.getFinal());
    }

}
