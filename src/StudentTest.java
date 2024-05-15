import javax.swing.*;
import java.awt.*;

public class StudentTest extends JFrame {
    StudentsPanel studentsPanel = new StudentsPanel();

    public StudentTest () {
        init();
    }

    private void init() {
        this.getContentPane().add(studentsPanel, BorderLayout.NORTH);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StudentTest();
    }
}
