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
    Student student;
    Course course;
    EnrolledCourse enrolledCourse;
    Boolean existingCourse;

    public MainFrame() {
        init();
    }

    private void init() {
        studentsPanel = new StudentsPanel();
        coursePanel = new CoursePanel();
        enrolledTableModel = new EnrolledTableModel();
        enrolleesTable = new JTable(enrolledTableModel);

        enrollButton = new JButton("Enroll");

        this.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints e = new GridBagConstraints();

        e.gridx = 0;
        e.gridy = 0;
        e.gridwidth = 2;
        e.gridheight = 2;
        topPanel.add(studentsPanel, e);

        e.gridx = 2;
        topPanel.add(coursePanel, e);

        e.gridx = 0;
        e.gridy = 2;
        e.gridwidth = 1;
        e.gridheight = 1;
        enrollButton.setHorizontalAlignment(SwingConstants.LEFT);
        topPanel.add(enrollButton, e);

        JScrollPane scrollPane = new JScrollPane(enrolleesTable);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);

        studentsPanel.studentAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(studentsPanel.studentIDField.getText().isBlank() ||
                studentsPanel.nameField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Complete the required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    student = new Student(studentsPanel.studentIDField.getText(),
                            studentsPanel.nameField.getText());
                    studentsPanel.studentsTableModel.addStudent(student);
                    studentsPanel.studentsTableModel.fireTableDataChanged();
                }
                studentsPanel.studentIDField.setText("");
                studentsPanel.nameField.setText("");
            }
        });

        coursePanel.courseAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(coursePanel.courseNameField.getText().isBlank() ||
                coursePanel.courseCodeField.getText().isBlank()) {
                    JOptionPane.showMessageDialog(null, "Complete the required fields!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    course = new Course(coursePanel.courseCodeField.getText(),
                            coursePanel.courseNameField.getText());
                    coursePanel.courseTableModel.addCourse(course);
                    coursePanel.courseTableModel.fireTableDataChanged();
                }
                coursePanel.courseNameField.setText("");
                coursePanel.courseCodeField.setText("");
            }
        });

        existingCourse = true;

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(studentsPanel.studentsTable.getSelectedRows().length > 1 ||
                coursePanel.courseTable.getSelectedRows().length > 1) {
                    JOptionPane.showMessageDialog(null, "Only 1 course and 1 Student should be selected!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if(enrolledTableModel.enrolledCourses.isEmpty()){
                    course = new Course(coursePanel.courseTable.getValueAt(
                            coursePanel.courseTable.getSelectedRow(), 0).toString(),
                            coursePanel.courseTable.getValueAt(
                                    coursePanel.courseTable.getSelectedRow(), 1).toString());
                    enrolledCourse = new EnrolledCourse(course);

                    student = new Student(studentsPanel.studentsTable.getValueAt(
                            studentsPanel.studentsTable.getSelectedRow(), 0).toString(),
                            studentsPanel.studentsTable.getValueAt(
                                    studentsPanel.studentsTable.getSelectedRow(), 1).toString());
                    enrolledCourse.addStudent(student);

                    enrolledTableModel.enrolledCourses.add(enrolledCourse);
                    enrolledTableModel.fireTableDataChanged();
                    existingCourse = true;
                }
                else {
                    for(int i = 0; i < enrolledTableModel.enrolledCourses.size(); i++) {
                        if(coursePanel.courseTable.getValueAt(coursePanel.courseTable.getSelectedRow(),0).toString()
                                .equals(enrolledTableModel.enrolledCourses.get(i).getCourse().getCourseCode())) {

                            for(int j = 0; j < enrolledTableModel.enrolledCourses.get(i).getStudents().size(); j++) {
                                if(enrolledTableModel.enrolledCourses.get(i).getStudents().get(j).getId().equals(
                                        studentsPanel.studentsTable.getValueAt(studentsPanel.studentsTable.getSelectedRow(), 0).toString())
                                ) {
                                    JOptionPane.showMessageDialog(null, "Error! Existing student in course!", "Error", JOptionPane.ERROR_MESSAGE);

                                }
                                else {
                                    student = new Student(studentsPanel.studentsTable.getValueAt(studentsPanel.studentsTable.getSelectedRow(), 0).toString(),
                                            studentsPanel.studentsTable.getValueAt(studentsPanel.studentsTable.getSelectedRow(), 1).toString());
                                    enrolledTableModel.enrolledCourses.get(i).addStudent(student);
                                    break;
                                }
                            }
                        }
                        else{
                            course = new Course(coursePanel.courseTable.getValueAt(
                                    coursePanel.courseTable.getSelectedRow(), 0).toString(),
                                    coursePanel.courseTable.getValueAt(
                                            coursePanel.courseTable.getSelectedRow(), 1).toString());
                            enrolledCourse = new EnrolledCourse(course);

                            student = new Student(studentsPanel.studentsTable.getValueAt(
                                    studentsPanel.studentsTable.getSelectedRow(), 0).toString(),
                                    studentsPanel.studentsTable.getValueAt(
                                            studentsPanel.studentsTable.getSelectedRow(), 1).toString());
                            enrolledCourse.addStudent(student);

                            enrolledTableModel.enrolledCourses.add(enrolledCourse);
                            enrolledTableModel.fireTableDataChanged();
                        }
                    }
                    enrolledTableModel.fireTableDataChanged();
                }
                /*else if(existingCourse) {
                    for(int i = 0; i < enrolledTableModel.enrolledCourses.size(); i++) {
                        if(coursePanel.courseTable.getValueAt(
                                coursePanel.courseTable.getSelectedRow(), 0).toString()
                                .equals(enrolledTableModel.enrolledCourses.get(i).getCourse().getCourseCode())) {
                            JOptionPane.showMessageDialog(null, "Course is already existing!", "Error", JOptionPane.ERROR_MESSAGE);
                            existingCourse = true;
                            break;

                        }
                        existingCourse = false;
                    }

                }

                if(!existingCourse) {
                    course = new Course(coursePanel.courseTable.getValueAt(
                            coursePanel.courseTable.getSelectedRow(), 0).toString(),
                            coursePanel.courseTable.getValueAt(
                                    coursePanel.courseTable.getSelectedRow(), 1).toString());
                    enrolledCourse = new EnrolledCourse(course);

                    student = new Student(studentsPanel.studentsTable.getValueAt(
                            studentsPanel.studentsTable.getSelectedRow(), 0).toString(),
                            studentsPanel.studentsTable.getValueAt(
                                    studentsPanel.studentsTable.getSelectedRow(), 1).toString()
                    );
                    enrolledCourse.addStudent(student);

                    enrolledTableModel.enrolledCourses.add(enrolledCourse);
                    enrolledTableModel.fireTableDataChanged();
                }*/
            }
        });

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
