
/**
 * Class MarsGround - Creates an object that acts as a walkable structure for
 * the playyer
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class MarsGround extends WorldBlocks {

    /**
     * Creates an object
     * 
     * @param id The object's id
     */
    public MarsGround(int id) {
        super(Resources.marsGround, id, 200, 200);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
