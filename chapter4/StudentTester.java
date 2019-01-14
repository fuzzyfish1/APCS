package chapter4;

public class StudentTester {

    public static void main(String args[]) {
        Student connorSutton = new Student("Connor Sutton", "18000525", "09/20/2000", "Male",
                "107 Stonegate Dr, Oswego IL", "Oswego High School", 12, 4.56);
        Student karaNidec = new Student();

        karaNidec.setAddress("108 Stonegate Dr, Noswego IL");
        karaNidec.setDOB("10/20/2000");
        karaNidec.setGender("Female");
        karaNidec.setGPA(4.57);
        karaNidec.setGradeLevel(11);
        karaNidec.setIdNumber("18000524");
        karaNidec.setName("Kara Nidec");
        karaNidec.setSchool("Noswego High School");

        Athlete newAthlete = new Athlete(karaNidec, "Tennis", "Parr");

        System.out.println(connorSutton);
        System.out.println(newAthlete);
    }
}
