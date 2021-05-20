import java.awt.image.BufferedImage;

public class Animation {
    private int speed;
    private int index;
    private BufferedImage[] animation;
    private long time;
    private long timer;

    public Animation(int speed, BufferedImage[] animation) {
        this.speed = speed;
        this.animation = animation;
        this.index = 0;
        this.timer = 0;
        this.time = System.currentTimeMillis();
    }

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

    public BufferedImage getFrame() {
        return this.animation[this.index];
    }
}
