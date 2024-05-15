import javax.swing.*;
import java.awt.*;

public class StudentCoursePanel extends JPanel {
    StudentsPanel studentsPanel;
    CoursePanel coursePanel;

    public StudentCoursePanel() {
        setLayout(new FlowLayout());

        add(studentsPanel = new StudentsPanel());
        add(coursePanel = new CoursePanel());
    }
}
