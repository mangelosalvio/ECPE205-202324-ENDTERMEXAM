import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class CoursePanel extends JPanel {

    JLabel courseNameLabel, courseCodeLabel;
    JTextField courseNameField, courseCodeField;
    JTable courseTable;
    JTable table;
    JScrollPane scrollPane;
    //DefaultTableModel tableModel;
    JButton Addbutton;
    CourseTableModel courseTableModel;



    public CoursePanel() {
        init();
    }

    private void init() {
        courseTableModel = new CourseTableModel();
        courseTable = new JTable(courseTableModel);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        TitledBorder titledBorder = new TitledBorder(BorderFactory
                .createLineBorder(new Color(155, 211, 221)), "Course");
        this.setBorder(titledBorder);


        add(0, 0, c);
        this.add(courseNameLabel = new JLabel("Course Name: "), c);
        add(1, 0, c);
        this.add(courseNameField = new JTextField(29), c);
        border(courseNameField);
        add(0, 1, c);
        this.add(courseCodeLabel = new JLabel("Course Code: "), c);
        add(1, 1, c);
        this.add(courseCodeField = new JTextField(29), c);
        add(1, 2,1,1, c);
        this.add(Addbutton = new JButton("Add"));
        add(0, 3,2,1, c);
        this.add(table = new JTable(courseTableModel), c);
        scrollPane = new JScrollPane(table);
        this.add(scrollPane, c);
        add(0, 4, 1, 1, c);

        Addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = courseNameField.getText();
                String code = courseCodeField.getText();
                String[] container = {name, code};

                if (name.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill in all fields", "ERROR", JOptionPane.ERROR_MESSAGE);

                } else {
                    courseTableModel.getRowCount();
                    courseNameField.setText("");
                    courseCodeField.setText("");


                }
            }
        });


    }
    private static void add(int gridx, int gridy, GridBagConstraints c)
    {
        c.gridx = gridx;
        c.gridy = gridy;
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
    private void border(JTextField textField)
    {
        textField.setBorder(BorderFactory.createLineBorder(new Color(155,211,221)));
    }
}
