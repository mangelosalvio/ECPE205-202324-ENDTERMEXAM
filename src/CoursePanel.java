import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {
    JLabel courseLabel, codeLabel;
    JTextField courseField, codeField;
    JButton addButton;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;

    public CoursePanel() {
        init();
    }

    private void init() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        String[] nameColumn2 = {"Code", "Name"};
        tableModel = new DefaultTableModel(nameColumn2, 0);

        addComponent(0, 0, 1, 1, c);
        this.add(courseLabel = new JLabel("Course Name:"), c);

        addComponent(1, 0, 1, 1, c);
        this.add(courseField = new JTextField(10), c);

        addComponent(0, 1, 1, 1, c);
        this.add(codeLabel = new JLabel("Course Code:"), c);

        addComponent(1, 1, 1, 1, c);
        this.add(codeField = new JTextField(10), c);

        addComponent(1, 2, 1, 1, c);
        this.add(addButton = new JButton("ADD"), c);

        addComponent(0, 3, 2, 1, c);
        c.weighty = 5;
        this.add(scrollPane = new JScrollPane(table = new JTable(tableModel)), c);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseField.getText();
                String courseCode = codeField.getText();
                if (courseName.isEmpty() || courseCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill in all fields", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    tableModel.addRow(new Object[]{courseCode, courseName});
                    courseField.setText("");
                    codeField.setText("");
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
