package at.cb.calculator;

import javax.swing.*;

public class CalculatorMain {
    public static void main(String[] args) {
        CalculatorBl bl = new CalculatorBl("history.txt");
        CalculatorGui gui = new CalculatorGui(bl);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setLocationRelativeTo(null);
    }
}
