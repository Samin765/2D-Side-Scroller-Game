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
    public BufferedImage img;

    public Circle sun;
    public Circle planet1;
    public Circle planet2;

    public void readImage(String image){
        try {
            img = ImageIO.read(new File(image));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solarSystem(String image, Graphics2D g2) {
        readImage(image);

        this.sun = new Circle(640, 360, 50);

        this.planet1 = new Circle(400, 200, 25);
        this.planet2 = new Circle(600, 320, 30);
    }

    public void planetMars(Graphics2D g2, String image) {
        // TODO: Add components etc
        readImage(image);
        
        g2.drawImage(img, 0 , 0, null);
    }

    // TODO: Add more planets
    public void drawSolarSystemBackground(Graphics2D g2, BufferedImage image) {
        g2.drawImage(image, 0, 0, null);
    }
}
