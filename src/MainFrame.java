import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    StudentsPanel studentsPanel;
    CoursePanel coursePanel;

    EnrolPanel enrolPanel;

    public MainFrame() {
        init();
    }

    private void init() {
        this.getContentPane().add(studentsPanel, BorderLayout.WEST);
        this.getContentPane().add(coursePanel, BorderLayout.EAST);
        this.getContentPane().add(enrolPanel, BorderLayout.SOUTH);


        setVisible(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private static void add(int gridx, int gridy, GridBagConstraints c)
    {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
    }
}
