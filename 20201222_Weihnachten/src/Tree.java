import java.awt.*;

public class Tree implements Drawable{

    private int screenWidth;
    private int screenHeight;

    public Tree(int screenWidth, int screenHeight){
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.setColor(new Color(66, 105, 47));
        int yOffset = 50;
        Polygon polygon = new Polygon();
        polygon.addPoint(screenWidth / 2, yOffset + 50);
        polygon.addPoint(screenWidth / 4, yOffset + 200);
        polygon.addPoint(screenWidth - (screenWidth / 4), yOffset + 200);
        graphics2D.fillPolygon(polygon);

        Polygon p2 = new Polygon();
        p2.addPoint(screenWidth / 2, yOffset + 100);
        p2.addPoint(screenWidth / 6, yOffset + 300);
        p2.addPoint(screenWidth - (screenWidth / 6), yOffset + 300);
        graphics2D.fillPolygon(p2);

        Polygon p3 = new Polygon();
        p3.addPoint(screenWidth / 2, yOffset + 200);
        p3.addPoint(screenWidth / 8, yOffset + 400);
        p3.addPoint(screenWidth - (screenWidth / 8), yOffset + 400);
        graphics2D.fillPolygon(p3);

        graphics2D.setColor(new Color(171, 97, 52));
        graphics2D.fillRect(screenWidth / 2 - 50/2, yOffset + 400, 50, 50);

    }

    @Override
    public void move() {

    }
}
