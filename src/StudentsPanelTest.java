import javax.swing.*;
import java.awt.*;

public class StudentsPanelTest extends JFrame {

    JTable table;
    StudentsPanel studentsPanel;
    StudentsTableModel studentsTableModel;

    public StudentsPanelTest() {
        init();
    }

    public void init(){
        setTitle("Students");
        Container container = getContentPane();
        studentsTableModel = new StudentsTableModel();
        table = new JTable(studentsTableModel);
        studentsPanel = new StudentsPanel();

        container.add(studentsPanel, BorderLayout.NORTH);
//        container.add(new JScrollPane(table), BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StudentsPanelTest();
    }
}
