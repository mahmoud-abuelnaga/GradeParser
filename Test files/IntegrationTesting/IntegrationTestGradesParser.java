import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.*;

public class IntegrationTestGradesParser {
    private File tempFile;

    @Before
    public void setUp() throws IOException {
        // Create a temporary file
        tempFile = new File("testGradesParser.txt");
        // Write test data to the temporary file
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("Physics, PHY102, 100\nJohn Doe, 2001866s, 10, 10, 20, 60");
        }
    }

    @After
    public void tearDown() {
        // Ensure the temporary file is deleted after tests
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    public void testGradesParserIntegration() throws Exception {
        // Parse the file
        MarksSheet sheet = GradesParser.parse(tempFile.getAbsolutePath());

        // Detailed validation
        assertNotNull("Sheet should not be null", sheet);
        assertEquals("Subject name should match", "Physics", sheet.getSubject().getName());
        assertEquals("Subject code should match", "PHY102", sheet.getSubject().getCode());
        assertEquals("Full mark should be 100", 100, sheet.getSubject().getFullMark());
        assertNotNull("Marks list should not be null", sheet.getMarks());
        assertEquals("Should have one entry for marks", 1, sheet.getMarks().size());
        StudentMarks marks = sheet.getMarks().get(0);
        assertNotNull("Marks should not be null", marks);
        assertEquals("Student name should match", "John Doe", marks.getStudent().getName());
        assertEquals("Student number should match", "2001866s", marks.getStudent().getNumber());
        assertEquals("Activities mark should be 10", 10, marks.getActivities());
        assertEquals("Oral mark should be 10", 10, marks.getOral());
        assertEquals("Midterm mark should be 20", 20, marks.getMidterm());
        assertEquals("Final mark should be 60",60, marks.getFinal());
    }
}
