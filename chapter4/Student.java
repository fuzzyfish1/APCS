package chapter4;

import java.util.ArrayList;

public class Student {

    private String name, idNumber, DOB, gender, address, school;
    private int gradeLevel;
    private double gpa;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student() {

    }

    public Student(String name, String idNumber, String DOB, String gender, String address, String school, int gradeLevel, double gpa) {
        this.name = name;
        this.idNumber = idNumber;
        this.DOB = DOB;
        this.gender = gender;
        this.address = address;
        this.school = school;
        this.gradeLevel = gradeLevel;
        this.gpa = gpa;
    }

    public void addCourse(Course newCourse) {
        courses.add(newCourse);
    }

    public void removeCourse(String courseName) {
        for(Course course: courses) {
            if (course.getCourseName().equals(courseName)) {
                courses.remove(course);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(int gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nID Number: " + idNumber + "\nDate of Birth: " + DOB + "\nGender: " + gender +
                "\nAddress: " + address + "\nSchool Name: " + school + "\nGrade Level: " + gradeLevel + "\nGPA: " + gpa;
    }
}
