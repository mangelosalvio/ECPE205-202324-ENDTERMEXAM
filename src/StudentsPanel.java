import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentsPanel extends JPanel {
    public JLabel studentIDLabel, nameLabel;
    public JTextField studentIDField, nameField;
    public JTable studentsTable;
    public StudentsTableModel studentsTableModel;
    public JButton addButton;
    public JTable table;
    public JScrollPane scrollPane;

    public StudentsPanel() {
        init();
    }

    private void init(){
        studentsTableModel  = new StudentsTableModel();
        studentsTable = new JTable(studentsTableModel);

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        TitledBorder titledBorder = new TitledBorder(BorderFactory
                .createLineBorder(new Color(155,211,221)), "Student");
        this.setBorder(titledBorder);

        add(0,0,c);
        this.add(studentIDLabel = new JLabel("Student ID:"), c);

        add(1, 0,c);
        this.add(studentIDField = new JTextField(29),c);
        border(studentIDField);

        add(0,1,c);
        this.add(nameLabel = new JLabel("Name:"),c);

        add(1,1,c);
        this.add(nameField = new JTextField(29),c);
        border(nameField);

        add(1,2,1,1,c);
        this.add(addButton = new JButton("Add"),c);

        add(0,3,2,1,c);
        this.add(table = new JTable(studentsTableModel),c);
        scrollPane = new JScrollPane(table);

        this.add(scrollPane,c);
        add(0,4,1,1,c);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = studentIDField.getText();
                String name = nameField.getText();
                String [] container ={id, name};

                if(id.isEmpty() || name.isEmpty()){
                    JOptionPane.showMessageDialog(null,
                            "Fill in all fields","ERROR",JOptionPane.ERROR_MESSAGE);

                }else{
                    studentsTableModel.getRowCount();
                    studentIDField.setText("");
                    nameField.setText("");

                }
            }
        });


    }
    private static void add(int gridx, int gridy, GridBagConstraints c)
    {
        c.gridx = gridx;
        c.gridy = gridy;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
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
    private void border(JTextField textField)
    {
        textField.setBorder(BorderFactory.createLineBorder(new Color(155,211,221)));
    }
}

