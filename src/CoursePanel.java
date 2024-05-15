import javax.swing.*;
import java.awt.*;

public class CoursePanel extends JPanel {

    public JTable courseTable;
    public CourseTableModel courseTableModel;

    public CoursePanel() {
        init();
    }

    private void init(){
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);

        setLayout(new BorderLayout());
        add(new JScrollPane(courseTable), BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Course Panel");

        CoursePanel panel = new CoursePanel();
        frame.getContentPane().add(panel);

        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        panel.courseTableModel.addCourse(new Course("ECPE205", "Software Design"));
        panel.courseTableModel.addCourse(new Course("ECPE303", "Feedback and Control Systems"));
    }
}
