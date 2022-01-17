package at.cb.memory;

import at.cb.memory.bl.GameBl;
import at.cb.memory.gui.GameGui;

import javax.swing.*;

public class Memory {
    public static void main(String[] args) {
        GameBl bl = new GameBl();
        GameGui gui = new GameGui(bl);

        gui.setVisible(true);
        gui.setLocationRelativeTo(null);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
