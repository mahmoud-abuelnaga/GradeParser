import static org.junit.jupiter.api.Assertions.*;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;

public class GradesParserSecTest {

    /*
     * Test for:
     * 1. valid subject name & 3 fields
     * 2. invalid subject final mark
     * 3. valid student name
     * 4. valid student code
     * 5. valid activities mark
     * 6. valid oral mark
     * 7. valid midterm mark
     * 9. valid final mark
     */
    @Test
    public void testParseValidFile() throws Exception {
        String[] line1 = {"Software Engineering", "CSE101s", "200"};
        String[] line2 = {"Ahmed", "1402225s", "10", "10", "20", "60"};
        MarksSheet sheet = GradesParser.parse("./Test files/valid2.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(100, sheet.getSubject().getFullMark());

        StudentMarks studentMarks = sheet.getMarks().get(0);
        assertEquals(line2[0], studentMarks.getStudent().getName());
        assertEquals(line2[1], studentMarks.getStudent().getNumber());
        assertEquals(Integer.parseInt(line2[2]), studentMarks.getActivities());
        assertEquals(Integer.parseInt(line2[3]), studentMarks.getOral());
        assertEquals(Integer.parseInt(line2[4]), studentMarks.getMidterm());
        assertEquals(Integer.parseInt(line2[5]), studentMarks.getFinal());
    }

    @Test
    public void testParseEmptyFile() throws Exception {
        assertThrows(Exception.class, () -> GradesParser.parse("./Test files/empty.txt"));
    }

    @Test
    public void testParseNonexistentFile() throws Exception {
        assertThrows(FileNotFoundException.class,
                () -> GradesParser.parse("nonexistent.txt"));
    }

    /*
     * Test for:
     * 1. Non 3-field subject & invalid subject name
     * 2. invalid subject final mark & non 3-field
     * 3. valid student name
     * 4. valid student code
     * 5. valid activities mark
     * 6. valid oral mark
     * 7. valid midterm mark
     * 9. valid final mark
     * 10. non 3-field subject line & invalid subject code
     */
    @Test
    public void testParseInvalidSubjectInfo() throws Exception {


        String[] line1 = {"", "", ""};
        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50"};
        MarksSheet sheet = GradesParser.parse("./Test files/InvalidSubject1.txt");

        assertEquals("Unknown", sheet.getSubject().getName());
        assertEquals("Unknown", sheet.getSubject().getCode());
        assertEquals(100, sheet.getSubject().getFullMark());

        StudentMarks studentMarks = sheet.getMarks().get(0);
        assertEquals(line2[0], studentMarks.getStudent().getName());
        assertEquals(line2[1], studentMarks.getStudent().getNumber());
        assertEquals(Integer.parseInt(line2[2]), studentMarks.getActivities());
        assertEquals(Integer.parseInt(line2[3]), studentMarks.getOral());
        assertEquals(Integer.parseInt(line2[4]), studentMarks.getMidterm());
        assertEquals(Integer.parseInt(line2[5]), studentMarks.getFinal());

    }

    /*
     * Test for:
     * 1. Non 3-field subject & invalid subject name
     * 2. invalid subject final mark & non-3 field
     * 3. valid student name
     * 4. valid student code
     * 5. valid activities mark
     * 6. valid oral mark
     * 7. valid midterm mark
     * 9. valid final mark
     * 10. non 3-field subject line & invalid subject code
     */
    @Test
    public void testParseInvalidSubjectInfo2() throws Exception {


        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50"};
        MarksSheet sheet = GradesParser.parse("./Test files/InvalidSubject2.txt");

        assertEquals("Unknown", sheet.getSubject().getName());
        assertEquals("Unknown", sheet.getSubject().getCode());
        assertEquals(100, sheet.getSubject().getFullMark());

        StudentMarks studentMarks = sheet.getMarks().get(0);
        assertEquals(line2[0], studentMarks.getStudent().getName());
        assertEquals(line2[1], studentMarks.getStudent().getNumber());
        assertEquals(Integer.parseInt(line2[2]), studentMarks.getActivities());
        assertEquals(Integer.parseInt(line2[3]), studentMarks.getOral());
        assertEquals(Integer.parseInt(line2[4]), studentMarks.getMidterm());
        assertEquals(Integer.parseInt(line2[5]), studentMarks.getFinal());


    }

    /*
     * Test for:
     * 1. 3-field subject & invalid subject name
     * 2. 3-field subject field & invalid subject code
     * 3. 3-field subject field & invalid subject final mark
     */
    @Test
    public void threeFieldAndInvalidSubject() throws Exception {
        String line1[] = {" Computer Engineering", "23CSEs", "300"};
        MarksSheet sheet = GradesParser.parse("./Test files/invalidsubj3.txt");

        assertEquals("Unknown", sheet.getSubject().getName());
        assertEquals("Unknown", sheet.getSubject().getCode());
    }

    /*
     * Test for:
     * 1. non 3-field subject & valid subject name
     * 2. non 3-field subject field & valid subject code
     */
    @Test
    public void nonThreeFieldAndInvalidSubject() throws Exception {
        String line1[] = {"Computer Engineering", "CSE311s"};
        MarksSheet sheet = GradesParser.parse("./Test files/invalidsubj3.txt");

        assertEquals("Unknown", sheet.getSubject().getName());
        assertEquals("Unknown", sheet.getSubject().getCode());
    }


    /*
     * Test for:
     * 1. 3-field subject & valid subject name
     * 2. valid subject final mark
     * 3. valid student name
     * 4. invalid student code
     * 5. valid activities mark
     * 6. valid oral mark
     * 7. valid midterm mark
     * 9. valid final mark
     * 10. 3-field subject line & valid subject code
     */
    @Test
    public void testParseInvalidStudentInfo() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"Alaa", " ", "10", "10", "20", "50"};

        MarksSheet sheet = GradesParser.parse("./Test files/InvalidStudent.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());

        StudentMarks studentMarks = sheet.getMarks().get(0);
        assertEquals(line2[0], studentMarks.getStudent().getName());
        assertEquals("Unknown", studentMarks.getStudent().getNumber());
        assertEquals(Integer.parseInt(line2[2]), studentMarks.getActivities());
        assertEquals(Integer.parseInt(line2[3]), studentMarks.getOral());
        assertEquals(Integer.parseInt(line2[4]), studentMarks.getMidterm());
        assertEquals(Integer.parseInt(line2[5]), studentMarks.getFinal());

    }


    /*
     * Test for:
     * 1. 3-field subject & valid subject name
     * 2. valid subject final mark
     * 3. invalid student name
     * 4. invalid student code
     * 5. invalid activities mark
     * 6. invalid oral mark
     * 7. invalid midterm mark
     * 9. invalid final mark
     */
    @Test
    public void testParseNoStudentInfo() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"", " ", "", "", "", ""};

        MarksSheet sheet = GradesParser.parse("./Test files/NoStudents.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());

        assertTrue(sheet.getMarks().isEmpty());


    }

    /*
     * Test for:
     * 1. 3-field subject & valid subject name
     * 2. valid subject final mark
     * 3. valid student name
     * 4. valid student code
     * 5. valid activities mark
     * 6. valid oral mark
     * 7. valid midterm mark
     * 9. valid final mark
     */
    @Test
    public void testParseValidMnStudentInfo() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50","Nour", "1609225s", "10", "10", "15", "55"};

        MarksSheet sheet = GradesParser.parse("./Test files/validMnStudent.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());

        StudentMarks studentMarks = sheet.getMarks().getFirst();
        assertEquals(line2[0], studentMarks.getStudent().getName());
        assertEquals(line2[1], studentMarks.getStudent().getNumber());
        assertEquals(Integer.parseInt(line2[2]), studentMarks.getActivities());
        assertEquals(Integer.parseInt(line2[3]), studentMarks.getOral());
        assertEquals(Integer.parseInt(line2[4]), studentMarks.getMidterm());
        assertEquals(Integer.parseInt(line2[5]), studentMarks.getFinal());

        StudentMarks studentMarks2 = sheet.getMarks().get(1);
        assertEquals(line2[6], studentMarks2.getStudent().getName());
        assertEquals(line2[7], studentMarks2.getStudent().getNumber());
        assertEquals(Integer.parseInt(line2[8]), studentMarks2.getActivities());
        assertEquals(Integer.parseInt(line2[9]), studentMarks2.getOral());
        assertEquals(Integer.parseInt(line2[10]), studentMarks2.getMidterm());
        assertEquals(Integer.parseInt(line2[11]), studentMarks2.getFinal());

    }

    /*
     * Test for:
     * 1. 3-field subject & valid subject name
     * 2. valid subject final mark
     * 3. valid student name
     * 4. valid student code
     * 5. invalid activities mark
     * 6. invalid oral mark
     * 7. invalid midterm mark
     * 9. valid final mark
     */
    @Test
    public void testParseMnStudentInfo2() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50","Nour", "1609225s", "100", "100", "150", "55"};

        MarksSheet sheet = GradesParser.parse("./Test files/InvalidMnStudent.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());

        StudentMarks studentMarks2 = sheet.getMarks().get(1);
        assertEquals(line2[6], studentMarks2.getStudent().getName());
        assertEquals(line2[7], studentMarks2.getStudent().getNumber());
        assertEquals(0, studentMarks2.getActivities());
        assertEquals(0, studentMarks2.getOral());
        assertEquals(0, studentMarks2.getMidterm());
        assertEquals(Integer.parseInt(line2[11]), studentMarks2.getFinal());

    }

    @Test
    public void testOnlySubject() throws Exception {
        String line1[] = {"Computer Programming", "CSE021s", "100"};

        MarksSheet sheet = GradesParser.parse("./Test files/onlySubject.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());
    }

    
}
