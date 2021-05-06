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
        frame = new JFrame();
        size = new Dimension(WIDTH, HEIGHT);
        
        // Sets the windows icon image  
        ImageIcon windowsIcon = new ImageIcon("../windowsIcon.png");
        this.frame.setIconImage(windowsIcon.getImage());
    
        // Sets the window's title
        this.frame.setTitle(title);

        //this.frame.setSize(size);


        // Sets the window's size
        this.frame.setPreferredSize(size);
        //this.frame.add(this);
        //this.frame.pack();

        // Program exist when window is closed
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        // Sets the window's location to center
        this.frame.setLocationRelativeTo(null);

        // Sets the window's background colour
        //this.frame.setBackground(color);

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

        // Sets the window's title
        this.frame.setTitle(title);

        // Sets the window's background image
        try {
            this.frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(img)))));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.frame.add(this);

      

        // Program exist when window is closed
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sets the window's location to center
        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

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