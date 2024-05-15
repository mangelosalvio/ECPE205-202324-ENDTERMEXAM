import javax.swing.*;

public class Main extends JFrame{
    JTable enrolleesTable;
    EnrolledTableModel enrolledTableModel;
    public Main() {
        add(new JScrollPane(enrolleesTable = new JTable(enrolledTableModel = new EnrolledTableModel())));

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame();
        new Main();
    }
}