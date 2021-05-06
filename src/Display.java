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

    public Display(Color color) {
        // Creates the window's frame and dimension
        this.frame = new JFrame();
        this.size = new Dimension(WIDTH, HEIGHT);

        // Creates the canvas
        canvas = new Canvas();
        canvas.setPreferredSize(size);
        this.frame.add(canvas);

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

        // Sets the window's background colour
        this.frame.setBackground(color);

        // Enable visibility
        this.frame.setVisible(true);

        
       
    }

    /**
     * Creates a window with an image as a background
     * 
     * @param img
     */
    public Display(String img) {
        // Creates the window's frame and dimension
        this.frame = new JFrame();

        // Sets the windows icon image  
        ImageIcon windowsIcon = new ImageIcon("../windowsIcon.png");
        frame.setIconImage(windowsIcon.getImage());


        // Creates the canvas
        canvas = new Canvas();
        canvas.setPreferredSize(size);
        this.frame.add(canvas);

        // Sets the window's title
        this.frame.setTitle(title);

        // Sets the window's background image
        try {
            this.frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(img)))));
        } catch (IOException e) {
            e.printStackTrace();
        }

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

    public Canvas getCanvas(){
        return canvas;
    }
}