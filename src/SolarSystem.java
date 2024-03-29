import java.awt.Graphics2D;

/**
 * Class SolarSystem - A worldstate (gamestate) for the program which will
 * feature a location depicting a solar system.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class SolarSystem extends WorldState {
    private Display display;
    private WorldMaps worlds;
    private Graphics2D g2;

    /**
     * Loads the components from the worldmap, containing circle objects
     */
    public SolarSystem() {
        this.worlds = new WorldMaps();

        this.worlds.solarSystem(g2);
    }

    @Override
    public void update() {
        this.worlds.planet1.move(this.worlds.sun.getX(), this.worlds.sun.getY() + 50, true);
        this.worlds.planet2.move(this.worlds.sun.getX() + 60, this.worlds.sun.getY(), false);
        this.worlds.planet3.move(this.worlds.sun.getX() - 10, this.worlds.sun.getY() + 50, true);
        this.worlds.planet4.move(this.worlds.sun.getX() - 35, this.worlds.sun.getY() + 50, true);
        this.worlds.planet5.move(this.worlds.sun.getX() + 30, this.worlds.sun.getY(), false);
    }

    @Override
    public void render(Graphics2D g2) {
        this.worlds.drawBackground(g2, Resources.solarSystemBackground);

        this.worlds.sun.draw(g2, Resources.sunBackground);

        this.worlds.planet1.draw(g2, Resources.planet1Background);
        this.worlds.planet2.draw(g2, Resources.planet2Background);
        this.worlds.planet3.draw(g2, Resources.planet3Background);
        this.worlds.planet4.draw(g2, Resources.planet4Background);
        this.worlds.planet5.draw(g2, Resources.planet5Background);
    }
}
