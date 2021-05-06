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
 * Creates a window with JFrame. The title, position, size, color/image and
 * closeability of the window is predetermined.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-04
 */
public class Display extends Canvas {
    private JFrame frame;
    private Dimension size;
    private Canvas canvas;

    private static String title = "No man's budget";
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    public Display() {
        // Creates the window's frame and dimension
        frame = new JFrame();
        size = new Dimension(WIDTH, HEIGHT);
        
        // Sets the windows icon image  
        ImageIcon windowsIcon = new ImageIcon("../windowsIcon.png");
        this.frame.setIconImage(windowsIcon.getImage());
    
        // Sets the window's title
        this.frame.setTitle(title);

        // Sets the window's size
        this.frame.setPreferredSize(size);
        this.frame.setSize(size);

        // Program exist when window is closed
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Sets the window's location to center
        this.frame.setLocationRelativeTo(null);

        // Enable visibility
        this.frame.setVisible(true);

        // Creates the canvas
        this.canvas = new Canvas();
        this.canvas.setPreferredSize(size);
        this.canvas.setMaximumSize(size);
        this.canvas.setMinimumSize(size);
        
        this.frame.add(canvas);
        this.frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }
}