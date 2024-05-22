import javax.swing.*;

public class Main {
    public static void main(String[] args) {

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