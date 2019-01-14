package chapter4;

public class Course {

    public enum Grade {
        A(4.0),
        A_MINUS(3.7),
        B_PLUS(3.3),
        B(3.0),
        B_MINUS(2.7),
        C_PLUS(2.3),
        C(2.0),
        C_MINUS(1.7),
        D_PLUS(1.3),
        D(1.0),
        D_MINUS(0.7),
        F(0.0);

        private double gpa;

        public double getGPA() { return this.gpa; }

        Grade(double gpa) { this.gpa = gpa; }
    }

    private String name;
    private double creditHours;
    private Grade grade;

    public Course(String name, double creditHours) {
        this.name = name;
        this.creditHours = creditHours;
        grade = Grade.F;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String name) {
        this.name = name;
    }

    public double getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(double creditHours) {
        this.creditHours = creditHours;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
