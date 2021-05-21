import java.awt.Graphics2D;

import java.awt.event.ActionEvent;

/**
 * Class Mars - A worldstate (gamestate) for the program which will feature a
 * location depicting the planet Mars.
 * 
 * @author Samin Chowdhury
 * @author Love Lindgren
 * @version 2021-05-20
 */
public class Mars extends WorldState {
    private Player player;
    private World world;
    private Tree tree;
    private Display display;

    /**
     * Loads a new "World" object for Mars Initalizes the player object
     */
    public Mars(Display display) {
        this.display = display;

        this.world = new World(this.display, "../src/Resources/worlds/marsSpawn.txt", 1);
    }

    @Override
    public void update() {
        this.world.update();
        if (World.goVenus) {
            WorldState.setState(new Venus(this.display));
        }
    }

    @Override
    public void render(Graphics2D g2) {
        // renders the background first then renders the blocks. Change the y cordinate
        // if higher blocks are
        g2.drawImage(Resources.woodbg1, 0, -80, 1280, 800, null);
        g2.drawImage(Resources.woodbg2, 0, -80, 1280, 800, null);
        g2.drawImage(Resources.woodbg3, 0, -80, 1280, 800, null);
        g2.drawImage(Resources.woodbg4, 0, -80, 1280, 800, null);
        this.world.render(g2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
