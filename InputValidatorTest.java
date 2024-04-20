/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputvalidatorunittesting;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fawzy
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void testValidSubjectName() {
        assertFalse("Should return false for null input", InputValidator.validSubjectName(null));
        assertFalse("Should return false for empty string", InputValidator.validSubjectName(""));
        assertFalse("Should return false for leading space", InputValidator.validSubjectName(" Database Systems"));
        assertTrue("Should return true for valid name", InputValidator.validSubjectName("Software Testing"));
        assertFalse("Should return false for alphanumeric input", InputValidator.validSubjectName("Software Testing Part4"));
    }

    @Test
    public void testValidSubjectCode() {
        assertTrue("Should return true for valid code", InputValidator.validSubjectCode("CSE337"));
        assertTrue("Should return true for valid code with 's'", InputValidator.validSubjectCode("ENG456s"));
        assertFalse("Should return false for incomplete code", InputValidator.validSubjectCode("CSE12"));
        assertFalse("Should return false for numeric code", InputValidator.validSubjectCode("33377s"));
        assertFalse("Should return false for too long code", InputValidator.validSubjectCode("CSE1234"));
    }

    @Test
    public void testValidFullMark() {
        assertTrue("Should return true for mark of 100", InputValidator.validFullMark(100));
        assertFalse("Should return false for mark less than 100", InputValidator.validFullMark(99));
        assertFalse("Should return false for mark greater than 100", InputValidator.validFullMark(101));
    }

    @Test
    public void testValidStudentName() {
        assertFalse("Should return false for null input", InputValidator.validStudentName(null));
        assertFalse("Should return false for empty string", InputValidator.validStudentName(""));
        assertFalse("Should return false for leading space", InputValidator.validStudentName(" Fawzy Bashandy"));
        assertTrue("Should return true for valid name", InputValidator.validStudentName("Fawzy Bashandy"));
        assertFalse("Should return false for alphanumeric input", InputValidator.validStudentName("Faw2y Bashandy"));
    }

    @Test
    public void testValidStudentNumber() {
        assertTrue("Should return true for valid student number", InputValidator.validStudentNumber("2001070a"));
        assertTrue("Should return true for valid numeric student number", InputValidator.validStudentNumber("20010700"));
        assertFalse("Should return false for too short number", InputValidator.validStudentNumber("123456"));
        assertFalse("Should return false for non-numeric input", InputValidator.validStudentNumber("abcdefg"));
    }

    @Test
    public void testValidActivities() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validActivites(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validActivites(10));
        assertFalse("Should return false for negative mark", InputValidator.validActivites(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validActivites(11));
    }

    @Test
    public void testValidOral() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validOral(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validOral(10));
        assertFalse("Should return false for negative mark", InputValidator.validOral(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validOral(11));
    }

    @Test
    public void testValidMidterm() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validMidterm(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validMidterm(20));
        assertFalse("Should return false for negative mark", InputValidator.validMidterm(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validMidterm(21));
    }

    @Test
    public void testValidFinal() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validFinal(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validFinal(60));
        assertFalse("Should return false for negative mark", InputValidator.validFinal(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validFinal(61));
    }

    @Test
    public void testValidTotal() {
        assertTrue("Should return true for total of 100", InputValidator.validTotal(10, 10, 20, 60));
        assertFalse("Should return false for total above 100", InputValidator.validTotal(10, 10, 20, 61));
        assertFalse("Should return false for negative input leading to negative total", InputValidator.validTotal(-1, 0, 0, 0));
    }
}

