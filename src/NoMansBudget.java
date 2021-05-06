import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;


/**
 * Class NoMansBudget - Creates a two dimensional solar system containing
 * planets orbiting around a star. The planets are clickable and if a planet is
 * clicked, the user will be transported to the planet to walk around and
 * explore in a two dimensional setting.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-04
 */
public class NoMansBudget implements Runnable {
    private Display display;
    private Thread thread;

    private boolean run = false;
    
    // Sets the buffering for each image that will be displayed 
    private BufferStrategy windowTick;

    // Sets the FPS (numbers of times render() is called in the game loop)
    static final int fps = 25;
    static final int ticks = 1000/fps;

    
    private Graphics graphic;



    public NoMansBudget() {
        this.startProgram();
    }

    public static void main(String[] args) {
        NoMansBudget program = new NoMansBudget();
    }

    // Calling this method starts the game in a new thread
    public synchronized void startProgram() {
        // do nothing if the game is already running
        if (run) {
            return;
        }

        this.thread = new Thread(this);
        this.thread.start();
    }

    // stops the game
    public synchronized void stopProgram() {
        if (!run) {
            return;
        }

        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

   

    @Override
    public void run() {
        int tickcount = 0;
        long systemStart = System.currentTimeMillis();

        // Opens the game window
        initialize();

        // Numbers of milliseconds the game has ran
        long nextTick = System.currentTimeMillis() - systemStart;   
        
        // Variable "sleepTime" dictates how long the thread should sleep until update and render is called again
        long sleepTime = 0;

        run = false;

        // The game loop. Runs until run becomes false
        while (run) {
            tickcount++;
            System.out.println(tickcount);
            update();
            render();

            nextTick += ticks;
            sleepTime = nextTick - (System.currentTimeMillis() - systemStart);

            if(sleepTime >= 0){

                // waits for x amounts of time before new iteration of the loops begins  
                try{
                    Thread.sleep(sleepTime);
                }
                catch(InterruptedException e){
                    Thread.currentThread().interrupt();  // for some reason this d
                }
                
            }
            else{

                run = false;
                // means that the hardware is to slow. Might have to lower the FPS or optimize code.
            }
           


        }


        stopProgram();
    }

    private void initialize() {
        this.display = new Display("../spaceStars.jpeg");

        // this.display = new Display(Color.CYAN);
    }

    // updates the state of the game
    private void update() {

    }

    // renders the update to the display
    private void render() {

    }
}