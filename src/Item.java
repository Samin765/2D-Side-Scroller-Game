import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class Item - Create an item the character can interact with
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
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

    /**
     * Create an item
     * 
     * @param display the display
     * @param image   The item's visuals
     * @param name    the name of the item
     * @param id      the item's id
     */
    public Item(Display display, BufferedImage image, String name, int id) {
        this.item = image;
        this.itemName = name;
        this.id = id;
        // this.display = display;
        this.count = 1;
        items[id] = this;
        this.bounds = new Rectangle(x, y, itemWidth, itemHeight);

    }

    /**
     * Creates an item
     * 
     * @param image The item's visuals
     * @param name  The item's name
     * @param id    The item's id
     */
    public Item(BufferedImage image, String name, int id) {
        this.item = image;
        this.itemName = name;
        this.id = id;
        this.count = 1;

        items[id] = this;
        this.bounds = new Rectangle(x, y, itemWidth, itemHeight);
    }

    /**
     * Use the item if the character makes contact with it
     */
    public void update() {
        if (world.getEntityManager().getPlayer().getCollisionBounds(0f, 0f).intersects(bounds)) {
            pickedUp = true;

        }

    }

    /**
     * Draws the item onto the frame
     * 
     * @param g2 The graphics engine
     * @param x  The item's x-position
     * @param y  The item's y-position
     */
    public void render(Graphics2D g2, int x, int y) {
        if (display == null && world == null) {
            return;
        }
        g2.drawImage(item, (int) (x - display.getCamera().getXCamera()), (int) (y - display.getCamera().getYCamera()),
                itemWidth, itemHeight, null);

    }

    /**
     * Draws the item onto the frame
     * 
     * @param g2 The graphics engine
     */
    public void render(Graphics2D g2) {
        render(g2, x, y);
    }

    /**
     * Set a new position for the item
     * 
     * @param x Item's new x-position
     * @param y Item's new y-position
     */
    public void setItemPos(int x, int y) {
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    /**
     * Creates an item
     * 
     * @param x The item's x-position
     * @param y The item's y-position
     * @return
     */
    public Item createItem(int x, int y) {
        Item i = new Item(display, item, itemName, id);
        i.setItemPos((x), y);
        return i;
    }

    /**
     * @return the number of items
     */
    public int getCount() {
        return count;
    }

    /**
     * @param display Set a new display frame
     */
    public void setDisplay(Display display) {
        this.display = display;
    }

    /**
     * @param world Set a new world location
     */
    public void setWorld(World world) {
        this.world = world;
    }
}
