import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() { init(); }

    public void init() {

        JPanel mypanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton okbtn = new JButton("OK");
        JButton cancelbtn = new JButton("Cancel");


        Container container = this.getContentPane();
        StudentsPanel studentsPanel = new StudentsPanel();
        CoursePanel coursePanel = new CoursePanel();


        mypanel.add(okbtn);
        mypanel.add(cancelbtn);
        


        container.setLayout(new BorderLayout());
        container.add(studentsPanel, BorderLayout.NORTH);
        container.add(coursePanel, BorderLayout.CENTER);
        container.add(mypanel, BorderLayout.SOUTH);


        this.setResizable(false);
        this.pack();
        this.setTitle("RDH");
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
}