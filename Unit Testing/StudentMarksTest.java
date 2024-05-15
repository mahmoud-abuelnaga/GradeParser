// import org.example.Student;
// import org.example.StudentMarks;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class StudentMarksTest {

    private Student student = new Student("Mahmoud", "2001866");

    // @BeforeEach
    // public void beforeEach() {
    //     student = Mockito.mock(Student.class);
    // }


    @Test
    public void testConstructorWithStudent() {
        StudentMarks studentMarks = new StudentMarks(student);

        assertEquals(student, studentMarks.getStudent());
        assertEquals(0, studentMarks.getActivities());
        assertEquals(0, studentMarks.getOral());
        assertEquals(0, studentMarks.getMidterm());
        assertEquals(0, studentMarks.getFinal());
    }

    @Test
    public void testConstructorWithAllValues() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 40);

        assertEquals(student, studentMarks.getStudent());
        assertEquals(10, studentMarks.getActivities());
        assertEquals(20, studentMarks.getOral());
        assertEquals(30, studentMarks.getMidterm());
        assertEquals(40, studentMarks.getFinal());
    }

    @Test
    public void testGetTotal() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 40);

        assertEquals(100, studentMarks.getTotal());
    }

    @Test
    public void posUpperBoundaryOfAplus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 21, 30, 40);

        assertEquals(101, studentMarks.getTotal());
        assertEquals("Not allowed", studentMarks.getGrade());
        assertEquals("Not allowed", studentMarks.getGPA());
    }

    // tests the boundary of 100
    @Test
    public void upperBoundaryOfAplus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 40);

        // discovered that , more than 100 it would give an F overlapping
        assertEquals("A+", studentMarks.getGrade());
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void posLowerBoundaryOfAplus() {
        StudentMarks studentMarks = new StudentMarks(student, 8, 20, 30, 40);

        assertEquals(98, studentMarks.getTotal());
        assertEquals("A+", studentMarks.getGrade());
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void lowerBoundaryOfAplus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 20, 30, 40);

        assertEquals(97, studentMarks.getTotal());
        assertEquals("A+", studentMarks.getGrade());
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofA() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 20, 29, 40);

        assertEquals(96, studentMarks.getTotal());
        assertEquals("A", studentMarks.getGrade());
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofA() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 20, 29, 39);

        assertEquals(95, studentMarks.getTotal());
        assertEquals("A", studentMarks.getGrade());
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void PosLowerBoundaryOfA() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 14, 30, 40);

        assertEquals(94, studentMarks.getTotal());
        assertEquals("A", studentMarks.getGrade());
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfA() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 13, 30, 40);

        assertEquals(93, studentMarks.getTotal());
        assertEquals("A", studentMarks.getGrade());
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofAminus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 22, 40);

        assertEquals(92, studentMarks.getTotal());
        assertEquals("A-", studentMarks.getGrade());
        assertEquals("3.7", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofAminus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 19, 22, 40);

        assertEquals(91, studentMarks.getTotal());
        assertEquals("A-", studentMarks.getGrade());
        assertEquals("3.7", studentMarks.getGPA());
    }

    @Test
    public void PosLowerBoundaryOfAminus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 30, 40);

        assertEquals(90, studentMarks.getTotal());
        assertEquals("A-", studentMarks.getGrade());
        assertEquals("3.7", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfAminus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 29);

        assertEquals(89, studentMarks.getTotal());
        assertEquals("A-", studentMarks.getGrade());
        assertEquals("3.7", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofBplus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 28);

        assertEquals(88, studentMarks.getTotal());
        assertEquals("B+", studentMarks.getGrade());
        assertEquals("3.3", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofBplus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 27);

        assertEquals(87, studentMarks.getTotal());
        assertEquals("B+", studentMarks.getGrade());
        assertEquals("3.3", studentMarks.getGPA());
    }

    @Test
    public void PosLowerBoundaryOfBplus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 25);

        assertEquals(85, studentMarks.getTotal());
        assertEquals("B+", studentMarks.getGrade());
        assertEquals("3.3", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfBplus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 24);

        assertEquals(84, studentMarks.getTotal());
        assertEquals("B+", studentMarks.getGrade());
        assertEquals("3.3", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofB() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 30, 33);

        assertEquals(83, studentMarks.getTotal());
        assertEquals("B", studentMarks.getGrade());
        assertEquals("3", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofB() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 30, 32);

        assertEquals(82, studentMarks.getTotal());
        assertEquals("B", studentMarks.getGrade());
        assertEquals("3", studentMarks.getGPA());
    }

    @Test
    public void PosLowerBoundaryOfB() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 30, 31);

        assertEquals(81, studentMarks.getTotal());
        assertEquals("B", studentMarks.getGrade());
        assertEquals("3", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfB() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 30, 30);

        assertEquals(80, studentMarks.getTotal());
        assertEquals("B", studentMarks.getGrade());
        assertEquals("3", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofBMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 9, 10, 30, 30);

        assertEquals(79, studentMarks.getTotal());
        assertEquals("B-", studentMarks.getGrade());
        assertEquals("2.7", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofBMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 8, 10, 30, 30);

        assertEquals(78, studentMarks.getTotal());
        assertEquals("B-", studentMarks.getGrade());
        assertEquals("2.7", studentMarks.getGPA());
    }

    @Test
    public void PosLowerBoundaryOfBMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 10, 30, 30);

        assertEquals(77, studentMarks.getTotal());
        assertEquals("B-", studentMarks.getGrade());
        assertEquals("2.7", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfBMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 9, 30, 30);

        assertEquals(76, studentMarks.getTotal());
        assertEquals("B-", studentMarks.getGrade());
        assertEquals("2.7", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofCPlus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 9, 29, 30);

        assertEquals(75, studentMarks.getTotal());
        assertEquals("C+", studentMarks.getGrade());
        assertEquals("2.3", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofCPlus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 29, 30);

        assertEquals(74, studentMarks.getTotal());
        assertEquals("C+", studentMarks.getGrade());
        assertEquals("2.3", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfCPlus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 28, 30);

        assertEquals(73, studentMarks.getTotal());
        assertEquals("C+", studentMarks.getGrade());
        assertEquals("2.3", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofC() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 28, 29);

        assertEquals(72, studentMarks.getTotal());
        assertEquals("C", studentMarks.getGrade());
        assertEquals("2", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofC() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 28, 28);

        assertEquals(71, studentMarks.getTotal());
        assertEquals("C", studentMarks.getGrade());
        assertEquals("2", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfC() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 28, 27);

        assertEquals(70, studentMarks.getTotal());
        assertEquals("C", studentMarks.getGrade());
        assertEquals("2", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofCMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 28, 26);

        assertEquals(69, studentMarks.getTotal());
        assertEquals("C-", studentMarks.getGrade());
        assertEquals("1.7", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofCMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 28, 25);

        assertEquals(68, studentMarks.getTotal());
        assertEquals("C-", studentMarks.getGrade());
        assertEquals("1.7", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfCMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 27, 25);

        assertEquals(67, studentMarks.getTotal());
        assertEquals("C-", studentMarks.getGrade());
        assertEquals("1.7", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofDPlus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 8, 26, 25);

        assertEquals(66, studentMarks.getTotal());
        assertEquals("D+", studentMarks.getGrade());
        assertEquals("1.3", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofDPlus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 7, 26, 25);

        assertEquals(65, studentMarks.getTotal());
        assertEquals("D+", studentMarks.getGrade());
        assertEquals("1.3", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfDPlus() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 6, 26, 25);

        assertEquals(64, studentMarks.getTotal());
        assertEquals("D+", studentMarks.getGrade());
        assertEquals("1.3", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofD() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 6, 25, 25);

        assertEquals(63, studentMarks.getTotal());
        assertEquals("D", studentMarks.getGrade());
        assertEquals("1", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofD() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 6, 24, 25);

        assertEquals(62, studentMarks.getTotal());
        assertEquals("D", studentMarks.getGrade());
        assertEquals("1", studentMarks.getGPA());
    }

    @Test
    public void PosLowerBoundaryOfD() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 6, 24, 24);

        assertEquals(61, studentMarks.getTotal());
        assertEquals("D", studentMarks.getGrade());
        assertEquals("1", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfD() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 6, 23, 24);

        assertEquals(60, studentMarks.getTotal());
        assertEquals("D", studentMarks.getGrade());
        assertEquals("1", studentMarks.getGPA());
    }

    @Test
    public void upperBoundaryofF() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 6, 22, 24);

        assertEquals(59, studentMarks.getTotal());
        assertEquals("F", studentMarks.getGrade());
        assertEquals("0", studentMarks.getGPA());
    }

    @Test
    public void NegUpperBoundaryofF() {
        StudentMarks studentMarks = new StudentMarks(student, 7, 6, 21, 24);

        assertEquals(58, studentMarks.getTotal());
        assertEquals("F", studentMarks.getGrade());
        assertEquals("0", studentMarks.getGPA());
    }

    @Test
    public void PosLowerBoundaryOfF() {
        StudentMarks studentMarks = new StudentMarks(student, 1, 0, 0, 0);

        assertEquals(1, studentMarks.getTotal());
        assertEquals("F", studentMarks.getGrade());
        assertEquals("0", studentMarks.getGPA());
    }

    @Test
    public void LowerBoundaryOfF() {
        StudentMarks studentMarks = new StudentMarks(student, 0, 0, 0, 0);

        assertEquals(0, studentMarks.getTotal());
        assertEquals("F", studentMarks.getGrade());
        assertEquals("0", studentMarks.getGPA());
    }

    @Test
    public void testGetGrade_BMinus() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 8, 40);

        assertEquals("B-", studentMarks.getGrade());
    }

    @Test
    public void testGetGrade_C() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 2, 40);

        assertEquals("C", studentMarks.getGrade());
    }

    @Test
    public void testGetGrade_DPlus() {
        StudentMarks studentMarks = new StudentMarks(student, 2, 2, 30, 30);

        assertEquals("D+", studentMarks.getGrade());
    }

    @Test
    public void testGetGrade_F() {
        StudentMarks studentMarks = new StudentMarks(student, 0, 14, 15, 30);

        assertEquals("F", studentMarks.getGrade());
    }


@Test
    public void testGetGPA_Four() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30 , 40);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("4", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_ThreePointSeven() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 40);

        assertEquals("3.7", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_TwoPointThree() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 25);

        assertEquals("2.3", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_OnePointThree() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 20, 25);

        assertEquals("1.3", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_OnePointSeven() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 10, 20, 28);

        assertEquals("1.7", studentMarks.getGPA());
    }
    @Test
    public void testGetGPA_TwoPointSeven() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 29);

        assertEquals("2.7", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_Two() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 20, 20);

        assertEquals("2", studentMarks.getGPA());
    }

    @Test
    public void testGetGPA_One() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 10, 20);

        assertEquals("1", studentMarks.getGPA());
    }
    
 

    @Test
    public void testToString() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 10, 40);

        assertEquals("Mahmoud 2001866 3 B", studentMarks.toString());
    }

    @Test
    public void testGetGrade_over100() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30, 45);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("Not allowed", studentMarks.getGrade());
    }
    @Test
    public void testGetGPA_over100() {
        StudentMarks studentMarks = new StudentMarks(student, 10, 20, 30 , 45);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("Not allowed", studentMarks.getGPA());
    }

    @Test
    public void testGetGrade_negative() {
        StudentMarks studentMarks = new StudentMarks(student, 0, 0, 0, -1);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("F", studentMarks.getGrade());
    }
    @Test
    public void testGetGPA_negative() {
        StudentMarks studentMarks = new StudentMarks(student, 0, 0, 0 , -1);
        // discovered that , more than 100 it would give an F overlapping
        assertEquals("0", studentMarks.getGPA());
    }
    @Test
    public void testGetTotal_NegativeValues() {
        StudentMarks studentMarks = new StudentMarks(student, -10, 0, 0, 0);
        // Assert that the total is calculated correctly, potentially handling negatives in a specific way (e.g., 0)
        assertEquals(0, studentMarks.getTotal());
    }

    @Test
    public void testSetActivities_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(student);
        studentMarks.setActivities(-10);
        assertEquals(0, studentMarks.getActivities());
    }

    @Test
    public void testSetOral_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(student);
        studentMarks.setOral(-20);
        assertEquals(0, studentMarks.getOral());
    }

    @Test
    public void testSetMidterm_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(student);
        studentMarks.setMidterm(-30);
        assertEquals(0, studentMarks.getMidterm());
    }

    @Test
    public void testSetFinal_NegativeValue() {
        StudentMarks studentMarks = new StudentMarks(student);
        studentMarks.setFinal(-40);
        assertEquals(0, studentMarks.getFinal());
    }

    @Test
    public void testConstructorWithAllNegatives() {
        StudentMarks studentMarks = new StudentMarks(student, -10, -20, -30, -40);

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
        StudentMarks studentMarks = new StudentMarks(student, 0, 0, 0, 0);
        assertEquals("F", studentMarks.getGrade());
        assertEquals("0", studentMarks.getGPA());
    }

    @Test
    public void testAllMaximumMarks() {
        StudentMarks studentMarks = new StudentMarks(student, 100, 100, 100, 100);
        assertEquals("Not allowed", studentMarks.getGrade());
        assertEquals("Not allowed", studentMarks.getGPA());
    }




    @Test
    public void testSetActivities_MaxValue() {
        StudentMarks studentMarks = new StudentMarks(student);
        studentMarks.setActivities(100);
        assertEquals(100, studentMarks.getActivities());
    }
// Similar tests for setOral, setMidterm, and setFinal methods
@Test
public void testSetActivities_NegativeMaxValue() {
    StudentMarks studentMarks = new StudentMarks(student);
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
