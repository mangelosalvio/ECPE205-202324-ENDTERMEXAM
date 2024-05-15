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

        // Add components to the panel
        // For demonstration, let's add the table to the panel
        add(new JScrollPane(courseTable));
    }

    public static void main(String[] args) {
        // Create a JFrame
        JFrame frame = new JFrame("Course Panel");

        // Create an instance of CoursePanel
        CoursePanel panel = new CoursePanel();

        // Add the CoursePanel to the JFrame
        frame.getContentPane().add(panel);

        // Set JFrame size and make it visible
        frame.setSize(400, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
