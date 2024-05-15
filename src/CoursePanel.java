import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePanel extends JPanel {

    public JLabel courseNameLabel, courseCodeLabel;
    public JTextField courseNameField, courseCodeField;
    public JPanel CoursePanelMain;
//this is an update
    public JPanel TableMain;
    public JTable courseTable;
    public CourseTableModel courseTableModel;
public JButton AddCourseButton;

    public CoursePanel() {
        init();
    }
    private void init(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        courseNameLabel = new JLabel("Course Name: ");
        courseCodeLabel = new JLabel("Course Code: ");
        courseNameField = new JTextField(20);
        courseCodeField = new JTextField(20);
        AddCourseButton = new JButton("Add");

     CoursePanelMain= new JPanel();
     CoursePanelMain.setLayout(new GridBagLayout());
     GridBagConstraints n = new GridBagConstraints();
     n.gridx=0;
     n.gridy=0;
     CoursePanelMain.add(courseNameLabel,n);
        n.gridx=1;
        n.gridy=0;
        CoursePanelMain.add(courseNameField,n);
        n.gridx=0;
        n.gridy=1;
        CoursePanelMain.add(courseCodeLabel,n);
        n.gridx=1;
        n.gridy=1;
        CoursePanelMain.add(courseCodeField,n);
        n.gridx=0;
        n.gridy=2;
        CoursePanelMain.add(AddCourseButton,n);


      c.gridx=0;
      c.gridy=0;
       this.add(CoursePanelMain,c);

        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);

       TableMain = new JPanel();
       TableMain.setLayout(new BorderLayout());
       TableMain.add(new JScrollPane(courseTable));
       TableMain.setPreferredSize(new Dimension(300,300));

        c.gridx=0;
        c.gridy=3;
       this.add(TableMain,c);


       AddCourseButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String CourseName = courseNameField.getText();
               String CourseCode = courseCodeField.getText();
               if(!CourseName.isEmpty() && !CourseCode.isEmpty()){
                   Course course = new Course(CourseName, CourseCode);
                   courseTableModel.addCourse(course);
                   courseTableModel.fireTableDataChanged();
                   courseCodeField.setText("");
                   courseNameField.setText("");
               }
               else {
                   JOptionPane.showMessageDialog(null, "Nothing to add", null, JOptionPane.ERROR_MESSAGE);

               }

           }
       });
    }
}