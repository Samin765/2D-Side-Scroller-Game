import java.awt.Color;
import java.awt.Graphics2D;

public class SolarSystem extends WorldState {
    private WorldMaps worlds;
    private Graphics2D g2;

    // add images to resources class instead
    private static final String solarSystemBackground = "../spaceStars.jpeg";

    public SolarSystem() {
        this.worlds = new WorldMaps();

        this.worlds.solarSystem(solarSystemBackground, g2);
    }

    // Update component's position
    public void update() {
        this.worlds.planet1.move(this.worlds.sun.getX(), this.worlds.sun.getY() + 50, true);
        this.worlds.planet2.move(this.worlds.sun.getX() + 60, this.worlds.sun.getY(), false);
        this.worlds.planet3.move(this.worlds.sun.getX() - 10, this.worlds.sun.getY() + 50, true);
    }

    // Draw components
    public void render(Graphics2D g2) {
        this.worlds.drawBackground(g2, Resources.solarSystemBackground);

        this.worlds.sun.draw(g2);

        this.worlds.planet1.draw(g2);
        this.worlds.planet2.draw(g2);
        this.worlds.planet3.draw(g2);
    }
}
