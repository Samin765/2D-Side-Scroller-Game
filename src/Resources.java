import java.awt.image.BufferedImage;

public class Resources{

    private static final int width = 1280, height = 720; 
    public static BufferedImage solarSystemBackground, marsBackground;

    public static void init(){
        WorldImages worldImage = new WorldImages(ImageLoader.loadImage("../spaceStars.jpeg"));  // fixa en stor bild med alla bilder vi ska ha med samma width och height

        marsBackground = ImageLoader.loadImage("../marsBackground.png");
         solarSystemBackground = worldImage.crop(0,0, width, height); // delar upp den stora bilden till små. 

    }
}