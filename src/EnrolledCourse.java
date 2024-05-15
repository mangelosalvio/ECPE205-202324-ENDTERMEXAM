import java.util.ArrayList;

public class EnrolledCourse {
    private Course course;
    private ArrayList<Student> students;

    public EnrolledCourse(Course course) {
        this.course = course;
        this.students = new ArrayList<>();
    }

    public void addStudent (Student student) {
        students.add(student);
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }



    public String studentsToString() {
        return students.toString().replace("[","").replace("]","");
    }
}