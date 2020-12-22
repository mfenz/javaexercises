import java.awt.*;

public class Snowflake implements Drawable{
    private int screenWidth;
    private int screenHeight;
    private int x, y;
    public Snowflake(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        x = 40;
        y = 60;
    }
    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.white);
        graphics2D.fillOval(x, y, 30, 30);
    }
    @Override
    public void move() {
        y++;
        if(y > screenHeight){
            y = 0;
        }
    }
}
