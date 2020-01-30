/**
 * Authors: Zachary Zampa & Caleb Martin
 * Since: 2020/01/30
 *
 * Description: This is the GUI Driver
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgramDriver extends Component {
    private JTextField textField1;
    private JButton searchButton;
    private JButton chooseFileButton;
    private JPanel ProgramDriver;
    private JTextArea textArea1;
    private JFileChooser fc;
    public String personName;
    public String fileName = "";

    public ProgramDriver() {
        chooseFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(ProgramDriver.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                  fileName = fc.getSelectedFile().toString();
                  searchButton.setEnabled(true);
                }
            }
        });
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personName = textField1.getText();
                String response = MostPopularName.itWasClicked(personName, fileName);
                textArea1.setText(response);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProgramDriver");
        frame.setContentPane(new ProgramDriver().ProgramDriver);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

