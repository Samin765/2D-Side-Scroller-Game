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
 * @version 2021-05-21
 */
public class NoMansBudget implements Runnable {
    private Thread thread;
    private Display display;
    private Resources resource;
    private WorldState solarSystem;
    private WorldState mars;
    private WorldState venus;

    private static final long serialVersionUID = 1L;
    private static boolean run = false;

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
        if (this.run) {
            return;
        }

        this.run = true;

        this.thread = new Thread(this);
        this.thread.start();
    }

    /**
     * Closes the threads running and stops the game
     */
    public synchronized void stop() {
        if (!this.run) {
            return;
        }

        this.run = false;

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
        this.initialize();

        // The game loop. Runs until run becomes false
        while (this.run) {
            long currentTime = System.nanoTime();

            difference += (currentTime - previousTime) / ticks;
            previousTime = currentTime;

            // Update every
            while (difference >= 1) {
                this.update();
                difference--;

                this.render();
                fpsCounter++;
            }

            // Every second: Reset
            if ((System.currentTimeMillis() - systemStart) > 1000) {
                systemStart += 1000;
                this.display.setNewTitle("No Man's Budget | FPS: " + fpsCounter);
                fpsCounter = 0;
            }
        }

        this.stop();
    }

    /**
     * Create components to be used
     */
    private void initialize() {
        this.display = new Display();
        this.resource = new Resources();
        this.solarSystem = new SolarSystem();

        // this fixed the issue of mouse clicks stopping the keylistener. Adding this to
        // the display class directly does not fix the issue for some reason
        this.display.setFocusable(false);

        // this sets the state to the game. Starts with the state "SolarSystem" if the
        // user for example clicks on a planet the state can be changed to "Mars" etc
        WorldState.setState(this.solarSystem);

        // TODO: For who this concerns, implement JButton so they are clickable
        // this.display.frame.add(WorldMaps.planet2);
        // this.display.frame.add(this.display);
        // this.display.frame.pack();
    }

    /**
     * Updates the position/state of the components on the display
     */
    private void update() {
        // Checks for user input
        this.display.getKey().update();

        if (WorldState.getState() != null) {
            WorldState.getState().update();
        }
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

        // Clears the screen of image residue
        g2.clearRect(0, 0, 1280, 720);

        if (WorldState.getState() != null) {
            WorldState.getState().render(g2);
        }

        g2.dispose();
        bs.show();
    }
}
