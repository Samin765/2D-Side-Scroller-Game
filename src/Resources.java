import java.awt.image.BufferedImage;

public class Resources {
    public static ImageLoader loader;
    public static BufferedImage solarSystemBackground, marsBackground;
    public static WorldImages worldImage;

    private static final int WIDTH = 1280, HEIGHT = 720;

    public Resources() {
        this.loader = new ImageLoader();

        // fixa en stor bild med alla bilder vi ska ha med samma width och height
        this.worldImage = new WorldImages(this.loader.loadImage("../spaceStars.jpeg"));

        this.marsBackground = this.loader.loadImage("../marsBackground.png");
        // delar upp den stora bilden till små.
        this.solarSystemBackground = worldImage.crop(0, 0, WIDTH, HEIGHT);
    }
}
