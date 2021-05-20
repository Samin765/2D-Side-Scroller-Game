
import java.awt.image.BufferedImage;

public class Resources {
    public static ImageLoader loader;
    public static BufferedImage solarSystemBackground, marsBackground, 
                                testCharacter, testCharacter2, firePlanet, farPlanet, alienGround, 
                                alienBackgroundPlanet, alienGrass, tileSet, jumpLeft,
                                woodbg1, woodbg2, woodbg3, woodbg4, marsDirt, marsGround, marsBridge,
                                marsWater, marsSkull, marsBlock, transparentBlock, jumpRight,
                                testGearDrop, venusBg1,venusBg2,venusBg3,venusBg4, purplePotion, orangePotion
                                ,bluePotion, bluePotionBlock, orangePotionBlock, purplePotionBlock, endScreen;
    public static WorldImages worldImage;
    public static BufferedImage[] playerLeft;
    public static BufferedImage[] playerRight;
    public static BufferedImage[] playerIdle;
    public static BufferedImage[] playerIdleRight;
    public static BufferedImage[] playerResting;
    public static BufferedImage[] playerAttackLeft;
    public static BufferedImage[] playerAttackRight;

    private static final int WIDTH = 1280, HEIGHT = 720;

    public Resources() {
        this.loader = new ImageLoader();
        this.playerLeft = new BufferedImage[8];
        this.playerIdle = new BufferedImage[4];
        this.playerIdleRight = new BufferedImage[3];
        this.playerRight = new BufferedImage[8];
        this.playerResting =  new BufferedImage[8];
        this.playerAttackLeft = new BufferedImage[8];
        this.playerAttackRight = new BufferedImage[7];

        //Frames for player going right animation
        this.playerLeft[0] = this.loader.loadImage("../src/Resources/LightBandit_Run_0.png");
        this.playerLeft[1] = this.loader.loadImage("../src/Resources/LightBandit_Run_1.png");
        this.playerLeft[2] = this.loader.loadImage("../src/Resources/LightBandit_Run_2.png");
        this.playerLeft[3] = this.loader.loadImage("../src/Resources/LightBandit_Run_3.png");
        this.playerLeft[4] = this.loader.loadImage("../src/Resources/LightBandit_Run_4.png");
        this.playerLeft[5] = this.loader.loadImage("../src/Resources/LightBandit_Run_5.png");
        this.playerLeft[6] = this.loader.loadImage("../src/Resources/LightBandit_Run_6.png");
        this.playerLeft[7] = this.loader.loadImage("../src/Resources/LightBandit_Run_7.png");

        this.playerIdle[0] = this.loader.loadImage("../src/Resources/LightBandit_Idle_0.png");
        this.playerIdle[1] = this.loader.loadImage("../src/Resources/LightBandit_Idle_1.png");
        this.playerIdle[2] = this.loader.loadImage("../src/Resources/LightBandit_Idle_2.png");
        this.playerIdle[3] = this.loader.loadImage("../src/Resources/LightBandit_Idle_3.png");

        this.playerRight[0] = this.loader.loadImage("../src/Resources/LightBandit_Run_0 [photoutils.com].png");
        this.playerRight[1] = this.loader.loadImage("../src/Resources/LightBandit_Run_1 [photoutils.com].png");
        this.playerRight[2] = this.loader.loadImage("../src/Resources/LightBandit_Run_2 [photoutils.com].png");
        this.playerRight[3] = this.loader.loadImage("../src/Resources/LightBandit_Run_3 [photoutils.com].png");
        this.playerRight[4] = this.loader.loadImage("../src/Resources/LightBandit_Run_4 [photoutils.com].png");
        this.playerRight[5] = this.loader.loadImage("../src/Resources/LightBandit_Run_5 [photoutils.com].png");
        this.playerRight[6] = this.loader.loadImage("../src/Resources/LightBandit_Run_6 [photoutils.com].png");
        this.playerRight[7] = this.loader.loadImage("../src/Resources/LightBandit_Run_7 [photoutils.com].png");

        this.playerResting[0] = this.loader.loadImage("../src/Resources/LightBandit_Recover_0.png");
        this.playerResting[1] = this.loader.loadImage("../src/Resources/LightBandit_Recover_1.png");
        this.playerResting[2] = this.loader.loadImage("../src/Resources/LightBandit_Recover_2.png");
        this.playerResting[3] = this.loader.loadImage("../src/Resources/LightBandit_Recover_3.png");
        this.playerResting[4] = this.loader.loadImage("../src/Resources/LightBandit_Recover_4.png");
        this.playerResting[5] = this.loader.loadImage("../src/Resources/LightBandit_Recover_5.png");
        this.playerResting[6] = this.loader.loadImage("../src/Resources/LightBandit_Recover_6.png");
        this.playerResting[7] = this.loader.loadImage("../src/Resources/LightBandit_Recover_7.png");

        this.playerAttackLeft[0] = this.loader.loadImage("../src/Resources/LightBandit_Attack_0.png");
        this.playerAttackLeft[1] = this.loader.loadImage("../src/Resources/LightBandit_Attack_1.png");
        this.playerAttackLeft[2] = this.loader.loadImage("../src/Resources/LightBandit_Attack_2.png");
        this.playerAttackLeft[3] = this.loader.loadImage("../src/Resources/LightBandit_Attack_3.png");
        this.playerAttackLeft[4] = this.loader.loadImage("../src/Resources/LightBandit_Attack_4.png");
        this.playerAttackLeft[5] = this.loader.loadImage("../src/Resources/LightBandit_Attack_5.png");
        this.playerAttackLeft[6] = this.loader.loadImage("../src/Resources/LightBandit_Attack_6.png");
        this.playerAttackLeft[7] = this.loader.loadImage("../src/Resources/LightBandit_Attack_7.png");

        this.playerAttackRight[0] = this.loader.loadImage("../src/Resources/image-2.png");
        this.playerAttackRight[1] = this.loader.loadImage("../src/Resources/image-3.png");
        this.playerAttackRight[2] = this.loader.loadImage("../src/Resources/image-4.png");
        this.playerAttackRight[3] = this.loader.loadImage("../src/Resources/image-5.png");
        this.playerAttackRight[4] = this.loader.loadImage("../src/Resources/image-6.png");
        this.playerAttackRight[5] = this.loader.loadImage("../src/Resources/image-7.png");
        this.playerAttackRight[6] = this.loader.loadImage("../src/Resources/image-8.png");

        this.playerIdleRight[0] = this.loader.loadImage("../src/Resources/idleRight_1.png");
        this.playerIdleRight[1] = this.loader.loadImage("../src/Resources/idleRight_2.png");
        this.playerIdleRight[2] = this.loader.loadImage("../src/Resources/idleRight_3.png");

        this.endScreen = this.loader.loadImage("../src/Resources/EndScreen.jpg");




        // fixa en stor bild med alla bilder vi ska ha med samma width och height
        this.worldImage = new WorldImages(this.loader.loadImage("../src/Resources/Mossy - TileSet.png"));

        this.marsBackground = this.loader.loadImage("../src/Resources/marsBackground.png");

        this.testCharacter = this.loader.loadImage("../src/Resources/LightBandit_idle_0.png");
        this.testCharacter2 = this.loader.loadImage("../characterTest.png");
        
        this.firePlanet = this.loader.loadImage("../src/Resources/Lava.png");

        this.farPlanet = this.loader.loadImage("../src/Resources/parallax-space-far-planets.png");

        this.alienGround = this.loader.loadImage("../src/Resources/alienDirtBlock.png");
        this.alienBackgroundPlanet = this.loader.loadImage("../src/Resources/alienBackgroundPlanet.png");
        this.alienGrass = this.loader.loadImage("../src/Resources/alienGrass.png");

        this.jumpLeft = this.loader.loadImage("../src/Resources/LightBandit_Jump_0.png");
        this.jumpRight = this.loader.loadImage("../src/Resources/jumpRight.png");

        this.woodbg1 = this.loader.loadImage("../src/Resources/parallax-demon-woods-bg.png");
        this.woodbg2 = this.loader.loadImage("../src/Resources/parallax-demon-woods-far-trees.png");
        this.woodbg3 = this.loader.loadImage("../src/Resources/parallax-demon-woods-mid-trees.png");
        this.woodbg4 = this.loader.loadImage("../src/Resources/parallax-demon-woods-close-trees.png");

        this.venusBg1 = this.loader.loadImage("../src/Resources/VenusBack1.png");
        this.venusBg2 = this.loader.loadImage("../src/Resources/VenusBack2.png");
        this.venusBg3 = this.loader.loadImage("../src/Resources/VenusBack3.png");
        this.venusBg4 = this.loader.loadImage("../src/Resources/VenusBack4.png");



        this.marsDirt = this.loader.loadImage("../src/Resources/Wasteland-Files(1).png");
        this.marsBridge = this.loader.loadImage("../src/Resources/Wasteland-Files(2).png");
        this.marsBlock = this.loader.loadImage("../src/Resources/Wasteland-Files(3).png");
        this.marsWater = this.loader.loadImage("../src/Resources/Wasteland-Files(4).png");
        this.marsGround = this.loader.loadImage("../src/Resources/Wasteland-Files(5).png");
        this.marsSkull = this.loader.loadImage("../src/Resources/Wasteland-Files(6).png");
        this.testGearDrop = this.loader.loadImage("../src/Resources/testDropGear.png");

        this.transparentBlock =  this.loader.loadImage("../src/Resources/transparentBlock.png");
        this.solarSystemBackground = this.loader.loadImage("../src/Resources/spaceStars.jpeg");

        this.orangePotion = this.loader.loadImage("../src/Resources/orangePotion.png");
        this.purplePotion = this.loader.loadImage("../src/Resources/purplePotion.png");
        this.bluePotion = this.loader.loadImage("../src/Resources/bluePotion.png");

        this.bluePotionBlock = this.loader.loadImage("../src/Resources/bluePotionBlock.png");
        this.purplePotionBlock = this.loader.loadImage("../src/Resources/2.png");
        this.orangePotionBlock = this.loader.loadImage("../src/Resources/2.png");










        // delar upp den stora bilden till små.
                this.tileSet = worldImage.crop(179, 60 , 1184, 1250);

        
    }
}