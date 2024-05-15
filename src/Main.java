import javax.swing.*;
import java.awt.*;
public class Main extends JFrame {
    public Main() { init(); }
    public void init() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        Container container = this.getContentPane();
        StudentsPanel namepanel = new StudentsPanel();

        container.setLayout(new BorderLayout());
        container.add(namepanel, BorderLayout.NORTH);
        container.add(panel, BorderLayout.SOUTH);

        this.setVisible(true);
        this.pack();
        this.setTitle("Joaquin ContactEditorUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Main();
    }
}