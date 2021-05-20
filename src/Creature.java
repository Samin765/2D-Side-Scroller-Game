
// This is the model every creature have to be created from. Creatures are players, enemies etc.
public abstract class Creature extends Entity {
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

    protected Creature(World world, Display display, float xPos, float yPos, int width, int heigth) { // Starting point
                                                                                                      // // of the
                                                                                                      // creature
        super(world, display, xPos, yPos, width, heigth);
        this.speedX = 8;
        this.speedY = 2;
        this.speed = 8;
        this.jumpSpeed = 10;
        this.fallingSpeed = 7;

        this.xMove = 0;
        this.yMove = 0;
    }

    public void move() {
        if (!entityCollision(this.xMove, 0f)) {
            xMove();
        }
        if (!entityCollision(0f, this.yMove)) {
            yMove();
        }
    }

    public void xMove() {
        if (this.xMove > 0) { // going left check left side of rectangle
            int tx = (int) (this.xPos + this.xMove + this.collision.x + this.collision.width) / WorldBlocks.blockWidth;
            if (!collisionWithBlock(tx, (int) (this.yPos + this.collision.y) / WorldBlocks.blockHeigth)
                    && !collisionWithBlock(tx,
                            (int) (this.yPos + this.collision.y + this.collision.height) / WorldBlocks.blockHeigth)) {
                this.xPos += this.xMove;
            } else { // collission
                this.xPos = tx * WorldBlocks.blockWidth - this.collision.x - this.collision.width - 1;
            }
        } else if (this.xMove < 0) { // going right
            int tx = (int) (this.xPos + this.xMove + this.collision.x) / WorldBlocks.blockWidth;
            if (!collisionWithBlock(tx, (int) (this.yPos + this.collision.y) / WorldBlocks.blockHeigth)
                    && !collisionWithBlock(tx,
                            (int) (this.yPos + this.collision.y + this.collision.height) / WorldBlocks.blockHeigth)) {
                this.xPos += this.xMove;
            } else { // collission
                this.xPos = tx * WorldBlocks.blockWidth + WorldBlocks.blockWidth - this.collision.x;
            }
        }
    }

    public void yMove() {
        // Move upwards checks top part of rectangle
        if (this.yMove < 0) {
            int ty = (int) (this.yPos + this.yMove + this.collision.y) / WorldBlocks.blockHeigth;

            if (!collisionWithBlock((int) (this.xPos + this.collision.x) / WorldBlocks.blockWidth, ty)
                    && !collisionWithBlock(
                            (int) (this.xPos + this.collision.x + this.collision.width) / WorldBlocks.blockWidth, ty)) {
                this.yPos += this.yMove;
            } else { // collision
                this.yPos = ty * WorldBlocks.blockHeigth + WorldBlocks.blockHeigth - this.collision.y;
            }

        } else if (this.yMove > 0) { // go down checks bottom part of rectangle
            int ty = (int) (this.yPos + this.yMove + this.collision.y + this.collision.height)
                    / WorldBlocks.blockHeigth;
            if (!collisionWithBlock((int) (this.xPos + this.collision.x) / WorldBlocks.blockWidth, ty)
                    && !collisionWithBlock(
                            (int) (this.xPos + this.collision.x + this.collision.width) / WorldBlocks.blockWidth, ty)) {
                this.yPos += this.yMove;
            } else { // collision
                this.yPos = ty * WorldBlocks.blockHeigth - this.collision.y - this.collision.height - 1;
            }
        }
    }

    protected boolean collisionWithBlock(int x, int y) {
        return this.world.getBlock(x, y).isSolid();
    }

    public float getXMove() {
        return this.xMove;
    }

    public float getYMove() {
        return this.yMove;
    }

    public void setXMove(float xMove) {
        this.xMove = xMove;
    }

    public void setYMove(float yMove) {
        this.yMove = yMove;
    }

    public void setSpeed(float speed) {
        this.speedX = speedX;
    }
}
