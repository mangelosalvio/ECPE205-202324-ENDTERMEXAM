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

    public MainFrame() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());

        addPnl(studentsPanel = new StudentsPanel(), 0, 0, 1, 1);
        addPnl(coursePanel = new CoursePanel(), 1, 0, 1, 1);
        addB(enrollButton = new JButton("ENROLL"), 0, 1, 1, 1);
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                enroll();
            }
        });
        addB(scrollPane = new JScrollPane(enrolleesTable = new JTable(enrolledTableModel = new EnrolledTableModel())), 0, 2, 2, 1);
        scrollPane.setPreferredSize(new Dimension(926, 230));

        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void addPnl(Component component, int x, int y, int w, int h) {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 5, 5, 5);

        add(component, c);
    }

    public void addB(Component component, int x, int y, int w, int h) {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 10);

        add(component, c);
    }

    public void enroll() {
        int studentValue = studentsPanel.studentsTable.getSelectedRow();
        int courseValue = coursePanel.courseTable.getSelectedRow();

        if (studentValue == -1 || courseValue == -1) {
            JOptionPane.showMessageDialog(MainFrame.this, "Choose from both tables");
            return;
        }

        Student student = studentsPanel.studentsTableModel.list.get(studentValue);
        Course course = coursePanel.courseTableModel.list.get(courseValue);

        if (ifEnrolled(student, course)) {
            JOptionPane.showMessageDialog(MainFrame.this, "Student already registered");
            return;
        }

        EnrolledCourse enrolledCourse = new EnrolledCourse(course);
        enrolledTableModel.enrolledCourses.add(enrolledCourse);
        enrolledCourse.addStudent(student);
        enrolleesTable.updateUI();
    }

    public boolean ifEnrolled(Student student, Course course) {
        for (EnrolledCourse enrolledCourse : enrolledTableModel.enrolledCourses) {
            if (enrolledCourse.getCourse().equals(course) && enrolledCourse.getStudents().contains(student)) {
                return true;
            }
        }
        return false;
    }
}