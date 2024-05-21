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
    JScrollPane scrollPane;
    Student student;
    Course course;
    EnrolledCourse enrolledCourse;

    public MainFrame() {
        init();
    }

    public void init() {
        studentsPanel = new StudentsPanel();
        coursePanel = new CoursePanel();
        enrolledTableModel = new EnrolledTableModel();
        enrolleesTable = new JTable(enrolledTableModel);

        enrollButton = new JButton("ENROLL");

        setLayout(new BorderLayout());

        JPanel csPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 2;
        csPanel.add(studentsPanel, gbc);

        gbc.gridx = 2;
        csPanel.add(coursePanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        enrollButton.setHorizontalAlignment(SwingConstants.LEFT);
        csPanel.add(enrollButton, gbc);

        scrollPane = new JScrollPane(enrolleesTable);

        add(csPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        studentsPanel.addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentsPanel.IDTextField.getText().isEmpty() && studentsPanel.nTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please add Student ID and Name", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    student = new Student(studentsPanel.IDTextField.getText(), studentsPanel.nTextField.getText());
                    studentsPanel.studentsTableModel.addStudent(student);
                }
                studentsPanel.IDTextField.setText("");
                studentsPanel.nTextField.setText("");
                studentsPanel.nTextField.requestFocus();
                studentsPanel.studentTable.updateUI();
            }
        });

        coursePanel.addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (coursePanel.coursecodeTextField.getText().isEmpty() && coursePanel.coursenameTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please add Student Course Name and Name", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    course = new Course(coursePanel.coursecodeTextField.getText(), coursePanel.coursenameTextField.getText());
                    coursePanel.courseTableModel.addCourse(course);
                }
                coursePanel.coursecodeTextField.setText("");
                coursePanel.coursenameTextField.setText("");
                coursePanel.coursenameTextField.requestFocus();
                coursePanel.courseTable.updateUI();
            }
        });
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (studentsPanel.studentTable.getSelectedRowCount() != 1 || coursePanel.courseTable.getSelectedRowCount() != 1) {
                    JOptionPane.showMessageDialog(null, "Only 1 course and 1 student should be selected!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                String selectedCourseCode = coursePanel.courseTable.getValueAt(coursePanel.courseTable.getSelectedRow(), 0).toString();
                String selectedCourseName = coursePanel.courseTable.getValueAt(coursePanel.courseTable.getSelectedRow(), 1).toString();
                String selectedStudentId = studentsPanel.studentTable.getValueAt(studentsPanel.studentTable.getSelectedRow(), 0).toString();
                String selectedStudentName = studentsPanel.studentTable.getValueAt(studentsPanel.studentTable.getSelectedRow(), 1).toString();

                Course selectedCourse = new Course(selectedCourseCode, selectedCourseName);
                Student selectedStudent = new Student(selectedStudentId, selectedStudentName);

                EnrolledCourse enrolledCourse = findEnrolledCourse(selectedCourseCode);

                if (enrolledCourse == null) {
                    addNewCourseWithStudent(selectedCourse, selectedStudent);
                } else {
                    if (isStudentAlreadyEnrolled(enrolledCourse, selectedStudentId)) {
                        JOptionPane.showMessageDialog(null, "Error! Existing student in course!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        enrolledCourse.addStudent(selectedStudent);
                        enrolledTableModel.fireTableDataChanged();
                    }
                }
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


        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args) {
        new MainFrame();
    }
}
