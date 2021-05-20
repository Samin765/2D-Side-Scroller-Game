
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.Iterator;

public class EntityManager {

    private World world;
    private Display display;
    private Player player;

    private ArrayList<Entity> entites;
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {

        public int compare(Entity a, Entity b) {
            if (a.getXPos() + a.getWidth() < b.getXPos() + b.getWidth()) {
                return -1;
            }
            return 1;
        }
    };

    public EntityManager(World world, Display display, Player player) {
        this.world = world;
        this.display = display;
        this.player = player;
        entites = new ArrayList<Entity>();
        addEntity(player);

    }

    public void update() {
        int i = 0;
        Iterator<Entity> it = entites.iterator();
        while (it.hasNext()) {

            Entity entity = it.next();
            entity.update();
            i++;
            if (!entity.isAlive()) {
                it.remove();
            }
        }
        entites.sort(renderSorter);
    }

    public void render(Graphics2D g2) {
        for (Entity entity : entites) {
            entity.render(g2);
        }
    }

    public void addEntity(Entity entity) {
        entites.add(entity);
    }

    public Player getPlayer() {
        return player;
    }

    public World getWorld() {
        return world;
    }

    public Display getDisplay() {
        return display;
    }

    public ArrayList<Entity> getEntities() {
        return entites;
    }

}