import java.awt.image.BufferedImage;

/**
 * Class Animation - Create movable idle animations for the player class using
 * fps
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class Animation {
    private int speed;
    private int index;
    private BufferedImage[] animation;
    private long time;
    private long timer;

    /**
     * Create an animation
     * 
     * @param speed     The animation's speed
     * @param animation A set of movement animations
     */
    public Animation(int speed, BufferedImage[] animation) {
        this.speed = speed;
        this.animation = animation;
        this.index = 0;
        this.timer = 0;
        this.time = System.currentTimeMillis();
    }

    /**
     * Update the animation frames
     */
    public void update() {
        // Last time tick was called
        this.timer = this.timer + System.currentTimeMillis() - this.time - 20;
        // Resets the counter
        this.time = System.currentTimeMillis();

        if (this.timer > this.speed) {

            this.index++;
            this.time = 0;
            if (this.index >= animation.length) {
                this.index = 0;
            }
        }
    }

    /**
     * @return The animation's current movement frame
     */
    public BufferedImage getFrame() {
        return this.animation[this.index];
    }
}
