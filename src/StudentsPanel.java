import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {

    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;
    JButton studentAdd;
    public StudentsPanel() {
        init();
    }

    private void init(){
        studentsTableModel  = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);
        studentIDLabel = new JLabel("Course Name: ");
        nameLabel = new JLabel("Course Code: ");
        studentIDField = new JTextField(10);
        nameField = new JTextField(10);
        studentAdd = new JButton("ADD");
        this.setLayout(new GridBagLayout());
        studentAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String courseName = studentIDField.getText();
                String courseCode = nameField.getText();

                Student student1 = new Student(courseCode,courseName);

                if(! courseName.isEmpty() && !courseCode.isEmpty()){
                    studentIDField.setText("");
                    nameField.setText("");

                    studentsTableModel.list.add(student1);
                    studentsTable.updateUI();

                }
                else {
                    JOptionPane.showMessageDialog(StudentsPanel.this, "Please fill in the blanks. ");
                }

            }

        });

        studentsTable = new JTable(studentsTableModel);
        add(studentIDLabel,0,0,1,1,1,1);
        add(nameField,1,0,2,1,1,1);
        add(studentIDLabel,0,1,1,1,1,1);
        add(studentIDField,1,1,2,1,1,1);
        studentAdd.setHorizontalAlignment(SwingConstants.LEFT);
        add(studentAdd,1,2,1,1,1,1, 0);
        add(new JScrollPane(studentsTable),0,3,3,1,1,1);




    }
    public void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, int weightX, int weightY){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridX;
        c.gridy = gridY;
        c.gridwidth =gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;

        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        this.add(component,c);

    }
    public void add(Component component, int gridX, int gridY, int gridWidth, int gridHeight, int weightX, int weightY, int x){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridX;
        c.gridy = gridY;
        c.gridwidth =gridWidth;
        c.gridheight = gridHeight;
        c.weightx = weightX;
        c.weighty = weightY;

        c.fill = GridBagConstraints.NONE;
        this.add(component,c);
//message from harold
    }

}
