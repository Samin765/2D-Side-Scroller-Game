import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

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

    public NoMansBudget() {
        this.start();
    }

    public static void main(String[] args) {
        NoMansBudget program = new NoMansBudget();
    }

    // Calling this method starts the game in a new thread
    public synchronized void start() {
        run = true;

        // if (run) {
        // return;
        // }

        this.thread = new Thread(this);
        this.thread.start();
    }

    // stops the game
    public synchronized void stop() {
        run = false;

        // if (!run) {
        // return;
        // }

        try {
            this.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // Opens the game window
        initialize();

        // The game loop. Runs until run becomes false
        while (run) {
            update();
            render();
        }

        stop();
    }

    private void initialize() {
        // this.display = new Display("../spaceStars.jpeg");
        this.display = new Display(Color.BLACK);

        // this.display = new Display(Color.CYAN);
    }

    // updates the position/state of the components on the display
    private void update() {
        // TODO: Update circle positions
    }

    // Draws components onto the display
    private void render() {
        BufferStrategy bs = this.display.getBufferStrategy();

        if (bs == null) {
            this.display.createBufferStrategy(1);
            return;
        }

        Graphics2D g2 = (Graphics2D) bs.getDrawGraphics();

        Circle sun = new Circle(640, 360, 50, g2, Color.YELLOW);
        Circle planet1 = new Circle(400, 200, 25, g2, Color.GREEN);
        Circle planet2 = new Circle(600, 300, 30, g2, Color.BLUE);

        g2.dispose();
        bs.show();
    }
}
