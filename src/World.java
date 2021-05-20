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
    private int heigth;
    private int xSpawn;
    private int ySpawn;
    private int[][] blocks;
    public static boolean goMars;
    public static boolean goVenus;
    public static boolean endGame;

    private EntityManager entityManager;
    private ItemManager itemManager;

    public int worldState;

    public World(Display display, String path, int worldState) {
        this.display = display;
        this.goVenus = false;
        this.worldState = worldState;

        switch (worldState) {
            case 1:
                entityManager = new EntityManager(this, display, new Player(this, display, 100, 1184));
                itemManager = new ItemManager(this, display);
                entityManager.addEntity(new Tree(this, display, 0, 1200)); // Blocks that gives jump boost
                entityManager.addEntity(new Tree(this, display, 3100, 1200));
                entityManager.addEntity(new XSpeedBlock(this, display, 2400, 1200));
                loadWorld(path);
                entityManager.getPlayer().setXMove(xSpawn);
                entityManager.getPlayer().setYMove(ySpawn);
                break;

            case 2:
                entityManager = new EntityManager(this, display, new Player(this, display, 100, 800));
                itemManager = new ItemManager(this, display);
                entityManager.addEntity(new Tree(this, display, 0, 1200)); // Blocks that gives jump boost
                entityManager.addEntity(new SuperSkullBlock(this, display, 3200, 1200));

                entityManager.addEntity(new XSpeedBlock(this, display, 1400, 1000));
                loadWorld(path);
                entityManager.getPlayer().setXMove(xSpawn);
                entityManager.getPlayer().setYMove(ySpawn);
                break;

            default:
                System.exit(0);
        }

    }

    public void update() {
        itemManager.update();
        entityManager.update();
        System.out.println(entityManager.getPlayer().getXPos() + "   " + entityManager.getPlayer().getYPos());

        if (entityManager.getPlayer().getXPos() == 3931) {
            goVenus = true;
        }
        if (entityManager.getPlayer().getXPos() == 3931 && entityManager.getPlayer().getYPos() <= 500 && goVenus) {
            endGame = true;
        }
        if (entityManager.getPlayer().getYPos() >= 1380) {
            entityManager.getPlayer().setYPos(1184);
            entityManager.getPlayer().setXPos(100);
        }

    }

    public void render(Graphics2D g2) {

        int xStart = (int) Math.max(0, display.getCamera().getXCamera()); // Either the first
                                                                          // block is rendered
                                                                          // or the shift on
                                                                          // camera divided by
                                                                          // the blockwidth
                                                                          // blocks are
                                                                          // rendered.
        int yStart = (int) Math.max(0, display.getCamera().getYCamera());
        int xEnd = (int) Math.min(width,
                (display.getCamera().getXCamera() + display.getWidth()) / WorldBlocks.blockWidth + 4); // you add the
                                                                                                       // display width
                                                                                                       // because u want
                                                                                                       // the far right
                                                                                                       // of the screen
        int yEnd = (int) Math.min(heigth, (display.getCamera().getYCamera()) / WorldBlocks.blockHeigth + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getBlock(x, y).render(g2, (int) (x * 90 - display.getCamera().getXCamera()),
                        (int) (y * 90 - display.getCamera().getYCamera()));

            }
        }
        itemManager.render(g2);
        entityManager.render(g2);

    }

    public WorldBlocks getBlock(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= heigth) {
            return WorldBlocks.groundBlock;

        }
        WorldBlocks block = WorldBlocks.blocks[blocks[x][y]];

        if (block == null) {
            return WorldBlocks.groundBlock;
        }

        return block;
    }

    private void loadWorld(String path) {
        String file = readFile.readFiles(path);
        String[] tokens = file.split("\\s+"); // regex split by space
        width = readFile.parseInt(tokens[0]); // reads first line
        heigth = readFile.parseInt(tokens[1]); // reads second line
        xSpawn = readFile.parseInt(tokens[2]); // reads second row, first line
        ySpawn = readFile.parseInt(tokens[3]); // reads second row, second line..

        blocks = new int[width][heigth];

        for (int y = 0; y < heigth; y++) { // read the rest
            for (int x = 0; x < width; x++) {
                blocks[x][y] = readFile.parseInt(tokens[(x + y * width) + 4]); // stackOverFlow, fixes the offset of the
                                                                               // blocks.
            }
        }

    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public ItemManager getItemManager() {
        return itemManager;
    }
}
