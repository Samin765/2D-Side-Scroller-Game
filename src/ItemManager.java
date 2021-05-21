import java.awt.Graphics2D;
import java.util.ArrayList;

import java.util.Iterator;

/**
 * Class ItemManager - Stores the game's items in an iterator until used.
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class ItemManager {
    public World world;
    public Display display;
    private int interval = 0;

    public ArrayList<Item> items;

    /**
     * Creates an object
     * 
     * @param world   The item's start location
     * @param display The display
     */
    public ItemManager(World world, Display display) {
        this.world = world;
        this.display = display;
        this.items = new ArrayList<Item>();
    }

    /**
     * Update the player's ability's when a item is used
     */
    public void update() {
        Iterator<Item> it = this.items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            item.update();
            if (item.pickedUp) {
                this.interval++;
                if (item.equals(items.get(0))) {
                    System.out.println("check");
                    this.world.getEntityManager().getPlayer().jumpSpeed += 5;
                    this.world.getEntityManager().getPlayer().fallingSpeed += 0.002f;
                }
                it.remove();
            }
        }
    }

    /**
     * Draw every item onto the frame
     * 
     * @param g2 The graphics engine
     */
    public void render(Graphics2D g2) {
        for (Item item : items) {
            item.render(g2);
        }
    }

    /**
     * Add an item to the item manager
     * 
     * @param item The item to be added
     */
    public void addItem(Item item) {
        item.setWorld(this.world);
        item.setDisplay(this.display);
        this.items.add(item);
        item.count++;
    }

    /**
     * @return Get the item manager's current display
     */
    public Display getDisplay() {
        return this.display;
    }

    /**
     * @return get the current world location
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * @param id The item's id
     * @return one item object
     */
    public Item getItem(int id) {
        return this.items.get(id);
    }
}
