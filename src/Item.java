import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Item {
    public static Item[] items = new Item[300];
    public static Item bluePotion = new Item(Resources.bluePotion, "bluePotion", 0);
    public static Item purplePotion = new Item(Resources.purplePotion, "purplePotion", 1);
    public static Item orangePotion = new Item(Resources.orangePotion, "orangePotion", 2);

    public static int itemWidth = 50;
    public static int itemHeight = 70;
    protected boolean pickedUp = false;

    protected BufferedImage item;
    protected String itemName;
    protected final int id;

    protected int x, y, count;

    private Display display;
    private World world;

    protected Rectangle bounds;

    public Item(Display display, BufferedImage image, String name, int id) {
        this.item = image;
        this.itemName = name;
        this.id = id;
        // this.display = display;
        this.count = 1;
        items[id] = this;
        this.bounds = new Rectangle(x, y, itemWidth, itemHeight);

    }

    public Item(BufferedImage image, String name, int id) {
        this.item = image;
        this.itemName = name;
        this.id = id;
        this.count = 1;

        items[id] = this;
        this.bounds = new Rectangle(x, y, itemWidth, itemHeight);

    }

    public void update() {
        if (world.getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
            pickedUp = true;

        }

    }

    public void render(Graphics2D g2, int x, int y) {
        if (display == null && world == null) {
            return;
        }
        g2.drawImage(item, (int) (x - display.getCamera().getXCamera()), (int) (y - display.getCamera().getYCamera()),
                itemWidth, itemHeight, null);

    }

    public void render(Graphics2D g2) {
        render(g2, x, y);
    }

    public void setItemPos(int x, int y) {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    public Item createItem(int x, int y) {
        Item i = new Item(display, item, itemName, id);
        i.setItemPos((x), y);
        return i;
    }

    public int getCount() {
        return count;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}