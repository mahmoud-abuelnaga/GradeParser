import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class GradesParserTest {

    @Mock
    private BufferedReader mockReader;


    @BeforeAll
    static void beforeAll() {
        mockStatic(InputValidator.class);
    }

    @BeforeEach
    public void setUp()  {
        mockReader = mock(BufferedReader.class);
    }



    @Test
    public void testParseValidFile() throws Exception {

        String[] line1 = {"Software Engineering", "CSE101s", "200"};
        String[] line2 = {"Ahmed", "1402225s", "10", "10", "20", "60"};
        when(mockReader.readLine()).thenReturn(line1[0],line1[1],line1[2],line2[0],line2[1],line2[2],line2[3],line2[4],line2[5],null);

        when(InputValidator.validSubjectName(anyString())).thenReturn(true);
        when(InputValidator.validSubjectCode(anyString())).thenReturn(true);
        when(InputValidator.validFullMark(anyInt())).thenReturn(true);
        when(InputValidator.validStudentName(anyString())).thenReturn(true);
        when(InputValidator.validStudentNumber(anyString())).thenReturn(true);
        when(InputValidator.validActivites(anyInt())).thenReturn(true);
        when(InputValidator.validOral(anyInt())).thenReturn(true);
        when(InputValidator.validMidterm(anyInt())).thenReturn(true);
        when(InputValidator.validFinal(anyInt())).thenReturn(true);

        MarksSheet sheet = GradesParser.parse("./Test files/valid2.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());

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
        when(mockReader.readLine()).thenReturn(null);
        assertThrows(Exception.class, () -> GradesParser.parse("./Test files/empty.txt"));
    }

    @Test
    public void testParseNonexistentFile() throws Exception {
        when(mockReader.readLine()).thenReturn(null);
        assertThrows(FileNotFoundException.class,
                () -> GradesParser.parse("nonexistent.txt"));
    }

    @Test
    public void testParseInvalidSubjectInfo() throws Exception {


        String[] line1 = {"", "", ""};
        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50"};
        when(mockReader.readLine()).thenReturn(line1[0],line1[1],line1[2],line2[0],line2[1],line2[2],line2[3],line2[4],line2[5]);

        when(InputValidator.validSubjectName(anyString())).thenReturn(false);
        when(InputValidator.validSubjectCode(anyString())).thenReturn(false);
        when(InputValidator.validFullMark(anyInt())).thenReturn(false);
        when(InputValidator.validStudentName(anyString())).thenReturn(true);
        when(InputValidator.validStudentNumber(anyString())).thenReturn(true);
        when(InputValidator.validActivites(anyInt())).thenReturn(true);
        when(InputValidator.validOral(anyInt())).thenReturn(true);
        when(InputValidator.validMidterm(anyInt())).thenReturn(true);
        when(InputValidator.validFinal(anyInt())).thenReturn(true);

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

    @Test
    public void testParseInvalidSubjectInfo2() throws Exception {


        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50"};
        when(mockReader.readLine()).thenReturn(line2[0],line2[1],line2[2],line2[3],line2[4],line2[5],line2[0],line2[1],line2[2],line2[3],line2[4],line2[5]);

        when(InputValidator.validSubjectName(anyString())).thenReturn(false);
        when(InputValidator.validSubjectCode(anyString())).thenReturn(false);
        when(InputValidator.validFullMark(anyInt())).thenReturn(false);
        when(InputValidator.validStudentName(anyString())).thenReturn(true);
        when(InputValidator.validStudentNumber(anyString())).thenReturn(true);
        when(InputValidator.validActivites(anyInt())).thenReturn(true);
        when(InputValidator.validOral(anyInt())).thenReturn(true);
        when(InputValidator.validMidterm(anyInt())).thenReturn(true);
        when(InputValidator.validFinal(anyInt())).thenReturn(true);

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

    @Test
    public void testParseInvalidStudentInfo() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"Alaa", " ", "10", "10", "20", "50"};
        when(mockReader.readLine()).thenReturn(line1[0],line1[1],line1[2],line2[0],line2[1],line2[2],line2[3],line2[4],line2[5]);

        when(InputValidator.validSubjectName(anyString())).thenReturn(true);
        when(InputValidator.validSubjectCode(anyString())).thenReturn(true);
        when(InputValidator.validFullMark(anyInt())).thenReturn(true);
        when(InputValidator.validStudentName(anyString())).thenReturn(true);
        when(InputValidator.validStudentNumber(anyString())).thenReturn(false);
        when(InputValidator.validActivites(anyInt())).thenReturn(true);
        when(InputValidator.validOral(anyInt())).thenReturn(true);
        when(InputValidator.validMidterm(anyInt())).thenReturn(true);
        when(InputValidator.validFinal(anyInt())).thenReturn(true);

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

    @Test
    public void testParseNoStudentInfo() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"", " ", "", "", "", ""};
        when(mockReader.readLine()).thenReturn(line1[0],line1[1],line1[2],line2[0],line2[1],line2[2],line2[3],line2[4],line2[5]);

        when(InputValidator.validSubjectName(anyString())).thenReturn(true);
        when(InputValidator.validSubjectCode(anyString())).thenReturn(true);
        when(InputValidator.validFullMark(anyInt())).thenReturn(true);
        when(InputValidator.validStudentName(anyString())).thenReturn(false);
        when(InputValidator.validStudentNumber(anyString())).thenReturn(false);
        when(InputValidator.validActivites(anyInt())).thenReturn(false);
        when(InputValidator.validOral(anyInt())).thenReturn(false);
        when(InputValidator.validMidterm(anyInt())).thenReturn(false);
        when(InputValidator.validFinal(anyInt())).thenReturn(false);

        MarksSheet sheet = GradesParser.parse("./Test files/NoStudents.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());

        assertTrue(sheet.getMarks().isEmpty());


    }

    @Test
    public void testParseValidMnStudentInfo() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50","Nour", "1609225s", "10", "10", "15", "55"};
        when(mockReader.readLine()).thenReturn(line1[0],line1[1],line1[2],line2[0],line2[1],line2[2],line2[3],line2[4],line2[5],line2[6],line2[7],line2[8],line2[9],line2[10],line2[11]);

        when(InputValidator.validSubjectName(anyString())).thenReturn(true);
        when(InputValidator.validSubjectCode(anyString())).thenReturn(true);
        when(InputValidator.validFullMark(anyInt())).thenReturn(true);
        when(InputValidator.validStudentName(anyString())).thenReturn(true);
        when(InputValidator.validStudentNumber(anyString())).thenReturn(true);
        when(InputValidator.validActivites(anyInt())).thenReturn(true);
        when(InputValidator.validOral(anyInt())).thenReturn(true);
        when(InputValidator.validMidterm(anyInt())).thenReturn(true);
        when(InputValidator.validFinal(anyInt())).thenReturn(true);

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

    @Test
    public void testParseMnStudentInfo2() throws Exception {

        String[] line1 = {"Computer Programming", "CSE021s", "100"};
        String[] line2 = {"Alaa", "1402225s", "10", "10", "20", "50","Nour", "1609225s", "100", "100", "150", "55"};
        when(mockReader.readLine()).thenReturn(line1[0],line1[1],line1[2],line2[0],line2[1],line2[2],line2[3],line2[4],line2[5],line2[6],line2[7],line2[8],line2[9],line2[10],line2[11]);

        when(InputValidator.validSubjectName(anyString())).thenReturn(true);
        when(InputValidator.validSubjectCode(anyString())).thenReturn(true);
        when(InputValidator.validFullMark(anyInt())).thenReturn(true);
        when(InputValidator.validStudentName(anyString())).thenReturn(true);
        when(InputValidator.validStudentNumber(anyString())).thenReturn(true);
        when(InputValidator.validActivites(anyInt())).thenReturn(false);
        when(InputValidator.validOral(anyInt())).thenReturn(false);
        when(InputValidator.validMidterm(anyInt())).thenReturn(false);
        when(InputValidator.validFinal(anyInt())).thenReturn(true);

        MarksSheet sheet = GradesParser.parse("./Test files/InvalidMnStudent.txt");

        assertEquals(line1[0], sheet.getSubject().getName());
        assertEquals(line1[1], sheet.getSubject().getCode());
        assertEquals(Integer.parseInt(line1[2]), sheet.getSubject().getFullMark());

//        StudentMarks studentMarks = sheet.getMarks().getFirst();
//        assertEquals(line2[0], studentMarks.getStudent().getName());
//        assertEquals(line2[1], studentMarks.getStudent().getNumber());
//        assertEquals(Integer.parseInt(line2[2]), studentMarks.getActivities());
//        assertEquals(Integer.parseInt(line2[3]), studentMarks.getOral());
//        assertEquals(Integer.parseInt(line2[4]), studentMarks.getMidterm());
//        assertEquals(Integer.parseInt(line2[5]), studentMarks.getFinal());

        StudentMarks studentMarks2 = sheet.getMarks().get(1);
        assertEquals(line2[6], studentMarks2.getStudent().getName());
        assertEquals(line2[7], studentMarks2.getStudent().getNumber());
        assertEquals(0, studentMarks2.getActivities());
        assertEquals(0, studentMarks2.getOral());
        assertEquals(0, studentMarks2.getMidterm());
        assertEquals(Integer.parseInt(line2[11]), studentMarks2.getFinal());

    }
}
