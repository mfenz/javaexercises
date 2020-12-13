import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddiererGUI extends JFrame {

    // Dort wird die erste Zahl eingegeben
    JTextField tfNumber1;
    // Dort wird die zweite Zahl eingegeben
    JTextField tfNumber2;
    // Hier wird das Ergebnis der Addition ausgegeben
    JLabel lbResult;

    /**
     * Konstruktor
     */
    public AddiererGUI() {
        // Fenster-Titel setzen
        setTitle("Addierer");
        // Was passieren soll wenn "x" beim Fenster gedrückt wird.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // jPanel initialisieren. Das jPanel hält unsere GUI Elemente
        // wie (Buttons, Textfelder etc...)
        JPanel jPanel = new JPanel();
        // Die GUI-Elemente im JPanel werden als "Grid" angeordnet.
        // 5 Zeilen und eine Spalte.
        jPanel.setLayout(new GridLayout(5, 1));

        tfNumber1 = new JTextField();
        tfNumber2 = new JTextField();
        // Optische Hilfe - Pluszeichen zwischen tfNumber1 und tfNumber2
        JLabel lbPlus = new JLabel("+");
        // Beim Klick auf diesen Button wird das Ergebnis berechnet
        JButton btCalculate = new JButton("=");
        btCalculate.addActionListener(btCalculatePressed());
        // JLabel wo das Additions-Ergebis stehen soll initialieren
        lbResult = new JLabel();

        // Textfelder, Labels, und Buttons in das JPanel einfügen.
        // Diese werden darin durch das vorher gesetzte GridLayout organisiert
        jPanel.add(tfNumber1);
        jPanel.add(lbPlus);
        jPanel.add(tfNumber2);
        jPanel.add(btCalculate);
        jPanel.add(lbResult);

        // Das Panel zum aktiven, sichtbaren Inhalt des JFrame machen:
        this.getContentPane().add (jPanel) ;
        // Alle Elemente auf kleinstmögliche Größe bringen
        pack();
    }

    /**
     * Dieser ActionListener wird aufgerufen wenn der = Button geklickt wurde
     * siehe btCalculate.addActionListener(btCalculatePressed());
     * @return ActionListener for button calculate pressed event
     */
    private ActionListener btCalculatePressed(){
        // erstellt einen neuen ActionListener und gibt ihn zurück
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Zahl vom ersten Textfeld (als String) holen
                // (mit der getText Methode)
                String zahl1String = tfNumber1.getText();
                // erste Zahl in float umwandeln
                float zahl1 = Float.parseFloat(zahl1String);
                // Zahl vom zweiten Textfeld (als String) holen
                String zahl2String = tfNumber2.getText();
                // zweite Zahl in float umwandeln
                float zahl2 = Float.parseFloat(zahl2String);

                // die beiden Zahlen addieren
                float ergebnis = zahl1 + zahl2;

                // Das Ergebnis ins passende JLabel schreiben
                // (mit der .setText Methode)
                lbResult.setText(String.valueOf(ergebnis));
            }
        };
    }
}
