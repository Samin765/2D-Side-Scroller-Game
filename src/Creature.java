
// This is the model every creature have to be created from. Creatures are players, enemies etc.

/**
 * Creature Class - A class for living entities, capable of moving and
 * interacting with other objects
 * 
 * @author Samin Chowdhury
 * @author 2021-05-21
 */
public abstract class Creature extends Entity {
    protected float speedX;
    protected float speedY;
    protected float xMove;
    protected float yMove;
    protected float speed;
    protected float jumpSpeed;
    protected float fallingSpeed;

    public static final int DEFAULT_WIDTH = 100;
    public static final int DEFAULT_HEIGHT = 120;

    private static final float MAX_SPEED = 5f;

    /**
     * Creates a creature
     * 
     * @param world   the creature's start world location
     * @param display the display
     * @param xPos    the creature's start x-position
     * @param yPos    the creature's start y-position
     * @param width   the creature's width
     * @param height  the creature's height
     */
    protected Creature(World world, Display display, float xPos, float yPos, int width, int height) {
        super(world, display, xPos, yPos, width, height);
        this.speedX = 8;
        this.speedY = 2;
        this.speed = 8;
        this.jumpSpeed = 10;
        this.fallingSpeed = 7;

        this.xMove = 0;
        this.yMove = 0;
    }

    /**
     * Unless the creature hits a frame border or object wall, it can move in that
     * direction, horizontally and vertically
     */
    public void move() {
        if (!this.entityCollision(this.xMove, 0f)) {
            this.xMove();
        }
        if (!this.entityCollision(0f, this.yMove)) {
            this.yMove();
        }
    }

    /**
     * Moves the creature horizontally, unless it hits a border
     */
    public void xMove() {
        if (this.xMove > 0) { // going left check left side of rectangle
            int tx = (int) (this.xPos + this.xMove + this.collision.x + this.collision.width) / WorldBlocks.blockWidth;
            if (!this.collisionWithBlock(tx, (int) (this.yPos + this.collision.y) / WorldBlocks.blockHeight)
                    && !this.collisionWithBlock(tx,
                            (int) (this.yPos + this.collision.y + this.collision.height) / WorldBlocks.blockHeight)) {
                this.xPos += this.xMove;
            } else { // collission
                this.xPos = tx * WorldBlocks.blockWidth - this.collision.x - this.collision.width - 1;
            }
        } else if (this.xMove < 0) { // going right
            int tx = (int) (this.xPos + this.xMove + this.collision.x) / WorldBlocks.blockWidth;
            if (!this.collisionWithBlock(tx, (int) (this.yPos + this.collision.y) / WorldBlocks.blockHeight)
                    && !this.collisionWithBlock(tx,
                            (int) (this.yPos + this.collision.y + this.collision.height) / WorldBlocks.blockHeight)) {
                this.xPos += this.xMove;
            } else { // collission
                this.xPos = tx * WorldBlocks.blockWidth + WorldBlocks.blockWidth - this.collision.x;
            }
        }
    }

    /**
     * Moves the creature vertically, unless it hits a border
     */
    public void yMove() {
        // Move upwards checks top part of rectangle
        if (this.yMove < 0) {
            int ty = (int) (this.yPos + this.yMove + this.collision.y) / WorldBlocks.blockHeight;

            if (!this.collisionWithBlock((int) (this.xPos + this.collision.x) / WorldBlocks.blockWidth, ty)
                    && !this.collisionWithBlock(
                            (int) (this.xPos + this.collision.x + this.collision.width) / WorldBlocks.blockWidth, ty)) {
                this.yPos += this.yMove;
            } else { // collision
                this.yPos = ty * WorldBlocks.blockHeight + WorldBlocks.blockHeight - this.collision.y;
            }
        } else if (this.yMove > 0) { // go down checks bottom part of rectangle
            int ty = (int) (this.yPos + this.yMove + this.collision.y + this.collision.height)
                    / WorldBlocks.blockHeight;
            if (!this.collisionWithBlock((int) (this.xPos + this.collision.x) / WorldBlocks.blockWidth, ty)
                    && !this.collisionWithBlock(
                            (int) (this.xPos + this.collision.x + this.collision.width) / WorldBlocks.blockWidth, ty)) {
                this.yPos += this.yMove;
            } else { // collision
                this.yPos = ty * WorldBlocks.blockHeight - this.collision.y - this.collision.height - 1;
            }
        }
    }

    /**
     * Checks if the creature has collided with a world object
     * 
     * @param x the collission's x-position
     * @param y the collission's y-position
     * @return if the creature has collided with a block
     */
    protected boolean collisionWithBlock(int x, int y) {
        return this.world.getBlock(x, y).isSolid();
    }

    /**
     * Returns the creature's current movement direction along the x-axis.
     * 
     * @return Positive: right, negative: left, zero = still.
     */
    public float getXMove() {
        return this.xMove;
    }

    /**
     * Returns the creature's current movement direction along the y-axis.
     * 
     * @return Positive: down, negative: up, zero = still.
     */
    public float getYMove() {
        return this.yMove;
    }

    /**
     * Sets the creature's current movement direction along the x-axis
     * 
     * @param xMove the movement direction
     */
    public void setXMove(float xMove) {
        this.xMove = xMove;
    }

    /**
     * Sets the creature's current movement direction along the y-axis
     * 
     * @param yMove the movement direction
     */
    public void setYMove(float yMove) {
        this.yMove = yMove;
    }

    /**
     * Sets the creature's travel speed
     * 
     * @param speed The new speed
     */
    public void setSpeed(float speed) {
        this.speedX = speedX;
    }
}
