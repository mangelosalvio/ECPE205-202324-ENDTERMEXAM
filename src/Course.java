public class Course {
    private String courseCode;
    private String name;

    public Course(String courseCode, String name) {
        this.courseCode = courseCode;
        this.name = name;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
