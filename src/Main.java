import javax.swing.*;
import java.awt.*;

public class Main {

   public static void main(String[] args) {

       StudentsPanel sp = new StudentsPanel();
       CoursePanel cp = new CoursePanel();


       JFrame frame = new JFrame();
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


       Container container = frame.getContentPane();


       container.setLayout(new BorderLayout());


       container.add(sp, BorderLayout.WEST);
       container.add(cp, BorderLayout.EAST);

       frame.pack();
       frame.setVisible(true);
   }
}


