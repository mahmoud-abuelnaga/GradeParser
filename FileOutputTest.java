import org.junit.Test;
import java.io.*;
import static org.junit.Assert.*;

public class FileOutputTest {

    // Test case for successfully writing output to file
    @Test
    public void testOutputFile_Success() {
        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(new Subject("Testing", "CSE", 100));
        sheet.addMark(new StudentMarks(new Student("John", "12345"), 15, 5, 20, 60));

        String path = "test_output.txt";

        try {
            FileOutput.outputFile(sheet, path);

            // Check if file exists
            File file = new File(path);
            assertTrue(file.exists());

            // Check file content
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            StringBuilder content = new StringBuilder();
            while (line != null) {
                content.append(line);
                line = reader.readLine();
            }
            reader.close();
            assertEquals("Subject Name: Testing Max Mark: 100Student name Student number GPA GradeJohn 12345 4 A+", content.toString());
        } catch (IOException e) {
            fail("IOException occurred while testing outputFile: " + e.getMessage());
        } finally {
            // Clean up
            File file = new File(path);
            file.delete();
        }
    }

    // Test case for handling null MarksSheet object
    @Test(expected = NullPointerException.class)
    public void testOutputFile_NullMarksSheet() throws IOException {
        String path = "test_output.txt";
        FileOutput.outputFile(null, path);
    }

    // Test case for handling null path
    @Test(expected = NullPointerException.class)
    public void testOutputFile_NullPath() throws IOException {
        MarksSheet sheet = new MarksSheet();
        sheet.setSubject(new Subject("Testing", "CSE", 100));
        sheet.addMark(new StudentMarks(new Student("John", "12345"), 15, 5, 20, 60));
        FileOutput.outputFile(sheet, null);
    }
}
