import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {

    public JTable courseTable;
    public CourseTableModel courseTableModel;
    public JTextField courseCodeField;
    public JTextField courseNameField;

    public CoursePanel() {
        init();
    }

    private void init() {
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);

        courseCodeField = new JTextField(10); // Adjust size as needed
        courseNameField = new JTextField(20); // Adjust size as needed

        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Course Code:"));
        inputPanel.add(courseCodeField);
        inputPanel.add(new JLabel("Course Name:"));
        inputPanel.add(courseNameField);

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCourseToList();
            }
        });

        inputPanel.add(addButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(courseTable), BorderLayout.CENTER);
    }

    private void addCourseToList() {
        String courseCode = courseCodeField.getText();
        String courseName = courseNameField.getText();
        if (!courseCode.isEmpty() && !courseName.isEmpty()) {
            courseTableModel.addCourse(new Course(courseCode, courseName));

            courseCodeField.setText("");
            courseNameField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter both Course Code and Course Name.");
        }
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
