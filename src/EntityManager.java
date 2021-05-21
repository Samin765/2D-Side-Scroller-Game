import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.Iterator;

/**
 * Class EntityManager - Stores the game's entity in an iterator until used
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class EntityManager {
    private World world;
    private Display display;
    private Player player;

    private ArrayList<Entity> entities;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {

        public int compare(Entity a, Entity b) {
            if (a.getXPos() + a.getWidth() < b.getXPos() + b.getWidth()) {
                return -1;
            }
            return 1;
        }
    };

    /**
     * Creates an object
     * 
     * @param world   The etities' start location
     * @param display The display
     * @param player  The playable character
     */
    public EntityManager(World world, Display display, Player player) {
        this.world = world;
        this.display = display;
        this.player = player;
        this.entities = new ArrayList<Entity>();
        this.addEntity(this.player);
    }

    /**
     * Update the entities upon destruction or the like
     */
    public void update() {
        int i = 0;
        Iterator<Entity> it = this.entities.iterator();
        while (it.hasNext()) {
            Entity entity = it.next();
            entity.update();
            i++;

            if (!entity.isAlive()) {
                it.remove();
            }
        }
        this.entities.sort(renderSorter);
    }

    /**
     * Draw every entity onto the frame
     * 
     * @param g2 The graphics engine
     */
    public void render(Graphics2D g2) {
        for (Entity entity : this.entities) {
            entity.render(g2);
        }
    }

    /**
     * Add an entity to the item manager
     * 
     * @param entity The entity to be added
     */
    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    /**
     * @return Get the entity manager's current display
     */
    public Player getPlayer() {
        return this.player;
    }

    /**
     * @return get the current world location
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * @return the display
     */
    public Display getDisplay() {
        return this.display;
    }

    /**
     * @return An arraylist of the entities
     */
    public ArrayList<Entity> getEntities() {
        return this.entities;
    }
}
