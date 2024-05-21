
import javax.swing.*;
import java.awt.*;


public class StudentsPanel extends JPanel {
    JTable studentTable;
    JScrollPane studentScrollPane;
    JLabel studIDLabel, NameLabel;
    JTextField IDTextField, nTextField;
    JButton addStudent;
    Student student;
    StudentsTableModel studentsTableModel;
    public StudentsPanel(){
        init ();

    }
    public void init(){
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        studentsTableModel = new StudentsTableModel();
        studentTable = new JTable(studentsTableModel);

        studIDLabel = new JLabel("Student ID: ");
        NameLabel = new JLabel("Name: ");

        IDTextField = new JTextField(20);
        nTextField = new JTextField(20);

        addStudent = new JButton("Add");

        add(studIDLabel, 0, 0, c);
        add(NameLabel, 0, 1, c);
        add(IDTextField, 1, 0, c);
        add(nTextField, 1, 1, c);
        add(addStudent,1,2, c);
        add(studentScrollPane = new JScrollPane(studentTable),0,3,3,1,c);
    }
    private void add(JComponent component, int x, int y, GridBagConstraints c){
        c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.fill = GridBagConstraints.NONE;
        c.insets = new Insets(5,5,5,5);
        add(component, c);
    }
    private void add(JComponent component, int x, int y, int gridWidth, int gridHeight, GridBagConstraints c){
        c = new GridBagConstraints();
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5,5,5,5);
        add(component, c);
    }
}