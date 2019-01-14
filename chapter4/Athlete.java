package chapter4;

public class Athlete extends Student {

    private String sportName, coachName;

    public Athlete(Student student, String sportName, String coachName) {
        super(student.getName(),
                student.getIdNumber(),
                student.getDOB(),
                student.getGender(),
                student.getAddress(),
                student.getSchool(),
                student.getGradeLevel(),
                student.getGPA());
        this.sportName = sportName;
        this.coachName = coachName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSport: " + sportName + "\nCoach: " + coachName;
    }
}
