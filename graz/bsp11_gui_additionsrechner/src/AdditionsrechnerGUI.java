import javax.swing.*;
import java.awt.*;

public class AdditionsrechnerGUI extends JFrame {

    // Komponenten als Instanzvariablen anlegen, damit man in allen
    // Methoden sowie im Konstruktor der Klasse darauf zugreifen kann
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JLabel lbPlus;
    private JButton btOk;
    private JLabel lbResult;

    /**
     * Konstruktor der Klasse AdditionsrechnerGUI
     * Wird ausgeführt wenn mit new AdditionsrechnerGUI() ein neues Objekt der Klasse erzeugt wird
     * Wozu dient der Konstruktor? --> z. B. das Objekt mit Startwerten initialisieren
     */
    public AdditionsrechnerGUI(){
        // Titel des Fensters setzen
        // super: ruft den Konstruktor der Parent-Klasse (JFrame) auf
        // super muss (wenn es verwendet wird) immer als erstes im Konstruktor aufgerufen werden
        super("Additionsrechner");

        this.setLayout(new GridLayout(6, 1));

        // Textfeld für die Zahl 1 erzeugen
        tfNumber1 = new JTextField();
        // Textfeld zum JFrame hinzufügen
        this.add(tfNumber1);

        // Label für +
        lbPlus = new JLabel("+");
        this.add(lbPlus);

        // Textfeld für Zahl 2
        tfNumber2 = new JTextField();
        this.add(tfNumber2);

        // OK Button
        btOk = new JButton("=");
        // zum Button einen ActionListener hinzufügen
        // --> was soll passieren wenn der Button gedrückt wird
        btOk.addActionListener(e -> onCalculateClicked());
        this.add(btOk);

        // Ergebnis-Label
        lbResult = new JLabel();
        this.add(lbResult);

        JButton btX = new JButton("X");
        btX.setText("ABC");
        btX.addActionListener(e -> {
            JButton bt = (JButton) e.getSource();
            System.out.println(bt.getText());
        });
        this.add(btX);

        ButtonGroup btGroup = new ButtonGroup();
        

        this.pack();
        this.setSize(300, 200);
    }

    private void onCalculateClicked(){
        // Lese die User-Eingabe aus den Textfeldern ein
        // und speichere sie in zwei Variablen
        String txtNumber1 = tfNumber1.getText();
        String txtNumber2 = tfNumber2.getText();

        // ersetze Beistriche durch Punkte
        txtNumber1 = txtNumber1.replace(',', '.');
        txtNumber2 = txtNumber2.replace(',', '.');

        // wandle die User-Eingabe in double um (um damit rechnen zu können...)
        double number1 = Double.parseDouble(txtNumber1);
        double number2 = Double.parseDouble(txtNumber2);
        double result = number1 + number2;

        // Ergebnis um Label ausgeben
        lbResult.setText(String.valueOf(result));
        lbResult.setText(result + "");
    }
}
