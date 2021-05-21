
/**
 * Class MarsBridge - Creates a bridge the player can walk on
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class MarsBridge extends WorldBlocks {

    /**
     * Creates an object
     * 
     * @param id The object's id
     */
    public MarsBridge(int id) {
        super(Resources.marsBridge, id, 400, 200);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
