import javax.swing.*;
import java.awt.*;

public class StudentsPanel extends JPanel {

    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JButton btn1;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;

    public StudentsPanel() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());

        studentsTableModel = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);


        studentIDLabel = new JLabel("Student ID:");
        studentIDField = new JTextField(20);
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        add(studentIDLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(studentIDField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(nameField, gbc);


        btn1 = new JButton("Add");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btn1, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(new JScrollPane(studentsTable), gbc);
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Students Panel");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new StudentsPanel());
//        frame.pack();
//        frame.setVisible(true);
//    }
}
