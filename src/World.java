import java.awt.Graphics2D;

/**
 * Class World - Reads a .txt file with specific block ids then renders them to
 * the display
 * 
 * @author Samin chowdhury
 * @version 2021-05-15
 */
public class World {
    private Display display;

    private int width;
    private int height;
    private int xSpawn;
    private int ySpawn;
    private int[][] blocks;
    public static boolean goMars;
    public static boolean goVenus;
    public static boolean endGame;

    private EntityManager entityManager;
    private ItemManager itemManager;

    public int worldState;

    /**
     * Class World - Determines the 2d world location the player can walk and
     * interact in
     * 
     * @param display    The display
     * @param path       The image path
     * @param worldState The new worldstate
     */
    public World(Display display, String path, int worldState) {
        this.display = display;
        this.worldState = worldState;

        this.goMars = false;
        this.goVenus = false;

        switch (this.worldState) {
            case 1: // Mars
                this.entityManager = new EntityManager(this, this.display, new Player(this, this.display, 100, 1184));
                this.itemManager = new ItemManager(this, this.display);
                this.entityManager.addEntity(new Tree(this, this.display, 0, 1200)); // Blocks that gives jump boost
                this.entityManager.addEntity(new Tree(this, this.display, 3100, 1200));
                this.entityManager.addEntity(new XSpeedBlock(this, this.display, 2400, 1200));
                this.loadWorld(path);
                this.entityManager.getPlayer().setXMove(this.xSpawn);
                this.entityManager.getPlayer().setYMove(this.ySpawn);
                break;
            case 2: // Venus
                this.entityManager = new EntityManager(this, this.display, new Player(this, this.display, 100, 800));
                this.itemManager = new ItemManager(this, this.display);
                this.entityManager.addEntity(new Tree(this, this.display, 0, 1200)); // Blocks that gives jump boost
                this.entityManager.addEntity(new SuperSkullBlock(this, this.display, 3200, 1200));

                this.entityManager.addEntity(new XSpeedBlock(this, this.display, 1400, 1000));
                this.loadWorld(path);
                this.entityManager.getPlayer().setXMove(this.xSpawn);
                this.entityManager.getPlayer().setYMove(this.ySpawn);
                break;
            default:
                System.exit(0);
        }
    }

    /**
     * Update all entities, objects and items positions/states
     */
    public void update() {
        this.itemManager.update();
        this.entityManager.update();
        System.out.println(this.entityManager.getPlayer().getXPos() + "   " + this.entityManager.getPlayer().getYPos());

        if (this.entityManager.getPlayer().getXPos() == 3931) {
            this.goVenus = true;
        }
        if (this.entityManager.getPlayer().getXPos() == 3931 && this.entityManager.getPlayer().getYPos() <= 500
                && this.goVenus) {
            this.endGame = true;
        }
        if (this.entityManager.getPlayer().getYPos() >= 1380) {
            this.entityManager.getPlayer().setYPos(1184);
            this.entityManager.getPlayer().setXPos(100);
        }
    }

    /**
     * Renders all entities, objects items and images onto the frame
     * 
     * @param g2 The graphics engine
     */
    public void render(Graphics2D g2) {
        int xStart = (int) Math.max(0, this.display.getCamera().getXCamera()); // Either the first
        // block is rendered
        // or the shift on
        // camera divided by
        // the blockwidth
        // blocks are
        // rendered.
        int yStart = (int) Math.max(0, this.display.getCamera().getYCamera());
        int xEnd = (int) Math.min(this.width,
                (this.display.getCamera().getXCamera() + this.display.getWidth()) / WorldBlocks.blockWidth + 4); // you
                                                                                                                 // add
                                                                                                                 // the
        // display width
        // because u want
        // the far right
        // of the screen
        int yEnd = (int) Math.min(height, (this.display.getCamera().getYCamera()) / WorldBlocks.blockHeight + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getBlock(x, y).render(g2, (int) (x * 90 - this.display.getCamera().getXCamera()),
                        (int) (y * 90 - this.display.getCamera().getYCamera()));
            }
        }

        this.itemManager.render(g2);
        this.entityManager.render(g2);
    }

    /**
     * @param x The block's x-position
     * @param y The block's y-position
     * @return A matrix containing the blocks
     */
    public WorldBlocks getBlock(int x, int y) {
        if (x < 0 || y < 0 || x >= this.width || y >= this.height) {
            return WorldBlocks.groundBlock;
        }
        WorldBlocks block = WorldBlocks.blocks[this.blocks[x][y]];

        if (block == null) {
            return WorldBlocks.groundBlock;
        }
        return block;
    }

    /**
     * Loads the world's string file make-up
     * 
     * @param path The world's string file make-up
     */
    private void loadWorld(String path) {
        String file = readFile.readFiles(path);
        String[] tokens = file.split("\\s+"); // regex split by space
        this.width = readFile.parseInt(tokens[0]); // reads first line
        this.height = readFile.parseInt(tokens[1]); // reads second line
        this.xSpawn = readFile.parseInt(tokens[2]); // reads second row, first line
        this.ySpawn = readFile.parseInt(tokens[3]); // reads second row, second line..

        this.blocks = new int[this.width][this.height];

        for (int y = 0; y < this.height; y++) { // read the rest
            for (int x = 0; x < this.width; x++) {
                this.blocks[x][y] = readFile.parseInt(tokens[(x + y * this.width) + 4]); // stackOverFlow, fixes the
                                                                                         // offset of the
                // blocks.
            }
        }
    }

    /**
     * @return Get the world's width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * get the world's height
     * 
     * @return
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * @return the entity manager
     */
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    /**
     * @return the item manager
     */
    public ItemManager getItemManager() {
        return this.itemManager;
    }
}
