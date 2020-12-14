import javax.swing.*;
import java.awt.*;

public class AddiererGUI extends JFrame {

    // Instanzvariable
    private JPanel jPanel;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JLabel lbPlus;
    private JLabel lbResult;
    private JButton btCalculateResult;

    // Konstruktor
    public AddiererGUI(){
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5, 1));
        tfNumber1 = new JTextField();
        tfNumber2 = new JTextField();
        lbPlus = new JLabel("+");
        lbResult = new JLabel();
        btCalculateResult = new JButton("=");

        jPanel.add(tfNumber1);
        jPanel.add(lbPlus);
        jPanel.add(tfNumber2);
        jPanel.add(btCalculateResult);
        jPanel.add(lbResult);

        this.getContentPane().add(jPanel);

        pack();
    }

}
