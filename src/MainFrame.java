import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    StudentsPanel studentsPanel;
    CoursePanel coursePanel;
    JTable enrolleesTable;
    EnrolledTableModel enrolledTableModel;

    TestFrames testFrames;
    public MainFrame() {
        init();
    }

    private void init() {

        Container container = this.getContentPane();

        studentsPanel = new StudentsPanel();
        coursePanel = new CoursePanel();
        enrolledTableModel = new EnrolledTableModel();
        enrolleesTable = new JTable(enrolledTableModel);

        testFrames = new TestFrames();


        container.add(enrolleesTable, BorderLayout.SOUTH);
        container.add(testFrames, BorderLayout.SOUTH);

        JButton enrollButton = new JButton("ENROLL");

        JPanel topPanel = new JPanel(new BorderLayout());
        JPanel topSubPanel = new JPanel(new GridLayout(0, 2));
        topSubPanel.add(studentsPanel);
        topSubPanel.add(coursePanel);

        topPanel.add(topSubPanel, BorderLayout.CENTER);
        topPanel.add(enrollButton, BorderLayout.SOUTH);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(enrolleesTable);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
        splitPane.setDividerLocation(300);

        container.setLayout(new BorderLayout());
        container.add(splitPane, BorderLayout.CENTER);


        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedStudentRow = studentsPanel.studentsTable.getSelectedRow();
                int selectedCourseRow = coursePanel.table.getSelectedRow();

        setVisible(true);
        setTitle("GUI");
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);


                if (selectedStudentRow != -1 && selectedCourseRow != -1) {
                    String studentId = (String) studentsPanel.studentsTable.getValueAt(selectedStudentRow, 0);
                    String studentName = (String) studentsPanel.studentsTable.getValueAt(selectedStudentRow, 1);
                    Student student = new Student(studentId, studentName);

                    String courseCode = (String) coursePanel.table.getValueAt(selectedCourseRow, 0);
                    String courseName = (String) coursePanel.table.getValueAt(selectedCourseRow, 1);
                    Course course = new Course(courseCode, courseName);

                    boolean courseFound = false;
                    for (EnrolledCourse enrolledCourse : enrolledTableModel.enrolledCourses) {
                        if (enrolledCourse.getCourse().getCourseCode().equals(courseCode)) {
                            enrolledCourse.addStudent(student);
                            courseFound = true;
                            break;
                        }
                    }

                    if (!courseFound) {
                        EnrolledCourse newEnrolledCourse = new EnrolledCourse(course);
                        newEnrolledCourse.addStudent(student);
                        enrolledTableModel.enrolledCourses.add(newEnrolledCourse);
                    }

                    enrolledTableModel.fireTableDataChanged();
                } else {
                    JOptionPane.showMessageDialog(null, "Please select a student and a course", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setTitle("Course Enrollment System");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 900);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);

    }


}
