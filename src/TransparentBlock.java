
public class TransparentBlock extends WorldBlocks {
    public TransparentBlock(int id) {
        super(Resources.transparentBlock, id, 200, 200);
    }

    public boolean isSolid() {
        return false;
    }

}
