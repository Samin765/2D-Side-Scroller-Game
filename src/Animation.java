import java.awt.image.BufferedImage;

public class Animation{
    private int speed;
    private int index;
    private BufferedImage[] animation;
    private long time;
    private long timer;

    public Animation(int speed, BufferedImage[] animation){
        this.speed = speed;
        this.animation = animation;
        this.index = 0;
        this.timer = 0;
        time = System.currentTimeMillis();
    }

    public void update(){
        // Last time tick was called
        this.timer = timer + System.currentTimeMillis() - time - 20;  
        // Resets the counter
        this.time = System.currentTimeMillis(); 

        if(timer > speed){

            this.index++;
            this.time = 0;
            if(index >= animation.length){
                this.index = 0;
            }
        }


    }

    public BufferedImage getFrame(){
        return animation[index];
    }
}