import javax.swing.*;

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





        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}