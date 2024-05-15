public class Subject {
    // attributes
    private final String name;
    private final String code;
    private final int fullMark;

    // methods
    public Subject(String name, String code, int fullMark) {
        if (name == null) {
            name = "";
        }

        if (code == null) {
            code = "";
        }

        this.name = name;
        this.code = code;
        this.fullMark = fullMark;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getFullMark() {
        return fullMark;
    }

    @Override
    public String toString() {
        return "Subject Name: " + name + " Max Mark: " + fullMark;
    }
}
