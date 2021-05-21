import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

/**
 * Class Player - Creates the player object and handles keyboard inputs
 * 
 * @author Samin chowdhury
 * @version 2021-05-21
 */
public class Player extends Creature {
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

    private long lastAttack, attackLock = 800;
    private long attackCoolDown = attackLock;

    private int idle;

    /**
     * Creates a player
     * 
     * @param world   the player's start world location
     * @param display the display
     * @param xPos    the player's start x-position
     * @param yPos    the player's start y-position
     */
    public Player(World world, Display display, float xPos, float yPos) {
        super(world, display, xPos, yPos, Creature.DEFAULT_WIDTH, Creature.DEFAULT_HEIGHT);

        this.collision.x = 36;
        this.collision.y = 32;
        this.collision.height = 80;
        this.collision.width = 32;

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

    @Override
    public void update() {
        this.animationLeft.update();
        this.animationIdle.update();
        this.animationIdleRight.update();
        this.animationRight.update();
        this.animationResting.update();
        this.animationAttackLeft.update();
        this.animationAttackRight.update();

        this.getPlayerInput();
        this.move(); // Calls Creatures move() method
        this.display.getCamera().followPlayer(this); // follow this player

        this.checkAttacks();
    }

    private void checkAttacks() {
        this.attackLock += System.currentTimeMillis() - this.lastAttack;
        this.lastAttack = System.currentTimeMillis();

        if (this.attackLock < this.attackCoolDown) {
            return;
        }

        Rectangle player = this.getCollisionBounds(0f, 0f);
        Rectangle attack = new Rectangle();
        int attackSize = 20;

        attack.width = attackSize;
        attack.height = attackSize;

        if (this.display.getKey().aUp) {
            attack.x = player.x + player.width / 2 + attackSize / 2;
            attack.y = player.y - attackSize;
        } else if (this.display.getKey().aDown) {
            attack.x = player.x + player.width / 2 + attackSize / 2;
            attack.y = player.y - player.height;
        } else if (this.display.getKey().aLeft) {
            attack.x = player.x - attackSize;
            attack.y = player.y + player.height / 2 - attackSize / 2;
        } else if (this.display.getKey().aRight) {
            attack.x = player.x + player.width;
            attack.y = player.y + player.height / 2 - attackSize / 2;
        } else {
            return;
        }

        this.attackLock = 0;

        for (Entity e : this.world.getEntityManager().getEntities()) {
            if (e.equals(this)) { // dont attack yourself
                continue;
            }
            if (e.getCollisionBounds(0, 0).intersects(attack)) {
                e.hurt(20);
                return;
            }
        }
    }

    /**
     * Receive input for the player's actions from the set keybindings
     */
    private void getPlayerInput() {
        this.xMove = 0;
        this.yMove = 0;

        if (this.display.getKey().jump) {
            float oldYPos = this.yPos;

            if (!this.jumping) {
                final long currentTime = System.currentTimeMillis();
                if ((currentTime - this.keyReleased) <= this.keyReleasedTimeLock) {
                    this.yPos = oldYPos;
                    return;
                }

                this.jump();
                this.keyReleased = System.currentTimeMillis();
            }
        }

        if (this.display.getKey().down) {
            this.yMove = this.speedY;
        }
        if (this.display.getKey().right) {
            this.xMove = this.speedX;
        }
        if (this.display.getKey().left) {
            this.xMove -= this.speedX;
        }
        if (this.display.getKey().esc) {
            System.exit(1);
        }
        if (this.jumping) {
            int ty2 = (int) (this.yPos - this.jumpSpeed + this.collision.y) / WorldBlocks.blockHeight;

            if (!collisionWithBlock((int) (this.xPos + this.collision.x) / WorldBlocks.blockWidth, ty2)
                    && !collisionWithBlock(
                            (int) (this.xPos + this.collision.x + this.collision.width) / WorldBlocks.blockWidth,
                            ty2)) {

                this.yPos = this.yPos - this.jumpSpeed;
            } else { // collision
                this.jumping = false;
            }

        }
        if (!this.jumping) {
            this.gravity += 0.008f;
            int ty = (int) (this.yPos + (this.fallingSpeed + this.gravity) + this.collision.y + this.collision.height)
                    / WorldBlocks.blockHeight;
            if (!this.collisionWithBlock((int) (this.xPos + this.collision.x) / WorldBlocks.blockWidth, ty)
                    && !this.collisionWithBlock(
                            (int) (this.xPos + this.collision.x + this.collision.width) / WorldBlocks.blockWidth, ty)) {
                this.yPos += this.fallingSpeed + this.gravity;
            } else { // collision
                this.yPos = ty * WorldBlocks.blockHeight - collision.y - collision.height - 1;
                this.gravity = 0.009f;
            }
        }
    }

    /**
     * Make the character jump
     */
    public void jump() {
        this.jumping = true;
        new Thread(new thread()).start();
    }

    // this might not be the smartest thing to do but it works ..or it is the
    // smartest thing to do
    public class thread implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(jumpingTime);
                jumping = false;
            } catch (Exception e) {
                e.printStackTrace();
                new Thread(this).start();
                System.exit(0);
            }
        }
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(getCurrentFrame(), (int) (this.xPos - this.display.getCamera().getXCamera()),
                (int) (this.yPos - this.display.getCamera().getYCamera()), this.width, this.height, null);
    }

    private BufferedImage getCurrentFrame() {

        if (this.xMove < 0) {
            this.idle = 0;
            return animationLeft.getFrame();
        }
        if (this.xMove > 0) {
            this.idle = 1;
            return this.animationRight.getFrame();
        }
        if (this.jumping) {
            if (this.idle == 0) {
                return Resources.jumpLeft;
            } else
                return Resources.jumpRight;
        }
        if (this.yMove > 0) {
            return this.animationResting.getFrame();
        }
        if (this.display.getKey().aLeft) {
            this.idle = 0;
            return this.animationAttackLeft.getFrame();
        }
        if (this.display.getKey().aRight) {
            this.idle = 1;
            return this.animationAttackRight.getFrame();
        } else if (this.idle == 0) {
            return this.animationIdle.getFrame();
        } else if (this.idle == 1) {
            return this.animationIdleRight.getFrame();
        } else {
            return this.animationIdle.getFrame();
        }
    }

    @Override
    public void die() {

    }
}
