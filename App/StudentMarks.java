// package org.example;

public class StudentMarks {
    // attributes
    private final Student student;
    private int activities = 0;
    private int oral = 0;
    private int midterm = 0;
    private int fin = 0;

    // methods
//    public StudentMarks(Student student) {
//
//        if (student == null){throw IllegalArgumentException.;}
//
//        this.student = student;
//
//    }

    public StudentMarks(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }

        this.student = student;
    }


    public StudentMarks(Student student, int activities, int oral, int midterm, int fin) {
        this.student = student;
        setActivities(activities);
        setOral(oral);
        setMidterm(midterm);
        setFinal(fin);
    }

    public Student getStudent() {
        return student;
    }

    public int getActivities() {
        return activities;
    }

    public void setActivities(int activities) {
        this.activities = Math.max(activities , 0);

    }

    public int getOral() {
        return oral;

    }

    public void setOral(int oral) {
        this.oral =Math.max( oral , 0);


    }

    public int getMidterm() {
        return midterm;
    }

    public void setMidterm(int midterm) {
        this.midterm = Math.max( midterm , 0);
    }

    public int getFinal() {
        return fin;
    }

    public void setFinal(int fin) {
        this.fin = Math.max(fin, 0);

    }

    public int getTotal() {
        return Math.max((activities + oral + midterm + fin), 0);
    }

    public String getGrade() {
        int total = getTotal();

        // if (total > 100 || total < 0) {
        //     throw new Exception("Total must be within 0 and 100");
        // }

        if ((97 <= total) && (total <= 100)) {
            return "A+";
        } else if ((93 <= total) && (total < 97)) {
            return "A";
        } else if ((89 <= total) && (total < 93)) {
            return "A-";
        } else if ((84 <= total) && (total < 89)) {
            return "B+";
        } else if ((80 <= total) && (total < 84)) {
            return "B";
        } else if ((76 <= total) && (total < 80)) {
            return "B-";
        } else if ((73 <= total) && (total < 76)) {
            return "C+";
        } else if ((70 <= total) && (total < 73)) {
            return "C";
        } else if ((67 <= total) && (total < 70)) {
            return "C-";
        } else if ((64 <= total) && (total < 67)) {
            return "D+";
        } else if ((60 <= total) && (total < 64)) {
            return "D";
        } else if((total<60)&& (total>= 0)){
            return "F";
        }
        else {
            return "Not allowed";
        }
    }

    public String getGPA() {
        int total = getTotal();

        // if (total > 100 || total < 0) {
        //     throw new Exception("Total must be within 0 and 100");
        // }

        if ((97 <= total) && (total <= 100)) {
            return "4";
        } else if ((93 <= total) && (total < 97)) {
            return "4";
        } else if ((89 <= total) && (total < 93)) {
            return "3.7";
        } else if ((84 <= total) && (total < 89)) {
            return "3.3";
        } else if ((80 <= total) && (total < 84)) {
            return "3";
        } else if ((76 <= total) && (total < 80)) {
            return "2.7";
        } else if ((73 <= total) && (total < 76)) {
            return "2.3";
        } else if ((70 <= total) && (total < 73)) {
            return "2";
        } else if ((67 <= total) && (total < 70)) {
            return "1.7";
        } else if ((64 <= total) && (total < 67)) {
            return "1.3";
        } else if ((60 <= total) && (total < 64)) {
            return "1";
        } else if((total<60)&& (total>= 0)){
            return "0";
        }
        else {
            return "Not allowed";
        }
    }
    @Override
    public String toString() {
        return student + " " + this.getGPA() + " " + this.getGrade();
    }
}
