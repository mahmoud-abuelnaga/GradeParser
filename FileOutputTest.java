import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.io.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FileOutputTest {

    // Test case for successfully writing output to file
    @Mock
    private MarksSheet sheetMock;

    @Test
    public void testOutputFile_Success() throws IOException {
        String expected = "Subject Name: Testing Max Mark: 100Student name Student number GPA GradeJohn 12345 4 A+";

        // Mocking behavior
        when(sheetMock.toString()).thenReturn(expected);

        String path = "test_output.txt";

        // Calling the method under test
        FileOutput.outputFile(sheetMock, path);

        // Verifying file creation and content
        File file = new File(path);
        assertTrue(file.exists());

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = reader.readLine();
        assertEquals(expected, line);
        reader.close();

        // Cleaning up
        file.delete();
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
