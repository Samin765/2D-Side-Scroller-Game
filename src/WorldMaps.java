import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

/**
 * Class WorldMaps - A class containing the render data for each location in the
 * game.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-20
 */
public class WorldMaps implements ActionListener {
    private Display display;
    private BufferedImage img;
    private ImageLoader loader;

    public Circle sun;
    public Circle planet1;
    public Circle planet2;
    public Circle planet3;

    /**
     * Creates an object capable of rendering images
     */
    public WorldMaps() {
        this.loader = new ImageLoader();
    }

    /**
     * A location depicting a solar system with circle objects, representing planets
     * and stars
     * 
     * @param g2 The graphics engine
     */
    public void solarSystem(Graphics2D g2) {
        this.sun = new Circle(640, 360, 50);

        this.planet1 = new Circle(640, 60, 25);
        this.planet2 = new Circle(450, 360, 15);
        this.planet3 = new Circle(550, 320, 30);

        this.sun.addActionListener(this);
        this.planet1.addActionListener(this);
        this.planet2.addActionListener(this);
        this.planet3.addActionListener(this);

        // Need some way to add the buttons to the frame. Currently they don't exist
    }

    /**
     * A location depicting the planet Mars
     * 
     * @param g2 The graphics engine
     */
    public void planetMars(Graphics2D g2) {
        // TODO: Add components etc
    }

    /**
     * Draws the location's background onto the frame
     * 
     * @param g2    The graphics engine
     * @param image The background image to be rendered
     */
    public void drawBackground(Graphics2D g2, BufferedImage image) {
        g2.drawImage(image, 0, 0, null);
    }

    /**
     * Changes location if a specific circle is clicked
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sun) {
            System.out.println("Poo");
        } else if (e.getSource() == this.planet1) {
            System.out.println("Piss");
        } else {
            System.out.println("Fart");
        }
    }
}
