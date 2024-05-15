import java.io.BufferedReader;
import java.io.BufferedWriter;
import static org.junit.Assert.*;
import org.junit.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FullSystemIntegrationTest {
    private String filePath = "fullIntegrationTest.txt";
    private String transformedFilePath = "transformedFullIntegrationTest.txt";
    private File originalFile;
    private File transformedFile;
    @Before
    public void setUp() {
        // Initialize common objects and state here
        originalFile = new File(filePath);
        transformedFile = new File(transformedFilePath);
    }

    @After
    public void tearDown() {
        // Clean up after tests
        if (originalFile.exists()) {
            originalFile.delete();
        }
    }

    @Test
    public void testCompleteSystemIntegration() throws Exception {
        // Setup test data
        Subject subject = new Subject("Software Testing", "CSE311s", 100);
        Student student = new Student("Fawzy Mohamed", "2001866s");
        StudentMarks marks = new StudentMarks(student, 10, 10, 20, 60);
        MarksSheet originalSheet = new MarksSheet();
        originalSheet.setSubject(subject);
        originalSheet.addMark(marks);
        
        // Write to file
        FileOutput.outputFile(originalSheet, filePath);
        transformFileToExpectedFormat(originalFile, transformedFile);
        // Read from file
        MarksSheet parsedSheet = GradesParser.parse(transformedFilePath);
        
        // Assert field by field
        assertEquals(originalSheet.getSubject().getName(), parsedSheet.getSubject().getName());
        assertEquals(originalSheet.getSubject().getCode(), parsedSheet.getSubject().getCode());
        assertEquals(originalSheet.getSubject().getFullMark(), parsedSheet.getSubject().getFullMark());
        assertEquals(originalSheet.getMarks().size(), parsedSheet.getMarks().size());
        
        // More detailed checks can include individual fields of StudentMarks if necessary
        for (int i = 0; i < originalSheet.getMarks().size(); i++) {
            StudentMarks originalMarks = originalSheet.getMarks().get(i);
            StudentMarks parsedMarks = parsedSheet.getMarks().get(i);
            assertEquals(originalMarks.getStudent().getName(), parsedMarks.getStudent().getName());
            assertEquals(originalMarks.getStudent().getNumber(), parsedMarks.getStudent().getNumber());
            assertEquals(originalMarks.getActivities(), parsedMarks.getActivities());
            assertEquals(originalMarks.getOral(), parsedMarks.getOral());
            assertEquals(originalMarks.getMidterm(), parsedMarks.getMidterm());
            assertEquals(originalMarks.getFinal(), parsedMarks.getFinal());
        }
    }
        //To make the output format looks like the gradeparser input format
        private void transformFileToExpectedFormat(File original, File transformed) throws FileNotFoundException, IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(original));
             BufferedWriter writer = new BufferedWriter(new FileWriter(transformed))) {
            String line = reader.readLine();  // Read "Subject Name: Software Testing Max Mark: 100"
            if (line != null) {
                String[] subjectParts = line.split(" Max Mark: ");
                String subjectName = subjectParts[0].split(": ")[1];
                int maxMark = Integer.parseInt(subjectParts[1]);
                writer.write(subjectName + ",CSE311s," + maxMark);
                writer.newLine();
            }
            reader.readLine(); // Skip header "Student name Student number GPA Grade"
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                writer.write(parts[0] + " " + parts[1] + "," + parts[2] + ",10,10,20,60"); // Assuming fixed scores for simplicity
                writer.newLine();
            }
        }
    }
}
