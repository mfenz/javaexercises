import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Das ist ein einzelnes Fenster - TextRueckwaertsGUI ist ein "JFrame"
public class TextRueckwaertsGUI extends JFrame {
    // Benutzer geben den Text in diesem Textfeld ein
    private JTextField tfTextEingabe;
    // wir geben den umgedrehten Text auf diesem Label aus
    private JLabel lbErgebnis;

    public TextRueckwaertsGUI() {
        // Fenster-Titel setzen
        setTitle("Text Rückwärts");
        // Was passieren soll wenn "x" beim Fenster gedrückt wird.
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        // in dieses Panel werden wir die GUI Elemente einfügen
        // jPanel initialisieren. Das jPanel hält unsere GUI Elemente
        // wie (Buttons, Textfelder etc...)
        JPanel jPanel = new JPanel();
        // Die GUI-Elemente im JPanel werden als "Grid" angeordnet.
        jPanel.setLayout(new GridLayout(3, 1));

        tfTextEingabe = new JTextField();
        lbErgebnis = new JLabel();

        // Beim Klick auf diesen Button soll der eingegebene Text
        // rückwärts ausgegeben werden.
        JButton btAction = new JButton("Text rückwärts ausgeben");
        // addActionListener - der neue ActionListener definiert was
        // beim Klick auf den Button passieren soll.
        btAction.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // eingegebene Text holen
                String eingabe = tfTextEingabe.getText();
                // String umdrehen. StringBuilder verwenden um
                // effizient Strings "zusammenzubauen"!
                StringBuilder ergebnis = new StringBuilder();
                for(int i = eingabe.length() - 1; i >= 0; --i){
                    ergebnis.append(eingabe.charAt(i));
                }
                // Das Ergebnis auf dem Label setzen
                lbErgebnis.setText(ergebnis.toString());
            }
        });

        // Die GUI Elemente in das jPanel einfügen
        jPanel.add(tfTextEingabe);
        jPanel.add(btAction);
        jPanel.add(lbErgebnis);

        // Das Panel zum aktiven, sichtbaren Inhalt des JFrame machen:
        this.getContentPane().add (jPanel) ;
        // Alle Elemente auf kleinstmögliche Größe bringen
        pack();
    }


}
