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

        add(0,0,1,1,c);
        this.add(studentIDLabel = new JLabel("Student ID: "),c);

        add(1,0,3,1,c);
        this.add(studentIDField = new JTextField(15),c);

        add(0,1,1,1,c);
        this.add(nameLabel = new JLabel("Name: "),c);

        add(1,1,3,1,c);
        this.add(nameField = new JTextField(15),c);

        add(1,2,1,1,c);
        this.add(studentAddBtn = new JButton("Add"),c);

        add1(0,3,4,1,c);
        this.add(new JScrollPane(studentsTable),c);

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

    private static void add(int gridx, int gridy, GridBagConstraints c)
    {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
    }
    private static void add(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c)
    {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
    }

    private static void add1(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c)
    {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.fill = GridBagConstraints.SOUTH;
        c.insets = new Insets(5,5,5,5);
    }
}
