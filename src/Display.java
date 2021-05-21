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
 * @version 2021-05-20
 */
public class Display extends Canvas {
    public JFrame frame;
    private Dimension size;

    private KeyInput keyInput = new KeyInput(this);
    private WorldCamera worldCamera = new WorldCamera(this, 0f, 0f); // 0f means that it's a float value

    private static String title = "No man's budget";
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    /**
     * Creates a window with set dimensions and configurations
     */
    public Display() {
        // Creates the window's frame and dimension
        this.frame = new JFrame(this.title);

        // Configures the window's dimensions
        this.size = new Dimension(this.WIDTH, this.HEIGHT);
        this.setPreferredSize(this.size);

        this.frame.add(this);
        this.frame.pack();

        // Enables shutdown of program
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the window's location to center
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        // Adds keyListener to the frame
        this.frame.setFocusTraversalKeysEnabled(false);
        this.frame.addKeyListener(this.keyInput);

        // Enable visibility
        this.frame.setVisible(true);
    }

    /**
     * Change title for the window
     * 
     * @param title The frame's current title
     */
    public void setNewTitle(String title) {
        this.frame.setTitle(this.title);
    }

    /**
     * @return the display's canvas
     */
    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * @return the display's key input
     */
    public KeyInput getKey() {
        return this.keyInput;
    }

    /**
     * @return the display's camera
     */
    public WorldCamera getCamera() {
        return this.worldCamera;
    }
}
