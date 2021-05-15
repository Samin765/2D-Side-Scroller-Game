import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

/**
 * Class WorldMaps - A class containing the render data for each location in the
 * game.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-13
 */
public class WorldMaps {
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
        this.sun = new Circle(640, 360, 50, Color.YELLOW);

        this.planet1 = new Circle(640, 60, 25, Color.GREEN);
        this.planet2 = new Circle(450, 360, 15, Color.RED);
        this.planet3 = new Circle(550, 320, 30, Color.BLUE);
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
}
