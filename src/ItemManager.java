import java.awt.Graphics2D;
import java.util.ArrayList;

import java.util.Iterator;

public class ItemManager {
    public World world;
    public Display display;
    int interval = 0;

    public ArrayList<Item> items;

    public ItemManager(World world, Display display) {
        this.world = world;
        this.display = display;
        items = new ArrayList<Item>();

    }

    public void update() {
        Iterator<Item> it = items.iterator();
        while (it.hasNext()) {
            Item item = it.next();
            item.update();
            if (item.pickedUp) {
                interval++;
                if (item.equals(items.get(0))) {
                    System.out.println("check");
                    world.getEntityManager().getPlayer().jumpSpeed += 5;
                    world.getEntityManager().getPlayer().fallingSpeed += 0.002f;

                }

                it.remove();
            }
        }

    }

    public void render(Graphics2D g2) {
        for (Item item : items) {
            item.render(g2);
        }

    }

    public void addItem(Item item) {
        item.setWorld(world);
        item.setDisplay(display);
        items.add(item);
        item.count++;
    }

    public Display getDisplay() {
        return display;
    }

    public World getWorld() {
        return world;
    }

    public Item getItem(int id) {
        return items.get(id);
    }
}