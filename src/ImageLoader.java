import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

/**
 * Class ImageLoader - Reads a file and creates a BufferedImage to be used to
 * draw the backgrounds
 * 
 * @author Samin chowdhury
 * @version 2021-05-09
 */
public class ImageLoader {

    /**
     * Reads the file and stores the image in a buffer
     * 
     * @param path The pathway to the file
     * @return A Buffered file, unless an exception is caught.
     */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
