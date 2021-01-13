import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddiererGUI extends JFrame {

    // Instanzvariable
    private JPanel jPanel;
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JLabel lbPlus;

    private JPanel jpRechenarten;
    private JRadioButton rbPlus;
    private JRadioButton rbMinus;

    private JLabel lbResult;
    private JButton btCalculateResult;

    // Konstruktor
    public AddiererGUI(){
        // Beendet das Programm wenn "x" geklickt wurde
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Titel des Fensters
        setTitle("Addierer");

        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(5, 1));
        tfNumber1 = new JTextField();
        tfNumber2 = new JTextField();

        // JPanel zeigt die Rechenarten an
        jpRechenarten = new JPanel();
        jpRechenarten.setLayout(new GridLayout(1, 2));
        rbPlus = new JRadioButton("+");
        rbMinus = new JRadioButton("-");
        // fügt Radiobuttons in jpRechenarten ein
        jpRechenarten.add(rbPlus);
        jpRechenarten.add(rbMinus);

        //lbPlus = new JLabel("+");

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
        jPanel.add(jpRechenarten);
        jPanel.add(tfNumber2);
        jPanel.add(btCalculateResult);
        jPanel.add(lbResult);

        this.getContentPane().add(jPanel);

        pack();
    }

}