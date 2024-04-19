import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void testGetName() {
        Student student = new Student("John", "12345");
        assertEquals("John", student.getName());
    }

    @Test
    public void testSetName() {
        Student student = new Student("John", "12345");
        student.setName("Jane");
        assertEquals("Jane", student.getName());
    }

    @Test
    public void testGetNumber() {
        Student student = new Student("John", "12345");
        assertEquals("12345", student.getNumber());
    }

    @Test
    public void testToString() {
        Student student = new Student("John", "12345");
        assertEquals("John 12345", student.toString());
    }
}
