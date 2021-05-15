import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics2D;

/**
 * Class NoMansBudget - Creates a two dimensional solar system containing
 * planets orbiting around a star. The planets are clickable and if a planet is
 * clicked, the user will be transported to the planet to walk around and
 * explore in a two dimensional setting.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-13
 */
public class NoMansBudget implements Runnable {
    private static final long serialVersionUID = 1L;
    private static boolean run = false;
    static final String image = "../spaceStars.jpeg";

    private Thread thread;
    private Display display;

    public NoMansBudget() {
        this.start();
    }

    public static void main(String[] args) {
        NoMansBudget program = new NoMansBudget();
    }

    /**
     * Calling this method starts the game in a new thread
     */
    public synchronized void start() {
        if (run) {
            return;
        }

        run = true;

        this.thread = new Thread(this);
        this.thread.start();
    }

    /**
     * Closes the threads running and stops the game
     */
    public synchronized void stop() {
        if (!run) {
            return;
        }

        run = false;

        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts running the program
     */
    @Override
    public void run() {
        long previousTime = System.nanoTime();
        long systemStart = System.currentTimeMillis();

        int maxFPS = 30;
        double ticks = 1000000000 / maxFPS;

        double difference = 0;
        int fpsCounter = 0;

        // Opens the game window
        initialize();

        // The game loop. Runs until run becomes false
        while (run) {
            long currentTime = System.nanoTime();

            //
            difference += (currentTime - previousTime) / ticks;

            previousTime = currentTime;

            // Update every
            while (difference >= 1) {
                update();
                difference--;

                render();
                fpsCounter++;
            }

            // Every second: Reset
            if ((System.currentTimeMillis() - systemStart) > 1000) {
                systemStart += 1000;
                this.display.setNewTitle("No Man's Budget | FPS: " + fpsCounter);
                fpsCounter = 0;
            }
        }

        stop();
    }

    /**
     * Create components to be used
     */
    private void initialize() {
        this.display = new Display();
    }

    /**
     * Updates the position/state of the components on the display
     */
    private void update() {
        this.display.button2.move(this.display.button1.getX(), this.display.button1.getY() + 50, true);
        this.display.button3.move(this.display.button1.getX() + 60, this.display.button1.getY(), false);
    }

    /**
     * Draws the components' updated position/state onto the display
     */
    private void render() {
        BufferStrategy bs = this.display.getBufferStrategy();

        if (bs == null) {
            this.display.createBufferStrategy(3);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        this.display.button1.draw(g2);
        this.display.button2.draw(g2);
        this.display.button3.draw(g2);

        g2.dispose();
        bs.show();
    }
}
