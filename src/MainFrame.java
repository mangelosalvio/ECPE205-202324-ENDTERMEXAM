import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    StudentCoursePanel studentCoursePanel;
    JButton enrollButton;

    public MainFrame() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());

        add(studentCoursePanel = new StudentCoursePanel(), 0, 0 , 1, 1);
        add(enrollButton = new JButton("ENROLL"), 0, 1, 1, 1);
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int studentValue = studentCoursePanel.studentsPanel.studentsTable.getSelectedRow();
                String studentId = studentCoursePanel.studentsPanel.studentsTable.getValueAt(studentValue, 0).toString();
                String studentName = studentCoursePanel.studentsPanel.studentsTable.getValueAt(studentValue, 1).toString();

                int courseValue = studentCoursePanel.coursePanel.courseTable.getSelectedRow();
                String courseCode = studentCoursePanel.coursePanel.courseTable.getValueAt(courseValue, 0).toString();
                String courseName = studentCoursePanel.coursePanel.courseTable.getValueAt(courseValue, 1).toString();
            }
        });

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void add (Component component, int x, int y, int w, int h) {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(5, 5, 5, 5);

        add(component, c);
    }
}
