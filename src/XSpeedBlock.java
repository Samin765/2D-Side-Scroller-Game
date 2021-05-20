import java.awt.Graphics2D;

public class XSpeedBlock extends WorldObject{
    public XSpeedBlock(World world, Display display, float x, float y){
        super(world, display, x, y , WorldBlocks.blockWidth,WorldBlocks.blockHeigth);
        
    }

    public void update(){

    }

    public void render(Graphics2D g2){
        g2.drawImage(Resources.purplePotionBlock, (int) (xPos - display.getCamera().getXCamera()) ,(int) (yPos - display.getCamera().getYCamera()), width, heigth, null);
        
    }
    @Override
    public void die(){
        world.getItemManager().addItem(Item.purplePotion.createItem((int) xPos, (int) yPos));
            world.getEntityManager().getPlayer().speedX += 10;



    }


}