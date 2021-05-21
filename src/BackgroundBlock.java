
/**
 * Class BackgroundBlock - Creates a background
 * 
 * @author Samin Chowdhury
 * @version 2021-05-21
 */
public class BackgroundBlock extends WorldBlocks {

    /**
     * Create an object
     * 
     * @param id The object's id
     */
    public BackgroundBlock(int id) {
        super(Resources.alienBackgroundPlanet, id, 1280, 720);
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
