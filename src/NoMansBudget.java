import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

/**
 * Class NoMansBudget - Creates a two dimensional solar system containing
 * planets orbiting around a star. The planets are clickable and if a planet is
 * clicked, the user will be transported to the planet to walk around and
 * explore in a two dimensional setting.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-06
 */
public class NoMansBudget implements Runnable {
    private static final long serialVersionUID = 1L;
    private static boolean run = false;

    private Display display;
    private Thread thread;
    private Graphics g;

    // Sets the buffering for each image that will be displayed
    private BufferStrategy windowTick;

    // Sets the FPS (numbers of times render() is called in the game loop)
    static final int maxFPS = 30;
    static final double ticks = 1000000000 / maxFPS;

    static final String image = "../spaceStars.jpeg";

    public NoMansBudget() {
        this.start();
    }

    public static void main(String[] args) {
        NoMansBudget program = new NoMansBudget();
    }

    // Calling this method starts the game in a new thread
    public synchronized void start() {
        if (run) {
            return;
        }

        run = true;

        this.thread = new Thread(this);
        this.thread.start();
    }

    // stops the game
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

    @Override
    public void run() {
        long previousTime = System.nanoTime();
        long systemStart = System.currentTimeMillis();
        double difference = 0;
        int fps = 0;

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
                fps++;
            }

            // Every second: Reset
            if ((System.currentTimeMillis() - systemStart) > 1000) {
                systemStart += 1000;
                this.display.setNewTitle("No Man's Budget | FPS: " + fps);
                fps = 0;
            }
        }

        stop();
    }

    private void initialize() {
        // this.display = new Display("../spaceStars.jpeg");
        this.display = new Display();
    }

    // updates the position/state of the components on the display
    private void update() {
        // TODO: Update circle positions
    }

    // Draws components onto the display
    private void render() {
        BufferStrategy bs = this.display.getBufferStrategy();

        if (bs == null) {
            this.display.createBufferStrategy(3);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        // Draw components

        try {
            BufferedImage img = ImageIO.read(new File(image));
            g2.drawImage(img, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Circle sun = new Circle(640, 360, 50, g2, Color.YELLOW);
        Circle planet1 = new Circle(400, 200, 25, g2, Color.GREEN);
        Circle planet2 = new Circle(600, 300, 30, g2, Color.BLUE);

        g2.dispose();
        bs.show();
    }
}
