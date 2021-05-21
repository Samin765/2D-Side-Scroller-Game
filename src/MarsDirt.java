
/**
 * Class MarsDirt - Creates an object with the appearance of dirt
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class MarsDirt extends WorldBlocks {

    /**
     * Creates an object
     * 
     * @param id The object's id
     */
    public MarsDirt(int id) {
        super(Resources.marsDirt, id, 200, 200);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
