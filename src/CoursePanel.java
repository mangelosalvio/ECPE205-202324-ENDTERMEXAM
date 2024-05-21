import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {

    public JLabel courseNameLabel, courseCodeLabel;
    public JTextField courseNameField, courseCodeField;
    public JTable courseTable;
    public CourseTableModel courseTableModel;

    JButton jButton;
    Course course;


    public CoursePanel() {
        init();
    }

    private void init() {
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);
        setLayout(new GridBagLayout());

        add(courseNameLabel = new JLabel("COURSE NAME:"),0,0,1,1);
        add(courseNameField = new JTextField(20),1,0,1,1);
        add(courseCodeLabel = new JLabel("COURSE CODE:"),0,1,1,1);
        add(courseCodeField = new JTextField(20),1,1,1,1);
        add(jButton = new JButton("ADD"),1,2,1,1);
        add(new JScrollPane(courseTable = new JTable(courseTableModel)),0,3,2,1);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coursename = courseNameField.getText();
                String coursecode = courseCodeField.getText();

                Course course1 = new Course(coursecode,coursename);

                if(! coursename.isEmpty() && !coursecode.isEmpty()){
                    courseNameField.setText("");
                    courseCodeField.setText("");

                    courseTableModel.list.add(course1);
                    courseTable.updateUI();

                }
                else {
                    JOptionPane.showMessageDialog(CoursePanel.this, "Please enter all the details.");
                }

            }

        });

    }

    public void add(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridwidth;
        c.gridheight = gridheight;
        c.anchor = GridBagConstraints.WEST;
        /*c.fill = GridBagConstraints.HORIZONTAL;*/
        c.insets = new Insets(5, 5, 5, 5);

        add(component, c);
    }
}
