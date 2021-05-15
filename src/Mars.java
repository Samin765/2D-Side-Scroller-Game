import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class Mars - A worldstate (gamestate) for the program which will feature a
 * location depicting the planet Mars.
 * 
 * @author Samin Chowdhury
 * @version 2021-05-10
 */
public class Mars extends WorldState {

    /**
     * Loads the components from the worldmap
     */
    public Mars() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g2) {
        // Draw components
        g2.drawImage(Resources.marsBackground, 0, 0, null);
    }
}
