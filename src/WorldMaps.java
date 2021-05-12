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
 * @version 2021-05-12
 */
public class WorldMaps {
    public BufferedImage img;

    public Circle sun;
    public Circle planet1;
    public Circle planet2;
    public Circle planet3;

    public void solarSystem(String image, Graphics2D g2) {
        try {
            this.img = ImageIO.read(new File(image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.sun = new Circle(640, 360, 50);

        this.planet1 = new Circle(640, 60, 25);
        this.planet2 = new Circle(450, 360, 15);
        this.planet3 = new Circle(550, 320, 30);
    }

    public void planetMars() {
        // TODO: Add components etc
    }

    // TODO: Add more planets

    public void drawBackground(Graphics2D g2, BufferedImage image) {
        g2.drawImage(image, 0, 0, null);
    }
}
