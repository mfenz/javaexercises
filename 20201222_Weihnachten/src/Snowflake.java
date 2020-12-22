import java.awt.*;

public class Snowflake implements Drawable{
    private int screenWidth;
    private int screenHeight;
    private int x, y, size;
    private Color color;
    public Snowflake(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        x = RandomUtils.randomNumber(0, screenWidth);
        y = RandomUtils.randomNumber(- screenHeight, 0);
        size = RandomUtils.randomNumber(3, 15);
        color = randomColor();
    }
    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(color);
        graphics2D.fillOval(x, y, size, size);
    }
    @Override
    public void move() {
        int speed = RandomUtils.randomNumber(0, 4);
        y += speed;
        if(y > screenHeight){
            y = 0;
        }
        int abdrift = RandomUtils.randomNumber(-2, 3);
        //System.out.println(abdrift);
        x += abdrift;
        if(x < 0 || x > screenWidth){
            x = screenWidth / 2;
        }
    }

    private Color randomColor(){
        int r = RandomUtils.randomNumber(0, 256);
        int g = RandomUtils.randomNumber(0, 256);
        int b = RandomUtils.randomNumber(0, 256);
        return new Color(r, g, b);
    }
}
