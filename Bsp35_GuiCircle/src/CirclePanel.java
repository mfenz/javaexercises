import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CirclePanel extends JPanel {

    private int frameWidth;
    private int frameHeight;

    private List<Drawable> drawables;

    public CirclePanel(int frameWidth, int frameHeight, List<Drawable> drawables) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.drawables = drawables;
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        drawables.forEach(drawable -> {
            drawable.draw(g);
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawables.forEach(drawable -> {
            drawable.draw(g);
        });
        setSize(500, 500);
        g.setColor(Color.BLUE);
        g.drawOval(250, 250, 200, 250);
        g.fillOval(250, 250, 200, 200);
    }
}
