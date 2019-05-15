package finalproject;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EnrollmentSystem {

    private enum State {
        SPLASH,
        DISPLAY_ALL,
        ENROLLMENT,
        DISPLAY_ENROLLED,
        REMOVE
    }

    private static State state = State.SPLASH;
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        ArrayList<Course> courseList = fetchCourses();
        ArrayList<Course> studentCourses = new ArrayList();

        System.out.println("~ Student Course Enrollment System ~");
        System.out.println("D: Display all available courses");
        System.out.println("E: Enroll in courses");
        System.out.println("L: List registered courses");
        System.out.println("R: Remove registered courses");
        System.out.println("X: Exit system");

        while (true) {
            String input = s.nextLine().toUpperCase();

            if (input.equals("D")) state = State.DISPLAY_ALL;
            else if (input.equals("E")) state = State.ENROLLMENT;
            else if (input.equals("L")) state = State.DISPLAY_ENROLLED;
            else if (input.equals("R")) state = State.REMOVE;
            else if (input.equals("X")) break;
            else state = State.SPLASH;

            switch (state) {
                case SPLASH:
                    System.out.println("~ Student Course Enrollment System ~");
                    System.out.println("D: Display all available courses");
                    System.out.println("E: Enroll in courses");
                    System.out.println("L: List registered courses");
                    System.out.println("R: Remove registered courses");
                    System.out.println("X: Exit system");
                    break;
                case DISPLAY_ALL:
                    for (int i = 0; i < courseList.size(); i++) {
                        System.out.println((i + 1) + "\t" + courseList.get(i));
                    }
                    break;
                case ENROLLMENT:
                    System.out.println("Which courses do you want to enroll in? Press Q to go back.");
                    while (true) {
                        String enrollInput = s.next().toUpperCase();
                        if (enrollInput.equals("Q")) {
                            state = State.SPLASH;
                            break;
                        }
                        try {
                            int courseIndex = Integer.parseInt(enrollInput) - 1;
                            Course selectedCourse = courseList.get(courseIndex);
                            if (studentCourses.contains(selectedCourse)) {
                                System.out.println("Already enrolled in " + selectedCourse.getDescriptor() + ".");
                            } else if (selectedCourse.size == 0) {
                                System.out.println(selectedCourse.getDescriptor() + " is already full.");
                            } else {
                                studentCourses.add(selectedCourse);
                                System.out.println("Added: " + selectedCourse.getDescriptor());
                                selectedCourse.size--;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid Input. Please try again.");
                        }  catch (IndexOutOfBoundsException e) {
                            System.out.println("Index out of bounds. Please try again.");
                        }
                    }
                    break;
                case DISPLAY_ENROLLED:
                    if (studentCourses.size() == 0) System.out.println("No Registered Courses.");
                    for (int i = 0; i < studentCourses.size(); i++) {
                        System.out.println((i + 1) + " " + studentCourses.get(i));
                    }
                    break;
                case REMOVE:
                    System.out.println("Which courses do you want to drop? Press Q to go back.");
                    while (true) {
                        String removeInput = s.next().toUpperCase();
                        if (removeInput.equals("Q")) {
                            state = State.SPLASH;
                            break;
                        }
                        try {
                            int courseIndex = Integer.parseInt(removeInput) - 1;
                            Course selectedCourse = studentCourses.get(courseIndex);
                            studentCourses.remove(selectedCourse);
                            System.out.println("Removed: " + selectedCourse.getDescriptor());
                            selectedCourse.size++;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid Input. Please try again.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Index out of bounds. Please try again.");
                        }
                    }
                    break;
            }
        }
        System.out.println("Have a nice day!");
    }

    private static ArrayList fetchCourses() throws IOException {
        ArrayList courses = new ArrayList();
        BufferedReader r = new BufferedReader(new FileReader("finalproject/CourseSchedule.csv"));

        String line = r.readLine();
        while ((line = r.readLine()) != null && !line.isEmpty()) {
            String[] fields = line.split(",");
            Course course = new Course(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5], fields[6], fields[7],
                                       fields[8], fields[9], fields[10], fields[11], fields[12], Integer.parseInt(fields[13]));
            courses.add(course);
        }
        r.close();
        return courses;
    }
}
