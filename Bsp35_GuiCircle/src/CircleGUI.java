import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CircleGUI extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    java.util.List<Drawable> elements = new ArrayList<>();

    private CirclePanel circlePanel;

    public CircleGUI() {
        setTitle("Draw!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);

        circlePanel = new CirclePanel(WIDTH, HEIGHT, elements);

        ActionListener listener = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                elements.forEach(drawable -> {
                    drawable.move();
                });
                circlePanel.repaint();
            }
        };
        Timer timer = new Timer(50, listener);
        timer.start();

        for(int i = 0; i < 10; ++i){
            Snowflake snowflake = new Snowflake(WIDTH, HEIGHT);
            elements.add(snowflake);
        }


        this.getContentPane().add(circlePanel);
    }

    /*@Override
    public void paint(Graphics g) {
        super.paint(g);

        setSize(500, 500);
        g.setColor(Color.BLUE);
        g.drawOval(250, 250, 200, 250);
        g.fillOval(250, 250, 200, 200);
    }*/

    public static void main(String[] args) {
        CircleGUI gui = new CircleGUI();
        gui.setVisible(true);
    }

}
