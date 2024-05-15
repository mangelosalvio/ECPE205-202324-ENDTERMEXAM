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

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        enrolledTableModel = new EnrolledTableModel();
        enrolleesTable = new JTable(enrolledTableModel);

        container.add(new JScrollPane(enrolleesTable),BorderLayout.SOUTH);

        JPanel enrollButtonPanel;
        container.add(enrollButtonPanel = new JPanel(), BorderLayout.WEST);
        enrollButtonPanel.add(enrollButton = new JButton("ENROLL"));


        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });


        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void addComponent(Component component, int gridx, int gridy, int width, int height, int weightX, int weightY, int fill, int anchor) {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = width;
        c.gridheight = height;
        c.weightx = weightX;
        c.weighty = weightY;
        c.fill = fill;
        c.anchor = anchor;
        c.insets = new Insets(3, 5, 3, 5);
        this.add(component, c);
    }
}
