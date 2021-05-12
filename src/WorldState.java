import java.awt.Graphics2D;

public abstract class WorldState {
    private static WorldState currentState = null;

    public void setState(WorldState state) {
        this.currentState = state;
    }

    public WorldState getState() {
        return this.currentState;
    }

    public abstract void update();

    public abstract void render(Graphics2D g2);
}
