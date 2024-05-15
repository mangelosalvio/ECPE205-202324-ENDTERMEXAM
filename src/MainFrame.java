import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    StudentsPanel studentsPanel = new StudentsPanel();
    CoursePanel coursePanel = new CoursePanel();
    JTable enrolleesTable;
    EnrolledTableModel enrolledTableModel;

    JButton enrollButton;

    public MainFrame() {
        init();
    }

    private void init() {

        this.add(studentsPanel, BorderLayout.WEST);
        this.add(coursePanel, BorderLayout.EAST);
        enrolledTableModel = new EnrolledTableModel();
        enrolleesTable = new JTable(enrolledTableModel);


//        setVisible(true);
//        pack();
//        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
