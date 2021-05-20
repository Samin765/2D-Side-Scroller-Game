import java.awt.Color;
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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
