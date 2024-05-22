import javax.swing.*;

public class Main extends JFrame {

    public Main() {
        init();
    }

    public void init() {
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}