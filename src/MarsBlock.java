
public class MarsBlock extends WorldBlocks {
    public MarsBlock(int id) {
        super(Resources.marsBlock, id, 200, 200);
    }

    public boolean isSolid() {
        return true;
    }

}
