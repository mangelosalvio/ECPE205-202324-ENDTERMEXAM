import javax.swing.*;

public class TestFrames {
    public static void main(String[] args) {

        /**
         * FOR TESTING PURPOSES
         */

        StudentsPanel studentsPanel;


        //display whole frame
        new MainFrame();

        //display only studnets frame
        JFrame studentsFrame = new JFrame();
        studentsFrame.add(new StudentsPanel());
        studentsFrame.pack();
        studentsFrame.setVisible(true);


        //display course frame
        JFrame courseFrame = new JFrame();
        courseFrame.add(new CoursePanel());
        courseFrame.pack();
        courseFrame.setVisible(true);
    }
}
