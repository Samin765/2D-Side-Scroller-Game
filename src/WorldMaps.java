import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

/**
 * Class WorldMaps - A class containing the render data for each location in the
 * game.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-20
 */
public class WorldMaps {
    private Display display;
    private BufferedImage img;
    private ImageLoader loader;

    public static Circle sun, planet1, planet2, planet3;

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

        this.planet1 = new Circle(640, 60, 15);
        this.planet2 = new Circle(450, 360, 30);
        this.planet3 = new Circle(550, 320, 25);
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