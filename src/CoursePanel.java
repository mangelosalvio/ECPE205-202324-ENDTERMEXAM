import javax.swing.*;
import java.awt.*;

public class CoursePanel extends JPanel {

    public JLabel courseNameLabel, courseCodeLabel;
    public JTextField courseNameField, courseCodeField;
    public JTable courseTable;
    public CourseTableModel courseTableModel;


    public CoursePanel() {
        init();
    }
    private void init(){
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);
    }
}
