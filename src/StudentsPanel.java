import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {

    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;

    public StudentsPanel() {
        init();
    }

    public JButton addButton;

    private void init() {
        this.setLayout(new GridBagLayout());
        studentIDLabel = new JLabel("Student ID:");
        nameLabel = new JLabel("Name:");
        studentIDField = new JTextField(10);
        nameField = new JTextField(10);
        addButton = new JButton("Add");
        studentsTableModel = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);
        this.add(studentIDLabel, 0, 0);
        this.add(studentIDField, 1, 0);
        this.add(nameLabel, 0, 1);
        this.add(nameField, 1, 1);
        this.add(addButton, 1, 2);
        this.add(new JScrollPane(studentsTable), 0, 3, 2);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studentIDField.getText();
                String name = nameField.getText();
                if (!id.isEmpty() && !name.isEmpty()) {
                    Student student = new Student(id, name);
                    studentsTableModel.addStudent(student);
                    studentsTableModel.fireTableDataChanged();
                    studentIDField.setText("");
                    nameField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Incomplete data in fields");
                }
            }
        });
    }

    private void add(Component component, int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        this.add(component, c);
    }

    private void add(Component component, int x, int y, int gridwidth) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridwidth;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

        this.add(component, c);
    }
}
