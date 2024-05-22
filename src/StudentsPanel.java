import javax.swing.*;

public class StudentsPanel extends JPanel {

    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;
    public StudentsPanel() {
        init();
    }

    private void init(){
        studentsTableModel  = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);
    }
}
