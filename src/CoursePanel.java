import javax.swing.*;

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


        add(new JScrollPane(courseTable));
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Course Panel");


        CoursePanel panel = new CoursePanel();

        frame.getContentPane().add(panel);

        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
