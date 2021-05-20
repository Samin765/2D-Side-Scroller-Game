
public class BackgroundBlock extends WorldBlocks {

    public BackgroundBlock(int id) {
        super(Resources.alienBackgroundPlanet, id, 1280, 720);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
