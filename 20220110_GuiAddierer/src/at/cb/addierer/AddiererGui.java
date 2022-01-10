package at.cb.addierer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasse AddiererGui ist ein JFrame
 * --> das Fenster in dem alle anderen Bedienelemente enthalten sein werden
 */
public class AddiererGui extends JFrame {

    // Objekt der Business Logic als Instanzvariable deklarieren
    private RechnerBl bl;

    private JTextField tfNumber1;
    private JLabel lbPlus;
    private JTextField tfNumber2;
    private JButton btCalculate;
    private JLabel lbResult;

    /**
     * Konstruktor: public Klassenname
     * in den runden Klammern: Übergabeparameter
     * @param title
     */
    public AddiererGui(String title, RechnerBl bl) {
        // super: ruft den Konstruktor der Elternklasse (JFrame) auf
        // (title) <-- Variable title wird beim Aufruf des Konstruktors der Elternklasse übergeben
        // super muss (wenn es verwendet wird) immer als erstes im Konstruktor aufgerufen werden!
        super(title);

        // bl-Objekt der Instanzvariable zuweisen
        this.bl = bl;

        // Layout setzen
        // Gridlayout: 5 Zeilen, 1 Spalte
        this.setLayout(new GridLayout(5, 1));

        // Instanzvariable initialisieren
        // Textfeld für die Zahl 1 erzeugen
        tfNumber1 = new JTextField();
        // Textfeld zum JFrame hinzufügen
        this.add(tfNumber1);

        // Label für + erzeugen
        lbPlus = new JLabel("+");
        lbPlus.setHorizontalAlignment(SwingConstants.CENTER);
        // Label zum JFrame hinzufügen
        this.add(lbPlus);

        tfNumber2 = new JTextField();
        this.add(tfNumber2);

        btCalculate = new JButton("=");
        // Was soll passieren wenn der Button gedrückt wird?
        // Anonyme Klasse: Methode actionPerformed() implementieren
        /*btCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("click!");
            }
        });*/

        // Mit lambdas:
        // Übergabeparameter -> Methodenkörper
        btCalculate.addActionListener(e -> {
            // implementierung der Methode actionPerformed()
            onCalculateResultClicked();
        });
        this.add(btCalculate);

        lbResult = new JLabel();
        this.add(lbResult);


        this.pack();
        this.setSize(300, 200);
    }

    private void onCalculateResultClicked(){
        // Textfelder einlesen

        // Wurde etwas im Textfeld eingegeben?

        // .getText() <-- den eingegebenen Text erhalten
        String txtNumber1 = replaceComma(tfNumber1.getText());
        String txtNumber2 = replaceComma(tfNumber2.getText());

        if(txtNumber1.trim().equals("")){
            // in Textfeld 1 wurde nichts eingegeben!
            // Fehlermeldung ausgeben lassen
            JOptionPane.showMessageDialog(this, "Zahl 1 darf nicht leer sein", "Fehler", JOptionPane.ERROR_MESSAGE);
        } else if(txtNumber2.isBlank()){
            JOptionPane.showMessageDialog(this, "Zahl 2 darf nicht leer sein", "Fehler", JOptionPane.ERROR_MESSAGE);
        } else {

            try {
                float number1 = Float.parseFloat(txtNumber1);
                float number2 = Float.parseFloat(txtNumber2);

                // Ergebnis berechnen lassen
                float result = bl.addition(number1, number2);
                // Ergebnis im Label ausgeben lassen
                lbResult.setText(result + "");

                clearInput();
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Nur Zahlen eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    private void clearInput(){
        tfNumber1.setText("");
        tfNumber2.setText("");
    }

    private String replaceComma(String number){
        return number.replace(",", ".");
    }
}
