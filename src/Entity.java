import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class World - Abstract class for every entity in the game Sets the position
 * and dimension of every entity
 * 
 * @author Samin chowdhury
 * @version 2021-05-15
 */
public abstract class Entity {
    protected float xPos; // needs to be float so you get smooth animation
    protected float yPos;

    protected Display display;
    protected Rectangle collision;
    protected World world;

    protected int width;
    protected int height;

    protected boolean alive;

    protected int health;

    /**
     * Creates an entity
     * 
     * @param world   the game location
     * @param display the display
     * @param xPos    the entity's x-position
     * @param yPos    the entity's y-position
     * @param width   the entity's width
     * @param height  the entity's height
     */
    protected Entity(World world, Display display, float xPos, float yPos, int width, int height) { // starting position
                                                                                                    // // // of the
                                                                                                    // entity
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.display = display;
        this.world = world;
        this.alive = true;
        this.health = 40;

        this.collision = new Rectangle(0, 0, this.width, this.height);
    }

    /**
     * sets new x-position
     * 
     * @param xPos position along x-axis
     */
    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    /**
     * set new y-position
     * 
     * @param yPos position along y-axis
     */
    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the entity's x-position
     */
    public float getXPos() {
        return this.xPos;
    }

    /**
     * @return the entity's y-position
     */
    public float getYPos() {
        return this.yPos;
    }

    /**
     * Set new width for the entity
     * 
     * @param width the entity's new width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Set new height for the entity
     * 
     * @param width the entity's new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the entity's width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * @return the entity's height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return whether the entity is alive or not
     */
    public boolean isAlive() {
        return this.alive;
    }

    /**
     * @param alive gets the entity's state of life
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /**
     * Sets the entity's health/durability
     * 
     * @param health The new health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * @return The entity's health
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * 
     * @param x the entity's x-position
     * @param y the entity's y-position
     * @return if there has been a collission
     */
    public boolean entityCollision(float x, float y) {
        for (Entity entity : world.getEntityManager().getEntities()) {
            if (entity == this) {
                continue;
            }
            if (entity.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(x, y))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @param x the collision point
     * @param y the collision point
     * @return
     */
    public Rectangle getCollisionBounds(float x, float y) {
        return new Rectangle((int) (this.xPos + this.collision.x + x), (int) (this.yPos + this.collision.y + y),
                this.collision.width, this.collision.height);
    }

    /**
     * Decreases the entity's health/durability
     * 
     * @param hurt the amount of damage
     */
    public void hurt(int hurt) {
        this.health -= hurt;
        if (this.health <= 0) {
            this.alive = false;
            this.die();
        }
    }

    /**
     * Updates the entity's state/position/color etc.
     */
    public abstract void update();

    /**
     * Draws the entity onto the frame
     * 
     * @param g2 The graphics engine
     */
    public abstract void render(Graphics2D g2);

    /**
     * Kill/destroy the entity
     */
    public abstract void die();
}
