import javax.swing.*;

public class TestFrames {
    public static void main(String[] args) {

        /**
         * FOR TESTING PURPOSES
         */

        //display whole frame


        //display only studnets frame



        //display course frame
        JFrame courseFrame = new JFrame();
        courseFrame.add(new CoursePanel());
        courseFrame.pack();
        courseFrame.setVisible(true);
    }
}