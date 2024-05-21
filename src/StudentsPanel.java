import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {

    JLabel studentIDLabel, nameLabel;
    JTextField studentIDField, nameField;
    JTable studentsTable;
    StudentsTableModel studentsTableModel;
    JButton button;
    JScrollPane scrollPane;

    public StudentsPanel() {
        init();
    }

    private void init() {
        setLayout(new GridBagLayout());

        studentsTableModel = new StudentsTableModel();

        nameLabel = new JLabel("NAME: ");
        nameField = new JTextField(20);
        studentIDLabel = new JLabel("STUDENT ID: ");
        studentIDField = new JTextField(20);
        button = new JButton("ADD");

        scrollPane = new JScrollPane(studentsTable = new JTable(studentsTableModel));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String id = studentIDField.getText();

                Student student1 = new Student(id, name);
                studentsTableModel.list.add(student1);
                studentsTable.updateUI();

                nameField.setText("");
                studentIDField.setText("");
            }
        });

        add(studentIDLabel, 0, 0, 1, 1);
        add(studentIDField, 1, 0, 1, 1);
        add(nameLabel, 0, 1, 1, 1);
        add(nameField, 1, 1, 1, 1);
        add(button, 1, 2, 1, 1);

        add(scrollPane, 0, 3, 2, 3);
    }

    public void add(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints x = new GridBagConstraints();
        x.gridx = gridx;
        x.gridy = gridy;
        x.gridwidth = gridwidth;
        x.gridheight = gridheight;
        //x.fill = GridBagConstraints.HORIZONTAL;
        x.anchor = GridBagConstraints.WEST;
        x.insets = new Insets(5, 5, 5, 5);
        add(component, x);
    }
}
