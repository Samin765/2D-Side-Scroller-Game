import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;

import java.util.Iterator;

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

    public EntityManager(World world, Display display, Player player) {
        this.world = world;
        this.display = display;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(this.player);

    }

    public void update() {
        int i = 0;
        Iterator<Entity> it = entities.iterator();
        while (it.hasNext()) {

            Entity entity = it.next();
            entity.update();
            i++;
            if (!entity.isAlive()) {
                it.remove();
            }
        }
        entities.sort(renderSorter);
    }

    public void render(Graphics2D g2) {
        for (Entity entity : entities) {
            entity.render(g2);
        }
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Player getPlayer() {
        return this.player;
    }

    public World getWorld() {
        return this.world;
    }

    public Display getDisplay() {
        return this.display;
    }

    public ArrayList<Entity> getEntities() {
        return this.entities;
    }
}
