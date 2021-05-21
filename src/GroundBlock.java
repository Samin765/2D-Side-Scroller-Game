
/**
 * Class GroundBlock - Creates a walkable ground
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class GroundBlock extends WorldBlocks {

    /**
     * Creates an object
     * 
     * @param id The object's id
     */
    public GroundBlock(int id) {
        super(Resources.tileSet, id, 200, 200);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
