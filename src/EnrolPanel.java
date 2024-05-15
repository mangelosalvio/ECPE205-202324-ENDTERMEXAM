import javax.swing.*;
import java.awt.*;

public class EnrolPanel extends JPanel {
    JTable table;

    JScrollPane scrollPane;

    EnrolledTableModel enrolledTableModel;

    JButton enrollButton;


    public EnrolPanel(){
        init();
    }

    private void init(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        enrolledTableModel = new EnrolledTableModel ();
        table = new JTable();

        add(0,0,1,1,c);
        this.add(enrollButton = new JButton("Enroll"),c);
        add(0,1,2,1,c);
        this.add(table = new JTable(enrolledTableModel),c);
        scrollPane = new JScrollPane(table);
        this.add(scrollPane, c);
    }

    private static void add(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c)
    {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
    }
}
