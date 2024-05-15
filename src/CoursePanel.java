import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {

    public JTable courseTable;
    public DefaultTableModel courseTableModel;

    public CoursePanel() {
        init();
    }

    public void init() {
        courseTableModel = new DefaultTableModel(new Object[]{"Course Name", "Course Code"}, 0);
        courseTable = new JTable(courseTableModel);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel courseNameLabel = new JLabel("Course Name:");
        JLabel courseCodeLabel = new JLabel("Course Code:");
        JButton addBtn = new JButton("ADD");

        JTextField courseNameField = new JTextField(15);
        JTextField courseCodeField = new JTextField(15);

        courseNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        courseCodeLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        // Add components to the panel using the custom add method
        addComponent(courseNameLabel, 0, 0, c);
        addComponent(courseNameField, 1, 0, c);
        addComponent(courseCodeLabel, 0, 1, c);
        addComponent(courseCodeField, 1, 1, c);
        addComponent(addBtn, 0, 2, c);

        // Add the JTable to the panel
        JScrollPane scrollPane = new JScrollPane(courseTable);
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.weightx = 1.0;
        c.weighty = 1.0;
        this.add(scrollPane, c);

        //add button
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = courseNameField.getText();
                String courseCode = courseCodeField.getText();
                if (!courseName.isEmpty() && !courseCode.isEmpty()) {
                    courseTableModel.addRow(new Object[]{courseName, courseCode});
                    courseNameField.setText("");
                    courseCodeField.setText("");
                } else {
                    JOptionPane.showMessageDialog(CoursePanel.this, "Both fields must be filled out", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private void addComponent(Component component, int gridx, int gridy, GridBagConstraints c) {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);
        this.add(component, c);
    }
}