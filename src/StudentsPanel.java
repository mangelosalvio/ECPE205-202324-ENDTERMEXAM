import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {

    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;
    public JButton studentAddBtn;
    public StudentsPanel() {
        init();
    }

    private void init(){
        studentsTableModel  = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        addComponent(studentIDLabel = new JLabel("Student ID:"),0,0,1,1,0,0,GridBagConstraints.NONE,GridBagConstraints.LINE_END);
        addComponent(studentIDField = new JTextField(40),1,0,1,1,1,0,GridBagConstraints.HORIZONTAL);

        addComponent(nameLabel = new JLabel("Name:"),0,1,1,1,0,0,GridBagConstraints.BOTH);
        addComponent(nameField = new JTextField(40),1,1,1,1,1,0,GridBagConstraints.HORIZONTAL);

        addComponent(studentAddBtn = new JButton("Add"),1,2,2,1,0,0,GridBagConstraints.NONE, GridBagConstraints.LINE_START);

        addComponent(new JScrollPane(studentsTable), 0,3,2,1,1,1,GridBagConstraints.BOTH, GridBagConstraints.CENTER);

        studentAddBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studentIDField.getText().trim();
                String name = nameField.getText().trim();

                Student student = new Student(id, name);

                if (!id.isEmpty() && !name.isEmpty()) {
                    studentsTableModel.addStudent(student);
                    studentsTable.updateUI();
                    studentIDField.setText("");
                    nameField.setText("");
                } else{
                    JOptionPane.showMessageDialog(null, "ERROR: THERE IS AN EMPTY FIELD", "ERROR", JOptionPane.ERROR_MESSAGE );
                }
            }
        });

    }

    private void addComponent(Component component, int x, int y, int width, int height,
                              int weightX, int weightY, int fill){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.insets = new Insets(3,5,3,5);
        add(component, c);
    }

    private void addComponent(Component component, int x, int y, int width, int height,
                              int weightX, int weightY, int fill, int anchor){

        GridBagConstraints c = new GridBagConstraints();

        c.gridx = x;
        c.gridy = y;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = new Insets(3,5,3,5);
        add(component, c);
    }
}
