import javax.swing.*;
import java.awt.*;

public class WeihnachtenGUI extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public WeihnachtenGUI() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(250, 250, 200, 200);
    }
}
