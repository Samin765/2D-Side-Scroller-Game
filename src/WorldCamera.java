/**
 * Class WorldCamera - Handles the camera movement
 * 
 * @author Samin chowdhury
 * @version 2021-05-15
 */
public class WorldCamera {
    private float xCamera; // How much the world should shift when the player moves. xCamera = 15 means
                           // that the world should shift 15 tiles to the left
    private float yCamera; // shifts up or down

    private Display display;

    /**
     * Create a WorldCamera
     * 
     * @param display Tthe display
     * @param xCamera The camera's start x-position
     * @param yCamera The camera's start y-position
     */
    public WorldCamera(Display display, float xCamera, float yCamera) {
        this.xCamera = xCamera;
        this.yCamera = yCamera;
        this.display = display;
    }

    /**
     * Move the camera
     * 
     * @param x the new x-position
     * @param y the new y-position
     */
    public void moveCamera(float x, float y) {
        this.xCamera = x;
        this.yCamera = y;
        this.stopAtCorner();
    }

    /**
     * Allign the camera along the player, centered.
     * 
     * @param player The playable character
     */
    public void followPlayer(Player player) {
        this.xCamera = player.getXPos() - this.display.WIDTH / 2 + player.getWidth() / 2; // divided by two so the
                                                                                          // player is on
        // the center of the display
        this.yCamera = player.getYPos() - this.display.HEIGHT / 2 + player.getHeight() / 2;
        this.stopAtCorner();
    }

    /**
     * Stop following the player once they reach a border and vice versa
     */
    public void stopAtCorner() {
        if (this.xCamera < 0) {
            this.xCamera = 0;
        } else if (this.xCamera > 40 * WorldBlocks.blockWidth - this.display.getWidth()) { // 40 is the width in the txt
                                                                                           // folder.
            // Can be automated but to lazy now
            this.xCamera = 40 * WorldBlocks.blockWidth - this.display.getWidth();

        }

        if (this.yCamera < 0) {
            this.yCamera = 0;
        } else if (this.yCamera > 15 * WorldBlocks.blockHeight - this.display.getHeight()) {
            this.yCamera = 15 * WorldBlocks.blockHeight - this.display.getHeight();
        }
    }

    /**
     * Set the camera's x-position
     * 
     * @param xCamera The new x-position
     */
    public void setXCamera(float xCamera) {
        this.xCamera = xCamera;
    }

    /**
     * Set the camera's y-position
     * 
     * @param xCamera The new y-position
     */
    public void setYCamera(float yCamera) {
        this.yCamera = yCamera;
    }

    /**
     * @return the camera's x-position
     */
    public float getXCamera() {
        return xCamera;
    }

    /**
     * @return the camera's y-position
     */
    public float getYCamera() {
        return yCamera;
    }
}
