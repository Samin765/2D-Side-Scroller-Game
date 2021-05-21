
/**
 * Class WorldObject - Creates nonliveable entity object
 */
public abstract class WorldObject extends Entity {

    /**
     * Create a worldobject
     * 
     * @param world   The worldobject's start location
     * @param display the display
     * @param x       the start x-position
     * @param y       the start y-position
     * @param width   the object's width
     * @param height  the object's height
     */
    public WorldObject(World world, Display display, float x, float y, int width, int height) {
        super(world, display, x, y, width, height);
    }
}
