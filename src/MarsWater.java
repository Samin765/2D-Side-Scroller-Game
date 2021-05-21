
/**
 * Class MarsWater - Creates acid on the bottom of the frame that will kill the
 * player on impact
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class MarsWater extends WorldBlocks {

    /**
     * Creates the object
     * 
     * @param id The object's id
     */
    public MarsWater(int id) {
        super(Resources.marsWater, id, 200, 200);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
