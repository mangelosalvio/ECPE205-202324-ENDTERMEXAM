import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    StudentsPanel studentsPanel;
    CoursePanel coursePanel;
    JTable enrolleesTable;
    EnrolledTableModel enrolledTableModel;
    JButton enrollButton;

    public MainFrame() {
        init();
    }

    private void init() {
        studentsPanel = new StudentsPanel();
        coursePanel = new CoursePanel();
        enrolledTableModel = new EnrolledTableModel();
        enrolleesTable = new JTable(enrolledTableModel);

        this.add(coursePanel);

        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        enrolledTableModel = new EnrolledTableModel();
        enrolleesTable = new JTable(enrolledTableModel);

        addComponent(studentsPanel, 0, 0, 1,1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST);
        addComponent(coursePanel, 1, 0, 1,1, 1, 1, GridBagConstraints.BOTH, GridBagConstraints.NORTHEAST);
        addComponent(enrollButton = new JButton("ENROLL"),0,1,0,1,1,1,GridBagConstraints.NONE, GridBagConstraints.WEST);
        addComponent(new JScrollPane(enrolleesTable),0,2,2,1,1,1,GridBagConstraints.BOTH, GridBagConstraints.SOUTH);

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isValidSelection()) {
                    showError("Only 1 course and 1 student should be selected!");
                    return;
                }

                String selectedCourseCode = getSelectedCourseCode();
                String selectedStudentId = getSelectedStudentId();

                Course selectedCourse = new Course(selectedCourseCode, getSelectedCourseName());
                Student selectedStudent = new Student(selectedStudentId, getSelectedStudentName());

                EnrolledCourse enrolledCourse = findEnrolledCourse(selectedCourseCode);

                if (enrolledCourse == null) {
                    addNewCourseWithStudent(selectedCourse, selectedStudent);
                } else if (isStudentAlreadyEnrolled(enrolledCourse, selectedStudentId)) {
                    showError("Error! Existing student in course!");
                } else {
                    enrolledCourse.addStudent(selectedStudent);
                    enrolledTableModel.fireTableDataChanged();
                }
            }

                private boolean isValidSelection() {
                    return studentsPanel.studentsTable.getSelectedRowCount() == 1 &&
                            coursePanel.courseTable.getSelectedRowCount() == 1;
                }

                private void showError(String message) {
                    JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
                }

                private String getSelectedCourseCode() {
                    return getValueAtSelectedRow(coursePanel.courseTable, 0);
                }

                private String getSelectedCourseName() {
                    return getValueAtSelectedRow(coursePanel.courseTable, 1);
                }

                private String getSelectedStudentId() {
                    return getValueAtSelectedRow(studentsPanel.studentsTable, 0);
                }

                private String getSelectedStudentName() {
                    return getValueAtSelectedRow(studentsPanel.studentsTable, 1);
                }

                private String getValueAtSelectedRow(JTable table, int columnIndex) {
                    return table.getValueAt(table.getSelectedRow(), columnIndex).toString();
                }

            private EnrolledCourse findEnrolledCourse(String courseCode) {
                for (EnrolledCourse enrolledCourse : enrolledTableModel.enrolledCourses) {
                    if (enrolledCourse.getCourse().getCourseCode().equals(courseCode)) {
                        return enrolledCourse;
                    }
                }
                return null;
            }

            private boolean isStudentAlreadyEnrolled(EnrolledCourse enrolledCourse, String studentId) {
                for (Student student : enrolledCourse.getStudents()) {
                    if (student.getId().equals(studentId)) {
                        return true;
                    }
                }
                return false;
            }

                private void addNewCourseWithStudent(Course course, Student student) {
                    EnrolledCourse enrolledCourse = new EnrolledCourse(course);
                    enrolledCourse.addStudent(student);
                    enrolledTableModel.enrolledCourses.add(enrolledCourse);
                    enrolledTableModel.fireTableDataChanged();
                }
        });

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void addComponent(Component component, int gridx, int gridy, int width, int height, int weightX, int weightY, int fill, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = new Insets(3, 5, 3, 5);
        this.add(component, c);
    }
}
