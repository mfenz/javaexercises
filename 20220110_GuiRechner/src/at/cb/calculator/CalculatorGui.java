package at.cb.calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorGui extends JFrame {
    private CalculatorBl bl;

    private JPanel paCalculator; // obere Panel
    private JPanel paHistory; // untere Panel

    // für paCalculator
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JPanel paTypes;
    private ButtonGroup btGroupTypes;
    private JRadioButton rbPlus;
    private JRadioButton rbMinus;
    private JRadioButton rbMulti;
    private JRadioButton rbDivi;
    private JButton btCalculate;
    private JTextField tfResult;

    // für paHistory
    private JLabel lbHistory;
    private JList<String> liHistory;
    private JButton btClearHistory;

    public CalculatorGui(CalculatorBl bl){
        super("Rechner");
        this.bl = bl;

        // Layout für JFrame setzen
        this.setLayout(new GridLayout(2, 1, 20, 20));

        // oberes Panel (paCalculator)
        paCalculator = new JPanel(new GridLayout(9, 1));
        this.add(paCalculator);
        // unteres Panel (paHistory)
        paHistory = new JPanel(new BorderLayout());
        this.add(paHistory);

        // paCalculator:
        paCalculator.add(new JLabel("Zahl 1:", SwingConstants.CENTER));
        tfNumber1 = new JTextField();
        paCalculator.add(tfNumber1);


        paCalculator.add(new JLabel("Rechenart:", SwingConstants.CENTER));
        paTypes = new JPanel(new GridLayout(1, 4));
        paCalculator.add(paTypes);

        btGroupTypes = new ButtonGroup();
        rbPlus = new JRadioButton("+");
        rbPlus.setActionCommand("+");
        rbMinus = new JRadioButton("-");
        rbMinus.setActionCommand("-");
        rbMulti = new JRadioButton("*");
        rbMulti.setActionCommand("*");
        rbDivi = new JRadioButton("/");
        rbDivi.setActionCommand("/");

        btGroupTypes.add(rbPlus);
        btGroupTypes.add(rbMinus);
        btGroupTypes.add(rbMulti);
        btGroupTypes.add(rbDivi);

        paTypes.add(rbPlus);
        paTypes.add(rbMinus);
        paTypes.add(rbMulti);
        paTypes.add(rbDivi);

        paCalculator.add(new JLabel("Zahl 2:", SwingConstants.CENTER));
        tfNumber2 = new JTextField();
        paCalculator.add(tfNumber2);

        btCalculate = new JButton("=");
        paCalculator.add(btCalculate);

        btCalculate.addActionListener(e -> onCalculateClicked());

        paCalculator.add(new JLabel("Ergebnis:", SwingConstants.CENTER));
        tfResult = new JTextField();
        tfResult.setEditable(false);
        paCalculator.add(tfResult);


        // paHistory
        liHistory = new JList<>();
        paHistory.add(liHistory, BorderLayout.CENTER);

        btClearHistory = new JButton("Clear History");
        paHistory.add(btClearHistory, BorderLayout.SOUTH);

        btClearHistory.addActionListener(e -> onClearHistoryClicked());

        lbHistory = new JLabel("History:");
        paHistory.add(lbHistory, BorderLayout.NORTH);

        this.setSize(300, 500);
    }

    private void onCalculateClicked(){
        if(btGroupTypes.getSelection() == null){
            JOptionPane.showMessageDialog(this, "Rechenart auswählen!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String type = btGroupTypes.getSelection().getActionCommand();

        String txtNumber1 = tfNumber1.getText();
        String txtNumber2 = tfNumber2.getText();
        if(txtNumber1.isBlank() || txtNumber2.isBlank()){
            JOptionPane.showMessageDialog(this, "Zahlen eingeben!", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            float number1 = Float.parseFloat(txtNumber1);
            float number2 = Float.parseFloat(txtNumber2);

            float result;
            switch (type){
                case "+":
                    result = bl.addition(number1, number2);
                    break;
                case "-":
                    result = bl.subtraction(number1, number2);
                    break;
                case "*":
                    result = bl.multiplication(number1, number2);
                    break;
                case "/":
                    result = bl.division(number1, number2);
                    break;
                default: result = 0;
            }

            tfResult.setText(result + "");

        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Ungültige Zahl", "Fehler", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void onClearHistoryClicked(){
    }
}
