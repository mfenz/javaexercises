import java.awt.*;

public class Snowflake implements Drawable{
    private int screenWidth;
    private int screenHeight;
    private int x, y, size;
    public Snowflake(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        x = RandomUtils.randomNumber(0, screenWidth);
        y = RandomUtils.randomNumber(- screenHeight, 0);
        size = RandomUtils.randomNumber(3, 15);
    }
    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(Color.red);
        graphics2D.fillOval(x, y, size, size);
    }
    @Override
    public void move() {
        int speed = RandomUtils.randomNumber(0, 4);
        y += speed;
        if(y > screenHeight){
            y = 0;
        }
        int abdrift = RandomUtils.randomNumber(-2, 2);
        //System.out.println(abdrift);
        x += abdrift;
        if(x < 0 || x > screenWidth){
            x = screenWidth / 2;
        }
    }
}
