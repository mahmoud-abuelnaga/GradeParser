// modules
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class MarksSheet {
    // attributes
    private Subject subj;
    private Vector<StudentMarks> marks = new Vector<StudentMarks>();

    // methods
    public MarksSheet() {
        // nothing
    }

    public MarksSheet(Subject subj) {
        this.subj = subj;
    }

    public MarksSheet(Subject subj, Vector<StudentMarks> marks) {
        this.subj = subj;
        this.marks = marks;
    }

    public void setSubject(Subject subj) {
        this.subj = subj;
    }

    public Subject getSubject() {
        return subj;
    }

    public void addMark(StudentMarks mark) {
        marks.add(mark);
    }

    public List<StudentMarks> getMarks() {
        return Collections.unmodifiableList(marks);
    }

    @Override
    public String toString() {
        String txt = this.subj + "\nStudent name Student number GPA Grade\n";
        for (final StudentMarks mark: marks) {
            txt += mark + "\n";
        }

        return txt;
    }
}
