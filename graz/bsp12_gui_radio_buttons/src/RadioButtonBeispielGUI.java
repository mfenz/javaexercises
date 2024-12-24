import javax.swing.*;
import java.awt.*;

public class RadioButtonBeispielGUI extends JFrame {

    private JRadioButton rbMale;
    private JRadioButton rbFemale;
    private JButton btOk;
    private ButtonGroup sexGroup;

    // Konstruktor der Klasse RadioButtonBeispielGUI
    public RadioButtonBeispielGUI(){
        setTitle("Ein Radio Button Beispiel");
        setSize(200, 300);
        this.setLayout(new GridLayout(3, 1));

        rbMale = new JRadioButton("Männlich");
        rbMale.setText("male");
        this.add(rbMale);
        rbFemale = new JRadioButton("Weiblich");
        this.add(rbFemale);

        // beides Radiobuttons in die ButtonGroup einfügen, damit immer nur
        // einer selektiert werden kann
        sexGroup = new ButtonGroup();
        sexGroup.add(rbFemale);
        sexGroup.add(rbMale);

        btOk = new JButton("Was wurde ausgewählt?");
        btOk.addActionListener(e -> onOkClicked());
        this.add(btOk);
        pack();
    }

    private void onOkClicked(){
        // welcher Radio Button wurde ausgewählt?
        boolean isMale = rbMale.isSelected();
        boolean isFemale = rbFemale.isSelected();

        String selected ="";
        if(rbMale.isSelected()){
            selected = "male";
        } else if(rbFemale.isSelected()){
            selected = "female";
        }

        System.out.printf("Männlich? %b Weiblich? %b, %s%n", isMale, isFemale, selected);
    }
}
