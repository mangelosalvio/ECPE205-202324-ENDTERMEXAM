import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CoursePanel extends JPanel {
    JTable courseTable;
    JScrollPane courseScrollPane;
    JLabel cnameLabel, courseLabel;
    JButton addCourse;
    JTextField coursenameTextField, coursecodeTextField;
    CourseTableModel courseTableModel;
    Course course;
    public CoursePanel(){
        init ();

    }
    public void init(){
        GridBagConstraints c = new GridBagConstraints();
        setLayout(new GridBagLayout());

        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);

        cnameLabel = new JLabel("Course Name: ");
        courseLabel = new JLabel("Course Code: ");

        coursenameTextField = new JTextField(20);
        coursecodeTextField = new JTextField(20);

        addCourse = new JButton("Add");

        add(cnameLabel, 0, 0, c);
        add(courseLabel, 0, 1, c);
        add(coursenameTextField, 1, 0, c);
        add(coursecodeTextField, 1, 1, c);
        add(addCourse,1, 2, c);
        add(courseScrollPane = new JScrollPane(courseTable),0,3,3,1,c);




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
