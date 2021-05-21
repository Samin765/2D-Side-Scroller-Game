import java.awt.Graphics2D;

/**
 * Class SuperSkullBlock - Creates an object with a skull inside
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class SuperSkullBlock extends WorldObject {

    /**
     * Creates a SuperSkullBlock
     * 
     * @param world   The object's start location
     * @param display The display
     * @param x       The object's start x-position
     * @param y       The object's start y-position
     */
    public SuperSkullBlock(World world, Display display, float x, float y) {
        super(world, display, x, y, WorldBlocks.blockWidth, WorldBlocks.blockHeight);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(Resources.marsSkull, (int) (this.xPos - this.display.getCamera().getXCamera()),
                (int) (this.yPos - this.display.getCamera().getYCamera()), this.width, this.height, null);
    }

    @Override
    public void die() {
        this.world.getItemManager().addItem(Item.orangePotion.createItem((int) this.xPos, (int) this.yPos));
        this.world.getEntityManager().getPlayer().jumpSpeed += 10;
        this.world.getEntityManager().getPlayer().fallingSpeed += 0.5f;
    }
}
