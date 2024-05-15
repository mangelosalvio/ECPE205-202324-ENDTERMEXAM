import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentsPanel extends JPanel {
    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;
    public JButton studentAdd;
    public StudentsPanel() {
        init();
    }

    private void init(){
        this.setLayout(new GridBagLayout());

        studentsTableModel  = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);
        studentIDLabel = new JLabel("Student ID: ");
        nameLabel = new JLabel("Name: ");
        studentIDField = new JTextField(10);
        nameField = new JTextField(10);
        studentAdd = new JButton("ADD");


        add(studentIDLabel,0,0,1,1,1,1);
        add(studentIDField,1,0,2,1,1,1);
        add(nameLabel,0,1,1,1,1,1);
        add(nameField,1,1,2,1,1,1);
        studentAdd.setHorizontalAlignment(SwingConstants.LEFT);
        add(studentAdd,1,2,1,1,1,1,0);
        add(new JScrollPane(studentsTable),0,3,3,1,1,1);





    }

    public void add(Component component,int gridX, int gridY, int gridWidth, int gridHeight, int weightX, int weightY){
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = gridX;
        c.gridy = gridY;
        c.gridheight = gridHeight;
        c.gridwidth = gridWidth;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);

        this.add(component,c);
    }
    public void add(Component component,int gridX, int gridY, int gridWidth, int gridHeight, int weightX, int weightY,int x){
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = gridX;
        c.gridy = gridY;
        c.gridheight = gridHeight;
        c.gridwidth = gridWidth;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(5,5,5,5);

        this.add(component,c);
    }
}