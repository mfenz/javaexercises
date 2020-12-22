import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WeihnachtenGUI extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private ArrayList<Drawable> drawables = new ArrayList<>();

    public WeihnachtenGUI() {
        setTitle("Weihnachten!!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        Tree tree = new Tree(WIDTH, HEIGHT);
        drawables.add(tree);

        Snowflake snowflake = new Snowflake(WIDTH, HEIGHT);
        drawables.add(snowflake);

        ActionListener listener = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        Timer timer = new Timer(50, listener);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        for(int i = 0; i < drawables.size(); ++i){
            drawables.get(i).draw(g2d);
        }
        //g.drawOval(250, 250, 200, 200);
    }
}
