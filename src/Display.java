import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Class Display - Creates a window with JFrame. The title, position, size,
 * color/image and closeability of the window is predetermined.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-08
 */
public class Display extends Canvas {
    private JFrame frame;
    private Dimension size;

    private static String title = "No man's budget";
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    /**
     * Creates a window with set dimensions and configurations
     */
    public Display() {
        // Creates the window's frame and dimension
        this.frame = new JFrame(title);

        // Configures the window's dimensions
        this.size = new Dimension(WIDTH, HEIGHT);
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

    /**
     * Change title for the window
     * 
     * @param title The frame's current title
     */
    public void setNewTitle(String title) {
        this.frame.setTitle(title);
    }
}
