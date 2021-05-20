


public abstract class Creature extends Entity{ // This is the model every creature have to be created from. Creatures are players, enemies etc.
    protected float speedX;
    protected float speedY;
    protected float xMove;
    protected float yMove;
    protected float speed;
    protected float jumpSpeed;
    protected float fallingSpeed;


    public static final int DEFAULT_WIDTH = 100;
    public static final int DEFAULT_HEIGTH = 120;

    private static final float MAX_SPEED = 5f;

    

    protected Creature(World world, Display display, float xPos, float yPos, int width, int heigth){ // Starting point of the creature
        super(world, display ,xPos,yPos,width,heigth);
        this.speedX = 8;
        this.speedY = 2;
        this.speed = 8;
        this.jumpSpeed = 10;
        this.fallingSpeed = 7;

        this.xMove = 0;
        this.yMove = 0;
        
    

    }

    public void move(){
        if(!entityCollision(xMove, 0f)){
            xMove();
        }
        if(!entityCollision(0f, yMove)){
            yMove();
        }
     
    }

    public void xMove(){
        if(xMove > 0){  // going left check left side of rectangle
            int tx = (int) (xPos + xMove + collision.x + collision.width) / WorldBlocks.blockWidth;
            if(!collisionWithBlock(tx, (int)(yPos + collision.y )/ WorldBlocks.blockHeigth) &&
                     !collisionWithBlock(tx,(int)(yPos + collision.y + collision.height)/WorldBlocks.blockHeigth)){
                xPos += xMove;
            }
            else{
                xPos = tx * WorldBlocks.blockWidth - collision.x - collision.width - 1;
            }
            
        }
        else if(xMove < 0){  //going right
            int tx = (int) (xPos + xMove + collision.x) / WorldBlocks.blockWidth;
            if(!collisionWithBlock(tx, (int)(yPos + collision.y )/ WorldBlocks.blockHeigth) &&
                     !collisionWithBlock(tx,(int)(yPos + collision.y + collision.height)/WorldBlocks.blockHeigth)) {
                xPos += xMove;
            }
            else{
                xPos = tx * WorldBlocks.blockWidth + WorldBlocks.blockWidth - collision.x;
            }
        }
        
    
    }
    public void yMove(){
        if(yMove < 0){ // go up checks top part of rectangle
            int ty = (int) (yPos + yMove + collision.y)/WorldBlocks.blockHeigth;
    
            if(!collisionWithBlock((int)(xPos + collision.x)/WorldBlocks.blockWidth, ty) &&
                        !collisionWithBlock((int)(xPos + collision.x + collision.width)/WorldBlocks.blockWidth, ty)){
                        
                yPos += yMove;
           
            }
            else{ // collision
                yPos = ty * WorldBlocks.blockHeigth + WorldBlocks.blockHeigth -collision.y;
              
            }
    
        }
        else if(yMove > 0){ // go down checks bottom part of rectangle
            int ty = (int) (yPos + yMove + collision.y + collision.height)/WorldBlocks.blockHeigth;
    
            if(!collisionWithBlock((int)(xPos + collision.x)/WorldBlocks.blockWidth, ty) &&
                        !collisionWithBlock((int)(xPos + collision.x + collision.width)/WorldBlocks.blockWidth, ty)){
                yPos += yMove;
                
            }
            else{ // collision
                yPos = ty *WorldBlocks.blockHeigth - collision.y - collision.height - 1;
             
            }
    
        }       
        
    }
    

    protected boolean collisionWithBlock(int x, int y){
        return world.getBlock(x,y).isSolid();
                        
    }

    public float getXMove(){
        return xMove;
    }

    public float getYMove(){
        return yMove;
    }
    public void setXMove(float xMove){
        this.xMove = xMove;
    }
    public void setYMove(float yMove){
        this.yMove = yMove;
    }
    public void setSpeed(float speed){
        this.speedX = speedX;
    }


}