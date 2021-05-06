import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Class Display - Creates a window with JFrame. The title, position, size,
 * color/image and closeability of the window is predetermined.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-06
 */
public class Display extends Canvas {
    private JFrame frame;
    private Dimension size;
    private Canvas canvas;

    private static String title = "No man's budget";
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    /**
     * Creates a window with an image as a background
     * 
     * @param color the background color
     */
    public Display(Color color) {
        // Creates the window's frame and dimension
        this.frame = new JFrame(title);

        // Configures the window's dimensions
        this.size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);

        frameConfig(this.frame);

        // Sets the window's background colour
        this.frame.setBackground(color);
    }

    /**
     * Creates a window with an image as a background
     * 
     * @param img the background image
     */
    public Display(String img) {
        // Creates the window's frame and dimension
        this.frame = new JFrame(title);

        // Sets the window's dimension and background
        try {
            this.frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(img)))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        frameConfig(this.frame);
    }

    /**
     * A helper function for configurating a JFrame's window with basic functions
     * such as setTitle, setVisible and so on.
     * 
     * @param frame the frame to receive the configurations
     */
    private void frameConfig(JFrame frame) {

        // Sets the window's size
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
