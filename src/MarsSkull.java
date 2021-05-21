
/**
 * Class MarsSkull - Creates a skull object
 */
public class MarsSkull extends WorldBlocks {

    /**
     * Creates an object
     * 
     * @param id The object's id
     */
    public MarsSkull(int id) {
        super(Resources.marsSkull, id, 200, 200);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
