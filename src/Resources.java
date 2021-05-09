import java.awt.image.BufferedImage;

public class Resources{

    private static final int height = 500, width = 220;
    public static BufferedImage solarSystemBackground, marsBackground;

    public static void init(){
        WorldImages worldImage = new WorldImages(ImageLoader.loadImage("../marsBackground.png"));

         marsBackground = worldImage.crop(0,80, width, height);

    }
}