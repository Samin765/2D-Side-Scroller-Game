import java.awt.Graphics2D;

/**
 * Class WorldState - Abstract class used to switch between locations throughout
 * the game.
 * 
 * @author Samin Chowdhury
 * @author Love Lindgren
 * @version 2021-05-21
 */
public abstract class WorldState {
    private static WorldState currentState = null;

    /**
     * Switches the current game location the user is observing on the frame to a
     * new one
     * 
     * @param state The new world location
     */
    public static void setState(WorldState state) {
        currentState = state;
    }

    /**
     * @return The current game location
     */
    public static WorldState getState() {
        return currentState;
    }

    /**
     * Update the components' position
     */
    public abstract void update();

    /**
     * Draws all the location's components onto the frame
     * 
     * @param g2 The graphics engine
     */
    public abstract void render(Graphics2D g2);
}
