import javax.swing.*;
import java.awt.*;

public class coursetest extends JFrame {
        CoursePanel coursepanel = new CoursePanel();

    public coursetest()
    {
        init();
    }
    private void init(){

        this.getContentPane().add(coursepanel, BorderLayout.NORTH);

        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new coursetest();
    }
}
