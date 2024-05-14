import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class GradesParser {
    public static MarksSheet parse(String filePath) throws Exception {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw e;
        }

        String line;
        int lineNo = 0;
        MarksSheet sheet = new MarksSheet();
        Subject subj;
        while ((line = reader.readLine()) != null) {
            String[] subStrings = line.split(",");
            
            if (lineNo == 0) {
                if (subStrings.length != 3) {
                    subj = new Subject("Unknown", "Unknown", 100);
                } else {
                    // String name = subStrings[0].strip();
                    String name = subStrings[0].stripTrailing();
                    String code = subStrings[1].strip();
                    int fullMark = Integer.parseInt(subStrings[2].strip());

                    if (!InputValidator.validSubjectName(name)) {
                        name = "Unknown";
                    }

                    if (!InputValidator.validSubjectCode(code)) {
                        code = "Unknown";
                    }

                    if (!InputValidator.validFullMark(fullMark)) {
                        fullMark = 100;
                    }

                    subj = new Subject(name, code, fullMark);
                }

                sheet.setSubject(subj);

            } else {
                if (subStrings.length != 6) {
                    continue;
                }

                // String name = subStrings[0].strip();
                String name = subStrings[0].stripTrailing();
                String number = subStrings[1].strip();
                int activities, oral, mid, fin;

                try {
                    activities = Integer.parseInt(subStrings[2].strip());
                    oral = Integer.parseInt(subStrings[3].strip());
                    mid = Integer.parseInt(subStrings[4].strip());
                    fin = Integer.parseInt(subStrings[5].strip());
                } catch (Exception e) {
                    continue;
                }

                if (!InputValidator.validStudentName(name)) {
                    name = "Unknown";
                }

                if (!InputValidator.validStudentNumber(number)) {
                    number = "Unknown";
                }

                if (!InputValidator.validActivites(activities)) {
                    activities = 0;
                }

                if (!InputValidator.validOral(oral)) {
                    oral = 0;
                }

                if (!InputValidator.validMidterm(mid)) {
                    mid = 0;
                }
                
                if (!InputValidator.validFinal(fin)) {
                    fin = 0;
                }

                sheet.addMark(new StudentMarks(new Student(name, number), activities, oral, mid, fin));
            }

            lineNo++;
        }
        
        reader.close();

        if (lineNo == 0) {
            throw new Exception("File is empty!");
        }
        
        return sheet;
    }
}
