import java.awt.Color;

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
        // Opens the game window
        initialize();
        // The game loop. Runs until run becomes false
        while (run) {
            update();
            render();
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