import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
/**
 * Class Player - Creates the player object
 * and handles keyboard inputs
 * 
 * @author Samin chowdhury
 * @version 2021-05-15
 */
public class Player extends Creature{

    private Animation animationLeft;
    private Animation animationIdle;
    private Animation animationIdleRight;
    private Animation animationRight;
    private Animation animationResting;
    private Animation animationAttackLeft;
    private Animation animationAttackRight;

    protected boolean falling = true;
    protected boolean jumping = false;
    protected float gravity;
    private long jumpingTime = 200;

    protected int jumpSpeed;
    protected int fallingSpeed;


    final private static long keyReleasedTimeLock = 800L;
    private static long keyReleased;

    private long lastAttack, attackLock  = 800;
    private long attackCoolDown = attackLock;

    private int idle;

    public Player(World world, Display display, float xPos, float yPos){
        super(world, display, xPos,yPos, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGTH);
       
        collision.x = 36;
        collision.y = 32;
        collision.height = 80;
        collision.width = 32;

        this.jumpSpeed = 10;
        this.fallingSpeed = 7;

        this.animationLeft = new Animation(0, Resources.playerLeft);
        this.animationIdle = new Animation(0, Resources.playerIdle);
        this.animationRight = new Animation(0, Resources.playerRight);
        this.animationResting = new Animation(0, Resources.playerResting);
        this.animationAttackLeft = new Animation(0, Resources.playerAttackLeft);
        this.animationAttackRight = new Animation(0, Resources.playerAttackRight);
        this.animationIdleRight = new Animation(0, Resources.playerIdleRight);
    }

    public void update(){  
        animationLeft.update();
        animationIdle.update();
        animationIdleRight.update();
        animationRight.update();
        animationResting.update();
        animationAttackLeft.update();
        animationAttackRight.update();

        getPlayerInput();
        move();   // Calls Creatures move() method  
        display.getCamera().followPlayer(this);  // follow this player

        checkAttacks();

    }

    private void checkAttacks(){
        attackLock += System.currentTimeMillis() - lastAttack; 
        lastAttack = System.currentTimeMillis();

        if(attackLock < attackCoolDown){
            return;
        }
        Rectangle player = getCollisionBounds(0f, 0f);
        Rectangle attack = new Rectangle();
        int attackSize = 20;
        attack.width = attackSize;
        attack.height = attackSize;

        if(display.getKey().aUp){
            attack.x = player.x + player.width / 2+ attackSize / 2;
            attack.y = player.y - attackSize;
        }
        else if(display.getKey().aDown){
            attack.x = player.x + player.width / 2+ attackSize / 2;
            attack.y = player.y - player.height;
        }
        else if(display.getKey().aLeft){
            attack.x = player.x - attackSize;
            attack.y = player.y + player.height / 2 - attackSize / 2;
        }
        else if(display.getKey().aRight){
            attack.x = player.x + player.width;
            attack.y = player.y + player.height/ 2 - attackSize / 2;
        }
        else{
            return;
        }

        attackLock = 0;

        for(Entity e : world.getEntityManager().getEntities()){
            if(e.equals(this)){  // dont attack yourself
                continue;
            }
            if(e.getCollisionBounds(0, 0).intersects(attack)){
                e.hurt(20); 
                return;
            }

        }

    }

    private void getPlayerInput(){
        xMove = 0;
        yMove = 0;
        

        if(this.display.getKey().jump){
           float oldYPos = yPos;
            
            if(!jumping){
                final long currentTime = System.currentTimeMillis();
                if( (currentTime - keyReleased) <= keyReleasedTimeLock){
                    yPos = oldYPos;
                    return;
                }
                
                jump();
                keyReleased = System.currentTimeMillis();
            }
            
            
        }
           
        if(this.display.getKey().down){
            yMove = speedY;
        }
        if(this.display.getKey().right){
            xMove = speedX;
        }
        if(this.display.getKey().left){
            xMove -= speedX;
        }
        if(this.display.getKey().esc){
            System.exit(1);
        }
        if(jumping){       
            int ty2 = (int) (yPos - jumpSpeed + collision.y)/WorldBlocks.blockHeigth;
    
            if(!collisionWithBlock((int)(xPos + collision.x)/WorldBlocks.blockWidth, ty2) &&
                        !collisionWithBlock((int)(xPos + collision.x + collision.width)/WorldBlocks.blockWidth, ty2)){
                        
                            yPos = yPos - jumpSpeed;           
            }
            else{ // collision
                jumping = false;
            }
              
            
            
        }
        if(!jumping){
            gravity += 0.008f;
            int ty = (int) (yPos + (fallingSpeed+gravity) + collision.y + collision.height)/WorldBlocks.blockHeigth;
    
            if(!collisionWithBlock((int)(xPos + collision.x)/WorldBlocks.blockWidth, ty) &&
                        !collisionWithBlock((int)(xPos + collision.x + collision.width)/WorldBlocks.blockWidth, ty)){
                            yPos +=fallingSpeed + gravity;
                
            }
            else{ // collision
                yPos = ty *WorldBlocks.blockHeigth - collision.y - collision.height - 1;
                gravity = 0.009f;

             
            }
           
            
            
        }

    }

    public void jump(){
         jumping = true;
            new Thread(new thread()).start();
            

    }

    public class thread implements Runnable {  // this might not be the smartest thing to do but it works ..or it is the smartest thing to do

        @Override
        public void run() {
            try{
                Thread.sleep(jumpingTime);
                jumping = false;
            }catch(Exception e) {
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
        }
    }

}

    public void render(Graphics2D g2){ 
        
        g2.drawImage(getCurrentFrame(), (int) (xPos - display.getCamera().getXCamera())
                                            , (int) (yPos - display.getCamera().getYCamera())
                                            , width, heigth, null);    
                                            
       // g2.setColor(Color.RED);
        //g2.fillRect((int) (xPos +collision.x - display.getCamera().getXCamera()),(int) (yPos +collision.y - display.getCamera().getYCamera()) ,collision.width, collision.height);

    }

    private BufferedImage getCurrentFrame(){
        
        if(xMove < 0){
            idle = 0;
            return animationLeft.getFrame();
        }
        if(xMove > 0){
            idle = 1;
            return animationRight.getFrame();
        }
        if(jumping){
            if(idle == 0){
                return Resources.jumpLeft;
            }
            else return Resources.jumpRight;
        }
        if(yMove > 0){
            return animationResting.getFrame();
        }
        if(display.getKey().aLeft){
            idle = 0;
            return animationAttackLeft.getFrame();
        }
        if(display.getKey().aRight){
            idle = 1;
            return animationAttackRight.getFrame();
        }
        else if(idle == 0){
            return animationIdle.getFrame();
        }
        else if(idle == 1){
            return animationIdleRight.getFrame();
        }
        else{
            return animationIdle.getFrame();
        }
        
            
    }

    public void die(){

    }
        
}