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

    public WorldCamera(Display display, float xCamera, float yCamera) {
        this.xCamera = xCamera;
        this.yCamera = yCamera;
        this.display = display;
    }

    public void moveCamera(float x, float y) {
        this.xCamera = x;
        this.yCamera = y;
        stopAtCorner();
    }

    public void followPlayer(Player player) {
        xCamera = player.getXPos() - display.WIDTH / 2 + player.getWidth() / 2; // divided by two so the player is on
                                                                                // the center of the display
        yCamera = player.getYPos() - display.HEIGHT / 2 + player.getHeigth() / 2;
        stopAtCorner();
    }

    public void stopAtCorner() {
        if (xCamera < 0) {
            xCamera = 0;
        } else if (xCamera > 40 * WorldBlocks.blockWidth - display.getWidth()) { // 40 is the width in the txt folder.
                                                                                 // Can be automated but to lazy now
            xCamera = 40 * WorldBlocks.blockWidth - display.getWidth();

        }

        if (yCamera < 0) {
            yCamera = 0;
        } else if (yCamera > 15 * WorldBlocks.blockHeigth - display.getHeight()) {
            yCamera = 15 * WorldBlocks.blockHeigth - display.getHeight();
        }

    }

    public void setXCamera(float xCamera) {
        this.xCamera = xCamera;
    }

    public void setYCamera(float yCamera) {
        this.yCamera = yCamera;
    }

    public float getXCamera() {
        return xCamera;
    }

    public float getYCamera() {
        return yCamera;
    }
}