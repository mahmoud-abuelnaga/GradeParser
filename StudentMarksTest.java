import org.example.Student;
import org.example.StudentMarks;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class StudentMarksTest {

    private Student studentMock;

//    @BeforeAll
//    public static void beforeAll() {
//        // This method runs once before all tests
//    }

    @BeforeEach
    public void beforeEach() {
        studentMock = Mockito.mock(Student.class);
    }


    @Test
    public void testConstructorWithStudent() {
        StudentMarks studentMarks = new StudentMarks(studentMock);

        assertEquals(studentMock, studentMarks.getStudent());
        assertEquals(0, studentMarks.getActivities());
        assertEquals(0, studentMarks.getOral());
        assertEquals(0, studentMarks.getMidterm());
        assertEquals(0, studentMarks.getFinal());
    }

    @Test
    public void testConstructorWithAllValues() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 30, 40);

        assertEquals(studentMock, studentMarks.getStudent());
        assertEquals(10, studentMarks.getActivities());
        assertEquals(20, studentMarks.getOral());
        assertEquals(30, studentMarks.getMidterm());
        assertEquals(40, studentMarks.getFinal());
    }

    @Test
    public void testGetTotal() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 30, 40);

        assertEquals(100, studentMarks.getTotal());
    }

    @Test
    public void testGetGrade_APlus() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 30, 40);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("A+", studentMarks.getGrade());
    }

    @Test
    public void testGetGrade_BMinus() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 8, 40);

        assertEquals("B-", studentMarks.getGrade());
    }

    @Test
    public void testGetGrade_C() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 2, 40);

        assertEquals("C", studentMarks.getGrade());
    }

    @Test
    public void testGetGrade_DPlus() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 2, 2, 30, 30);

        assertEquals("D+", studentMarks.getGrade());
    }

    @Test
    public void testGetGrade_F() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 0, 14, 15, 30);

        assertEquals("F", studentMarks.getGrade());
    }

    @Test
    public void testGetGPA_Four() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 30 , 40);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_ThreePointSeven() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 20, 40);

        assertEquals("3.7", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_Two() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 20, 20);

        assertEquals("2", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_One() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 10, 20);

        assertEquals("1", studentMarks.getGPA());
    }

    @Test
    public void testToString() {
        Mockito.when(studentMock.toString()).thenReturn("Student Name");
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 10, 40);

        assertEquals("Student Name 3 B", studentMarks.toString());
    }

    @Test
    public void testGetGrade_over100() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 30, 45);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("Not allowed", studentMarks.getGrade());
    }
    @Test
    public void testGetGPA_over100() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 10, 20, 30 , 45);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("Not allowed", studentMarks.getGPA());
    }

    @Test
    public void testGetGrade_negative() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 0, 0, 0, -1);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("F", studentMarks.getGrade());
    }
    @Test
    public void testGetGPA_negative() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 0, 0, 0 , -1);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("0", studentMarks.getGPA());
    }
    @Test
    public void testGetTotal_NegativeValues() {
        StudentMarks studentMarks = new StudentMarks(studentMock, -10, 0, 0, 0);
        // Assert that the total is calculated correctly, potentially handling negatives in a specific way (e.g., 0)
        assertEquals(0, studentMarks.getTotal());
    }

    @Test
    public void testSetActivities_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(studentMock);
        studentMarks.setActivities(-10);
        assertEquals(0, studentMarks.getActivities());
    }

    @Test
    public void testSetOral_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(studentMock);
        studentMarks.setOral(-20);
        assertEquals(0, studentMarks.getOral());
    }

    @Test
    public void testSetMidterm_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(studentMock);
        studentMarks.setMidterm(-30);
        assertEquals(0, studentMarks.getMidterm());
    }

    @Test
    public void testSetFinal_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(studentMock);
        studentMarks.setFinal(-40);
        assertEquals(0, studentMarks.getFinal());
    }

    @Test
    public void testConstructorWithAllNegatives() {
        StudentMarks studentMarks = new StudentMarks(studentMock, -10, -20, -30, -40);

        // Assert that individual marks are set to 0
        assertEquals(0, studentMarks.getActivities());
        assertEquals(0, studentMarks.getOral());
        assertEquals(0, studentMarks.getMidterm());
        assertEquals(0, studentMarks.getFinal());

        // Optionally, test the total and derived values (grade, GPA) based on your logic
        assertEquals(0, studentMarks.getTotal()); // Adjust based on how negative values affect total

    }

    @Test
    public void testAllZeroMarks() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 0, 0, 0, 0);
        assertEquals("F", studentMarks.getGrade());
        assertEquals("0", studentMarks.getGPA());
    }

    @Test
    public void testAllMaximumMarks() {
        StudentMarks studentMarks = new StudentMarks(studentMock, 100, 100, 100, 100);
        assertEquals("Not allowed", studentMarks.getGrade());
        assertEquals("Not allowed", studentMarks.getGPA());
    }




    @Test
    public void testSetActivities_MaxValue() {
        StudentMarks studentMarks = new StudentMarks(studentMock);
        studentMarks.setActivities(100);
        assertEquals(100, studentMarks.getActivities());
    }
// Similar tests for setOral, setMidterm, and setFinal methods
@Test
public void testSetActivities_NegativeMaxValue() {
    StudentMarks studentMarks = new StudentMarks(studentMock);
    studentMarks.setActivities(-100);
    assertEquals(0, studentMarks.getActivities());
}
// Similar tests for setOral, setMidterm, and setFinal methods

    @Test
    public void testConstructorWithNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> {
            StudentMarks studentMarks = new StudentMarks(null);
        });
    }


}