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
 * @version 2021-05-06
 */
public class WorldMaps {

    public void solarSystem(String image, Graphics2D g2) {
        try {
            BufferedImage img = ImageIO.read(new File(image));
            g2.drawImage(img, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Circle sun = new Circle(640, 360, 50, g2, Color.YELLOW);
        Circle planet1 = new Circle(400, 200, 25, g2, Color.GREEN);
        Circle planet2 = new Circle(600, 300, 30, g2, Color.BLUE);
    }

    public void planetMars() {
        // TODO: Add components etc
    }

    // TODO: Add more planets
}
