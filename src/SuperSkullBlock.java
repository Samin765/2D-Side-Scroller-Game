import java.awt.Graphics2D;

public class SuperSkullBlock extends WorldObject{
    public SuperSkullBlock(World world, Display display, float x, float y){
        super(world, display, x, y , WorldBlocks.blockWidth,WorldBlocks.blockHeigth);
        
    }

    public void update(){

    }

    public void render(Graphics2D g2){
        g2.drawImage(Resources.marsSkull, (int) (xPos - display.getCamera().getXCamera()) ,(int) (yPos - display.getCamera().getYCamera()), width, heigth, null);
        
    }
    @Override
    public void die(){
        world.getItemManager().addItem(Item.orangePotion.createItem((int) xPos, (int) yPos));
            world.getEntityManager().getPlayer().jumpSpeed += 10;
            world.getEntityManager().getPlayer().fallingSpeed += 0.5f;



    }


}