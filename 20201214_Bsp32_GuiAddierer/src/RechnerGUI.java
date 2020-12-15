import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RechnerGUI extends JFrame {

    // Instanzvariable
    private JPanel jPanel;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JLabel lbPlus;
    private JLabel lbResult;
    private JButton btCalculateResult;

    private JPanel jpRechenOperationen;
    private JRadioButton rbPlus;
    private JRadioButton rbMinus;
    private JRadioButton rbMulti;

    // Konstruktor
    public RechnerGUI(){
        // Beendet das Programm wenn "x" geklickt wurde
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titel des Fensters
        setTitle("Addierer");

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5, 1));
        tfNumber1 = new JTextField();
        tfNumber2 = new JTextField();

        jpRechenOperationen = new JPanel();
        jpRechenOperationen.setLayout(new GridLayout(1, 3));

        rbPlus = new JRadioButton("+");
        rbMinus = new JRadioButton("-");
        rbMulti = new JRadioButton("*");
        jpRechenOperationen.add(rbPlus);
        jpRechenOperationen.add(rbMinus);
        jpRechenOperationen.add(rbMulti);


        lbPlus = new JLabel("+");
        lbResult = new JLabel();
        btCalculateResult = new JButton("=");
        btCalculateResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number1 = tfNumber1.getText();
                float n1 = Float.parseFloat(number1);
                String number2 = tfNumber2.getText();
                float n2 = Float.parseFloat(number2);
                float result = n1 + n2;
                // Schreibt das Ergebnis auf lbResult
                // mit der setText(String text) Methode!
                lbResult.setText(String.valueOf(result));
            }
        });

        jPanel.add(tfNumber1);
        //jPanel.add(lbPlus);
        jPanel.add(jpRechenOperationen);
        jPanel.add(tfNumber2);
        jPanel.add(btCalculateResult);
        jPanel.add(lbResult);

        this.getContentPane().add(jPanel);

        pack();
    }

}
