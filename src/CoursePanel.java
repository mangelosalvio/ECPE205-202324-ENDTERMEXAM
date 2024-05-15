import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {

    public JLabel courseNameLabel, courseCodeLabel;
    public JTextField courseNameField, courseCodeField;
    public JTable courseTable;
    public CourseTableModel courseTableModel;
    public JButton addBtn;



    public CoursePanel() {
        init();
    }
    private void init(){
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        addComponent(courseNameLabel = new JLabel("Course Name:"),0,0,1,1,0,0,GridBagConstraints.NONE,GridBagConstraints.LINE_END);
        addComponent(courseNameField = new JTextField(40),1,0,1,1,1,0,GridBagConstraints.HORIZONTAL);

        addComponent(courseCodeLabel = new JLabel("Course Code:"),0,1,1,1,0,0,GridBagConstraints.BOTH);
        addComponent(courseCodeField = new JTextField(40),1,1,1,1,1,0,GridBagConstraints.HORIZONTAL);

        addComponent(addBtn = new JButton("Add"),1,2,2,1,0,0,GridBagConstraints.NONE, GridBagConstraints.LINE_START);

        addComponent(new JScrollPane(courseTable), 0,3,2,1,1,1,GridBagConstraints.BOTH, GridBagConstraints.CENTER);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String courseName = courseNameField.getText().trim();
                String courseCode = courseCodeField.getText().trim();


                if(!courseName.isEmpty() && !courseCode.isEmpty()){

                    Course course = new Course(courseCode, courseName);

                    courseNameField.setText("");
                    courseCodeField.setText("");
                    courseTableModel.addCourse(course);
                    courseTable.updateUI();

                }
                else{
                    JOptionPane.showMessageDialog(null, "ERROR", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                courseNameField.requestFocus();
                courseTable.clearSelection();

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
