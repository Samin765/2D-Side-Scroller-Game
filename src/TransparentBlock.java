
/**
 * Class TransparentBlock - Creates a transparent block
 */
public class TransparentBlock extends WorldBlocks {

    /**
     * Creates a transparent block
     * 
     * @param id The object's id
     */
    public TransparentBlock(int id) {
        super(Resources.transparentBlock, id, 200, 200);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
