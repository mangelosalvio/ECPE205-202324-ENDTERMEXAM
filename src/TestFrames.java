import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrames extends JPanel {


    JButton enrollButton;

    JButton addButton;
    JTable table;
    JScrollPane scrollPane;
    DefaultTableModel tableModel;


    public TestFrames() {
        init();
    }

    private void init() {

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        String[] nameColumn2 = {"Code", "Name", "Enrollees"};
        tableModel = new DefaultTableModel(nameColumn2, 0);

        adds(0, 0, 1, 1, c);
        this.add(enrollButton = new JButton("ENROLL"), c);
        tableModel = new DefaultTableModel(nameColumn2, 0);

        adds(0, 0, 1, 1, c);
        this.add(addButton = new JButton("Add"), c);

        add(0, 2, 2, 1, c);
        this.add(table = new JTable(tableModel), c);

        c.weighty = 10;
        scrollPane = new JScrollPane(table);
        this.add(scrollPane, c);

    }

    private static void add(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c) {

        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = 1;
        c.weighty = 1;
        c.weighty = 10;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);

    }

    private static void adds(int gridx, int gridy, int gridWidth, int gridHeight, GridBagConstraints c) {

        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = gridWidth;
        c.gridheight = gridHeight;
        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(5, 5, 5, 5);
    }

}