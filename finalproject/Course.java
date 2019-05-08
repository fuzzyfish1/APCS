package finalproject;

public class Course {

    public final String topic, number, section, title, instructor, building, room, creditHours, days, startDate,
            endDate, startTime, endTime;
    public int size;

    public Course(String topic, String number, String section, String title, String instructor, String building,
                  String room, String creditHours, String days, String startDate, String endDate, String startTime,
                  String endTime, int size) {
        this.topic = topic;
        this.number = number;
        this.section = section;
        this.title = title;
        this.instructor = instructor;
        this.building = building;
        this.room = room;
        this.creditHours = creditHours;
        this.days = days;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.size = size;
    }

    public String getDescriptor(){
        return topic + "\t" + number + "\t" + section + "\t" + title + "\t" + instructor;
    }

    @Override
    public String toString() {
       return topic + "\t" + number + "\t" + section + "\t" + title + "\t" + instructor + "\t" + building + "\t" + room +
               "\t" + creditHours + "\t" + days + "\t" + startDate + "\t" + endDate + "\t" + startTime + "\t" + endTime +
               "\t" + size;
    }

}
