import java.awt.Graphics2D;

import java.awt.event.ActionEvent;

/**
 * Class Venus - A worldstate (gamestate) for the program which will feature a
 * location depicting a continuation of the planet Mars
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class Venus extends WorldState {
    private Player player;
    private World world;
    private Tree tree;
    private Display display;

    /**
     * Loads a new "World" object for Mars Initalizes the player object
     * 
     * @param display The display
     */
    public Venus(Display display) {
        this.display = display;
        this.world = new World(this.display, "../src/Resources/worlds/Venus.txt", 2);
    }

    @Override
    public void update() {
        this.world.update();
        if (World.endGame) {
            WorldState.setState(new EndScreen());
        }
    }

    @Override
    public void render(Graphics2D g2) {
        // Draw components
        g2.drawImage(Resources.venusBg1, 0, -80, 1280, 800, null); // renders the background first then renders the
                                                                   // blocks
        g2.drawImage(Resources.venusBg2, 0, -80, 1280, 800, null); // change the y cordinate if higher blocks are
                                                                   // implemented
        g2.drawImage(Resources.venusBg3, 0, -80, 1280, 800, null);
        g2.drawImage(Resources.woodbg4, 0, -80, 1280, 800, null); // renders the background first then renders the
                                                                  // blocks
        this.world.render(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
