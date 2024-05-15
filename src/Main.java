import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    public Main() { init(); }

    public void init() {

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));



        Container container = this.getContentPane();
        CoursePanel CoursePanel = new CoursePanel();



        container.setLayout(new BorderLayout());
        container.add(CoursePanel, BorderLayout.NORTH);
        container.add(panel, BorderLayout.SOUTH);

        this.setVisible(true);
        this.pack();
        this.setTitle("HINAYAN");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
}
