import java.awt.Graphics2D;

import java.awt.event.ActionEvent;

/**
 * Loads a new "World" object for Mars Initalizes the player object
 * 
 * @author Samin Chowdhury
 * @author Love Lindgren
 * @version 2021-05-20
 */
public class EndScreen extends WorldState {

  @Override
  public void update() {

  }

  @Override
  public void render(Graphics2D g2) {
    // renders the background first then renders the blocks
    g2.drawImage(Resources.endScreen, 0, 0, 1280, 800, null);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}