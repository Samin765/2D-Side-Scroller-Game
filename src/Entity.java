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
    protected float yPos; // Only classes that extends entity gains access to x and y

    protected Display display;
    protected Rectangle collision;
    protected World world;

    protected int width;
    protected int heigth;

    protected boolean alive;

    protected int health;

    protected Entity(World world, Display display, float xPos, float yPos, int width, int heigth) { // starting position
                                                                                                    // // of the entity
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.heigth = heigth;
        this.display = display;
        this.world = world;
        this.alive = true;
        this.health = 40;

        this.collision = new Rectangle(0, 0, this.width, this.heigth);
    }

    public void setXPos(float xPos) {
        this.xPos = xPos;
    }

    public void setYPos(float yPos) {
        this.yPos = yPos;
    }

    public float getXPos() {
        return this.xPos;
    }

    public float getYPos() {
        return this.yPos;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeigth() {
        return this.heigth;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public void getAlive(boolean alive) {
        this.alive = alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

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

    public Rectangle getCollisionBounds(float x, float y) {
        return new Rectangle((int) (this.xPos + this.collision.x + x), (int) (this.yPos + this.collision.y + y),
                this.collision.width, this.collision.height);
    }

    public void hurt(int hurt) {
        this.health -= hurt;
        if (this.health <= 0) {
            this.alive = false;
            this.die();
        }
    }

    public abstract void update();

    public abstract void render(Graphics2D g2);

    public abstract void die();
}
