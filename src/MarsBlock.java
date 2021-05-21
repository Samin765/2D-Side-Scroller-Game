
/**
 * Class MarsBlock - Creates a walkable block
 * 
 * @author Samin Chowdhury @version2021-05-21
 */
public class MarsBlock extends WorldBlocks {

    /**
     * Creates an object
     * 
     * @param id The object's id
     */
    public MarsBlock(int id) {
        super(Resources.marsBlock, id, 200, 200);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
