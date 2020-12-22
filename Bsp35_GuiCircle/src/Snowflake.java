import javax.swing.*;
import java.awt.*;

public class Snowflake implements Drawable {
    private int frameWidth;
    private int frameHeight;

    private int x, y;
    private int size;

    Color color;

    public Snowflake(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;

        this.size = Utils.randomNumber(10, 40);
        this.x = Utils.randomNumber(0, frameWidth);

        switch (Utils.randomNumber(0, 3)){
            case 0: color = Color.CYAN; break;
            case 1: color = Color.GREEN; break;
            case 2: color = Color.red; break;
            default:color = Color.magenta; break;
        }
    }

    public void move(){
        y++;
        if(y > frameHeight){
            y = 0;
        }
        if(x > frameWidth){
            x = 0;
        }
    }

    @Override
    public void repaint() {

    }

    public Dimension getPreferredSize() {
        return new Dimension(frameWidth, frameHeight);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(6.0F));
        
        g.setColor(color);
        g.drawOval(x, y, size, size);
        g.drawOval(x+30, y+30, size, size);
        g.drawPolygon(new Polygon());

    }
}
