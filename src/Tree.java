import java.awt.Graphics2D;

public class Tree extends WorldObject {
    public Tree(World world, Display display, float x, float y) {
        super(world, display, x, y, WorldBlocks.blockWidth, WorldBlocks.blockHeigth);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(Resources.marsSkull, (int) (this.xPos - this.display.getCamera().getXCamera()),
                (int) (this.yPos - this.display.getCamera().getYCamera()), this.width, this.heigth, null);
    }

    @Override
    public void die() {
        this.world.getItemManager().addItem(Item.bluePotion.createItem((int) this.xPos, (int) this.yPos));
        // world.getEntityManager().getPlayer().jumpSpeed += 5;
    }
}
