import java.awt.image.BufferedImage;

public class WorldImages {
    private BufferedImage image;

    public WorldImages(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage crop(int x, int y, int width, int height) {
        return image.getSubimage(x, y, width, height); // returns a portion of the image so you can "move around in the
                                                       // world"
    }
}