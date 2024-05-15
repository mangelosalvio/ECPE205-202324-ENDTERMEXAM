import javax.swing.*;
import java.awt.*;

public class CoursePanel extends JPanel {

    public JLabel courseNameLabel, courseCodeLabel;
    public JTextField courseNameField, courseCodeField;
    public JTable courseTable;
    public CourseTableModel courseTableModel;


    public JButton courseAdd;


    public CoursePanel() {
        init();
    }
    private void init(){
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);
        courseNameLabel = new JLabel("Course Name: ");
        courseCodeLabel = new JLabel("Course Code: ");
        courseNameField = new JTextField(10);
        courseCodeField = new JTextField(10);
        courseAdd = new JButton("ADD");
        this.setLayout(new GridBagLayout());


        courseTable = new JTable(courseTableModel);
        add(courseNameLabel,0,0,1,1,1,1);
        add(courseNameField,1,0,2,1,1,1);
        add(courseCodeLabel,0,1,1,1,1,1);
        add(courseCodeField,1,1,2,1,1,1);
        courseAdd.setHorizontalAlignment(SwingConstants.LEFT);
        add(courseAdd,1,2,1,1,1,1, 0);
        add(new JScrollPane(courseTable),0,3,3,1,1,1);




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
        //c.insets = new Insets(5,5,5,5);
        this.add(component,c);

    }

}