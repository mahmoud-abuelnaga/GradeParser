public class Student {
    // attributes
    private String name;
    private final String number;

    // methods
    public Student(String name, String number) {
        setName(name);
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            name = "";
        }
        
        this.name = name;
    }

    public String getNumber() {
        return number;
    }
    
    @Override
    public String toString() {
        return name + " " + number;
    }
}