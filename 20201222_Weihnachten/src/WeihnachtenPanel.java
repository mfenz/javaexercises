import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WeihnachtenPanel extends JPanel {

    private int screenWidth;
    private int screenHeight;
    private ArrayList<Drawable> drawables;

    public WeihnachtenPanel(int screenWidth, int screenHeight, ArrayList<Drawable> drawables) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.drawables = drawables;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(screenWidth, screenHeight);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D)g;
        for(int i = 0; i < drawables.size(); ++i){
            drawables.get(i).draw(g2d);
        }
    }
}
