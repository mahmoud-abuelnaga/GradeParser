/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package inputvalidatorunittesting;

import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author fawzy
 */


public class InputValidatorTest {

    @Test
    public void testValidSubjectName() {
        /* Empty Partition */   /* Both those tests covers the lower boundary */
        assertFalse("Should return false for null input", InputValidator.validSubjectName(null));   
        assertFalse("Should return false for empty string", InputValidator.validSubjectName(""));

        /* Start with Space Partition */
        assertFalse("Should return false for leading space", InputValidator.validSubjectName(" Database Systems")); /* valid after that */
        assertFalse("leading space & invalid", InputValidator.validSubjectName(" Software2tEsting"));    /* invalid after that */

        /* Doesn't start with space */
        assertTrue("Should return true for valid name", InputValidator.validSubjectName("Software Testing"));   /* and valid */
        assertFalse("Should return false for alphanumeric input", InputValidator.validSubjectName("Software Testing Part4"));   /* and not valid */

        /* End with space Partition */
        assertTrue("ends with space", InputValidator.validSubjectName("Computer arch "));
        assertTrue("ends with tab", InputValidator.validSubjectName("new mexico    "));

        /* numbers partition */
        assertFalse("number with leading space", InputValidator.validSubjectName("102"));

        /* Special characters partition */
        assertFalse("multiple special character", InputValidator.validSubjectName("$*&"));
        assertFalse("underscore in middle", InputValidator.validSubjectName("toxic_subject"));
    }

    @Test
    public void testValidSubjectCode() {
        /* Empty Partition */
        assertFalse("Should return false for null input", InputValidator.validSubjectCode(null));
        assertFalse("Should return false for empty string", InputValidator.validSubjectCode(""));

        /* numbers partition*/
        assertFalse("invalid numbers with characters", InputValidator.validSubjectCode("123CSEs"));

        /* special characters partition */
        assertFalse("invalid special characters with valid code", InputValidator.validSubjectCode("!CSE123"));
        
        /* Space partition */
        assertFalse("Should return false for trailing space", InputValidator.validSubjectCode("CSE337 "));
        
        /* Valid partition */
        assertTrue("Should return true for valid code", InputValidator.validSubjectCode("CSE337"));
        assertTrue("Should return true for valid code with 's'", InputValidator.validSubjectCode("ENG456s"));
        assertTrue("should return true for small chars", InputValidator.validSubjectCode("cse123"));

        /* Invalid partition */
        assertFalse("Should return false for incomplete code", InputValidator.validSubjectCode("CSE12"));
        assertFalse("Should return false for too long code", InputValidator.validSubjectCode("CSE1234"));

        /* too Long partition */
        assertFalse("return false for too long code", InputValidator.validSubjectCode("CSE123ss"));
    }

    @Test
    public void testValidFullMark() {   /* Those tests cover boundary value analysis */
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
        /* Valid cases */  /* Just at boundary */
        assertTrue("Should return true for valid student number", InputValidator.validStudentNumber("2001070a"));
        assertTrue("Should return true for valid numeric student number", InputValidator.validStudentNumber("20010700"));

        /* Invalid cases */
        assertFalse("Should return false for too short number", InputValidator.validStudentNumber("123456"));
        assertFalse("Should return false for non-numeric input", InputValidator.validStudentNumber("abcdefg"));

        /* Negative boundary */
        assertFalse("starts with char", InputValidator.validStudentNumber("e1234567"));
        assertFalse("7 chars", InputValidator.validStudentNumber("2001866"));
        assertFalse("9 chars", InputValidator.validStudentNumber("20018668s"));

        /* Empty and null */
        assertFalse("passing null", InputValidator.validStudentNumber(null));
        assertFalse("passing empty", InputValidator.validStudentNumber(""));
    }

    @Test
    public void testValidActivities() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validActivites(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validActivites(10));
        assertFalse("Should return false for negative mark", InputValidator.validActivites(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validActivites(11));
        assertTrue("valid number in the middle", InputValidator.validActivites(5));
    }

    @Test
    public void testValidOral() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validOral(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validOral(10));
        assertFalse("Should return false for negative mark", InputValidator.validOral(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validOral(11));
        assertTrue("middle value for oral", InputValidator.validOral(5));
    }

    @Test
    public void testValidMidterm() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validMidterm(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validMidterm(20));
        assertFalse("Should return false for negative mark", InputValidator.validMidterm(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validMidterm(21));
        assertTrue("middle midterm value", InputValidator.validMidterm(7));
    }

    @Test
    public void testValidFinal() {
        assertTrue("Should return true for minimum valid mark", InputValidator.validFinal(0));
        assertTrue("Should return true for maximum valid mark", InputValidator.validFinal(60));
        assertFalse("Should return false for negative mark", InputValidator.validFinal(-1));
        assertFalse("Should return false for mark above valid range", InputValidator.validFinal(61));
        assertTrue("middle final value", InputValidator.validFinal(40));
    }

    @Test
    public void testValidTotal() {
        assertTrue("Should return true for total of 100", InputValidator.validTotal(10, 10, 20, 60));
        assertFalse("Should return false for total above 100", InputValidator.validTotal(10, 10, 20, 61));
        assertFalse("Should return false for negative input leading to negative total", InputValidator.validTotal(-1, 0, 0, 0));
        assertTrue("middle value for total", InputValidator.validTotal(5, 10, 20, 50));
    }
}

