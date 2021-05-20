import java.awt.Graphics2D;

public class XSpeedBlock extends WorldObject {

    public XSpeedBlock(World world, Display display, float x, float y) {
        super(world, display, x, y, WorldBlocks.blockWidth, WorldBlocks.blockHeigth);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(Resources.purplePotionBlock, (int) (this.xPos - this.display.getCamera().getXCamera()),
                (int) (this.yPos - this.display.getCamera().getYCamera()), this.width, this.heigth, null);
    }

    @Override
    public void die() {
        this.world.getItemManager().addItem(Item.purplePotion.createItem((int) this.xPos, (int) this.yPos));
        this.world.getEntityManager().getPlayer().speedX += 10;
    }
}
