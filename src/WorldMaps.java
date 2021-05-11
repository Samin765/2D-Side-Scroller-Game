import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

/**
 * Class WorldMaps - A class containing the render data for each location in the
 * game.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-10
 */
public class WorldMaps {
    private BufferedImage img;
    private ImageLoader loader;

    public Circle sun;
    public Circle planet1;
    public Circle planet2;
    public Circle planet3;

    public WorldMaps() {
        this.loader = new ImageLoader();
    }

    public void solarSystem(String image, Graphics2D g2) {
        this.sun = new Circle(640, 360, 50);

        this.planet1 = new Circle(640, 60, 25);
        this.planet2 = new Circle(450, 360, 15);
        this.planet3 = new Circle(550, 320, 30);
    }

    public void planetMars(Graphics2D g2, String image) {
        // TODO: Add components etc
    }

    public void drawBackground(Graphics2D g2, BufferedImage image) {
        g2.drawImage(image, 0, 0, null);
    }
}
