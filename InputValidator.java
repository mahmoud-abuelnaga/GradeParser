/**
 * InputValidator
 */
public class InputValidator {
    // helpers
    private static boolean startWithSpace(final String txt) {
        if (txt == null) {
            return false;
        }

        return txt.charAt(0) == ' ';
    }

    private static boolean onlyAlphaSpaces(final String txt) {
        if (txt == null) {
            return false;
        }

        return txt.matches("^[a-zA-Z\\s]+$");
    }

    // main functions
    public static boolean validSubjectName(final String name) {
        return !startWithSpace(name) && onlyAlphaSpaces(name);
    }
    
    public static boolean validSubjectCode(final String code) {
        return code.matches("^[a-zA-Z]{3}[0-9]{3}s?$");
    }

    public static boolean validFullMark(final int mark) { // <====
        return mark == 100;
    }

    public static boolean validStudentName(final String name) {
        return !startWithSpace(name) && onlyAlphaSpaces(name);
    }

    public static boolean validStudentNumber(final String num) {
        return num.matches("[0-9]{7}([0-9]|[a-zA-Z])");
    }

    public static boolean validActivites(final int mark) {
        return (0 <= mark) && (mark <= 10);
    }

    public static boolean validOral(final int mark) {
        return (0 <= mark) && (mark <= 10);
    }
    
    public static boolean validMidterm(final int mark) {
        return (0 <= mark) && (mark <= 20);
    }

    public static boolean validFinal(final int mark) {
        return (0 <= mark) && (mark <= 60);
    }

    public static boolean validTotal(final int activities, final int oral, final int mid, final int fin) {
        int total = activities + oral + mid + fin;
        return (0 <= total) && (total <= 100);
    }
}