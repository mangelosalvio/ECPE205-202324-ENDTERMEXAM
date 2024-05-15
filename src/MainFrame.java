import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    StudentsPanel studentsPanel;
    CoursePanel coursePanel;
    JTable enrolleesTable;
    EnrolledTableModel enrolledTableModel;
    JButton enrollButton;

    public MainFrame() {
        init();
    }

    private void init() {
        studentsPanel = new StudentsPanel();
        coursePanel = new CoursePanel();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(studentsPanel,c);

        c.gridx = 1;
        c.gridy = 0;
        c.weighty = 1;
        c.weightx = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(coursePanel,c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(enrollButton,c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        this.add(new JScrollPane(enrolleesTable),c);

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Student> enrolleeStudents = new ArrayList<>();
                Student s = studentsPanel.studentsTableModel.getStudent(studentsPanel.studentsTable.getSelectedRow());
                enrolleeStudents.add(s);
                Course c = coursePanel.courseTableModel.getCourse(coursePanel.courseTable.getSelectedRow());
                EnrolledCourse enrolleetofind = new EnrolledCourse(c);
                enrolleetofind.addStudent(s);
                boolean courseExist = false;

                for(int i=0; i <enrolledTableModel.getRowCount();i++){
                    EnrolledCourse enrollee = enrolledTableModel.getEnrollee(i);
                    if(c.getCourseCode().equals(enrollee.getCourse().courseCode)){
                        enrolleetofind = enrollee;
                        courseExist = true;
                        break;
                    }
                }

                if(courseExist){
                    boolean studentExists = false;
                    for(int i =0; i< enrolleetofind.getStudents().size(); i++){
                        Student existingStudent = enrolleetofind.getStudents().get(i);
                        if(s.equals(existingStudent)){
                            studentExists = true;
                            break;
                        }
                    }

                    if(studentExists){
                        JOptionPane.showMessageDialog(null, "Student already enrolled in course");
                    }
                    else{
                        enrolleetofind.addStudent(s);
                        enrolledTableModel.fireTableDataChanged();
                    }
                }
                else{
                    enrolledTableModel.addEnrollee(enrolleetofind);
                    enrolledTableModel.fireTableDataChanged();
                }
            }
        });

        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}