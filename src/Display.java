import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Display extends Canvas {
    private JFrame frame;
    private Dimension size;

    private static String title = "No man's budget";
    static final int WIDTH = 800;
    static final int HEIGHT = 600;

    public Display() {
        // Creates the window's frame and dimension
        this.frame = new JFrame();
        this.size = new Dimension(WIDTH, HEIGHT);

        // Sets the window's title
        this.frame.setTitle(title);

        // Sets the window's size
        this.setPreferredSize(size);
        this.frame.add(this);
        this.frame.pack();

        // Enables shutdown of program
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the window's location to center
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        // Enable visibility
        this.frame.setVisible(true);
    }
}