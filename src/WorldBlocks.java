
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
/**
 * Class WorldBlocks - Stores and renders every block used
 * 
 * @author Samin chowdhury
 * @version 2021-05-15
 */

public class WorldBlocks{
    public static WorldBlocks[] blocks =  new WorldBlocks[20];   // 20 blocks to build the planets with. Increase if neccessary
    public static WorldBlocks backgroundBlock = new BackgroundBlock(0);  // might be better to use strings to represent the block rather than numbers (use hashmap rather than Array)
    public static WorldBlocks groundBlock = new GroundBlock(1); 
    public static WorldBlocks marsDirt =  new MarsDirt(2);
    public static WorldBlocks marsGround =  new MarsGround(3);
    public static WorldBlocks  marsBlock =  new MarsBlock(4);
    public static WorldBlocks marsWater = new MarsWater(5);
    public static WorldBlocks marsBridge = new MarsBridge(6);
    public static WorldBlocks marsSkull =  new MarsSkull(7);
    public static WorldBlocks transparentBlock = new TransparentBlock(8);
  

    public static int blockWidth = 100;
    public static  int blockHeigth = 100;

    protected BufferedImage block;
    protected int id;


    public WorldBlocks(BufferedImage block, int id, int blockWidth, int blockHeigth){
        this.block = block;
        this.id = id;
        this.blockHeigth = blockHeigth;
        this.blockWidth = blockWidth;

        blocks[id] = this;  // The object you're creating will be inserted into the specificed array index in blocks[]
    }


    public void update(){

    }

    public void render(Graphics2D g2, int xPos, int yPos){
        g2.drawImage(block, xPos, yPos, blockWidth, blockHeigth, null);

    }

    public int getId(){
        return id;
    }

    public boolean isSolid(){
        return false;
    }

}
