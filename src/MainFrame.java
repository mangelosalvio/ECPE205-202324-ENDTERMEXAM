import javax.swing.*;
import java.awt.*;

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

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
