import java.awt.image.BufferedImage;

/**
 * Class WorldImages - Loads buffered images that will be cropped so the player
 * can "move around the world"
 * 
 * @author Samin Chowdhury
 * @version 2021-05-09
 */
public class WorldImages {
    private BufferedImage image;

    /**
     * Loads a buffered image to be cropped.
     * 
     * @param image The image to be cropped
     */
    public WorldImages(BufferedImage image) {
        this.image = image;
    }

    /**
     * Crops the image
     * 
     * @param x      The origin position along the x-axis for the image
     * @param y      The origin position along the y-axis for the image
     * @param width  The width of the image to be used
     * @param height The height of the image to be used
     * @return A portion of the image
     */
    public BufferedImage crop(int x, int y, int width, int height) {
        // returns a portion of the image so you can "move around in the world"
        return this.image.getSubimage(x, y, width, height);
    }
}
