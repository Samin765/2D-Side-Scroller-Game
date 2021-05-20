import java.awt.image.BufferedImage;

/**
 * Class Resources - Contains all images, files and/or external resources to be
 * used that can't be solved solely through the usage of coding
 * 
 * @author Samin Chowdhury
 * @author Love Lindgren
 * @version 2021-05-20
 */
public class Resources {
    public static ImageLoader loader;
    public static BufferedImage solarSystemBackground, marsBackground, planetBackground;
    public static WorldImages worldImage;

    private static final int WIDTH = 1280, HEIGHT = 720;

    /**
     * Loads a an ImageLoader processes the image and stores it in a buffer, to be
     * used in WorldImages
     */
    public Resources() {
        this.loader = new ImageLoader();

        // fixa en stor bild med alla bilder vi ska ha med samma width och height
        this.worldImage = new WorldImages(this.loader.loadImage("../spaceStars.jpeg"));
        this.marsBackground = this.loader.loadImage("../marsBackground.png");

        this.planetBackground = this.loader.loadImage("../scorched_planet.png");

        // delar upp den stora bilden till små.
        this.solarSystemBackground = worldImage.crop(0, 0, WIDTH, HEIGHT);
    }
}
