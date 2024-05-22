import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {
    JLabel studentIDLabel, nameLabel;
    JTextField studentIDField, nameField;
    JTable studentsTable;
    JScrollPane scrollPane;
    JButton addButton;
    DefaultTableModel defaultTableModel;

    public StudentsPanel() {
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        String[] name = {"ID", "Name"};
        defaultTableModel = new DefaultTableModel(name, 0);

        addComponent(0, 0, 1, 1, c);
        this.add(studentIDLabel = new JLabel("Student ID:"), c);

        addComponent(1, 0, 1, 1, c);
        this.add(studentIDField = new JTextField(20), c);

        addComponent(0, 1, 1, 1, c);
        this.add(nameLabel = new JLabel("Name:"), c);

        addComponent(1, 1, 1, 1, c);
        this.add(nameField = new JTextField(20), c);

        addComponent(1, 2, 1, 1, c);
        this.add(addButton = new JButton("ADD"), c);

        addComponent(0, 3, 2, 1, c);
        c.weighty = 5;
        this.add(scrollPane = new JScrollPane(studentsTable = new JTable(defaultTableModel)), c);



        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studentIDField.getText();
                String name = nameField.getText();
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill in all fields", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    defaultTableModel.addRow(new Object[]{id, name});
                    studentIDField.setText("");
                    nameField.setText("");
                }
            }
        });
    }

    private static void addComponent(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c) {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
    }
}
