import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

/**
 * Class KeyInput - Reads keyboard input from the user and stores them into an
 * array
 * 
 * @author Samin chowdhury
 * @author Love Lindgren
 * @version 2021-05-21
 */
public class KeyInput implements KeyListener {
    private boolean[] keys;
    public boolean up, down, right, left, jump, esc, aUp, aDown, aLeft, aRight, mKey, enterKey;
    private Display display;

    final private static long keyReleasedTimeLock = 800L;
    private static long keyReleased;

    public KeyInput(Display display) {
        this.keys = new boolean[300];
        this.display = display;
    }

    /**
     * Receive key input
     */
    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_SPACE) {
            final long currentTime = System.currentTimeMillis();

            if ((currentTime - this.keyReleased) <= this.keyReleasedTimeLock) {
                return;
            }
            this.keyReleased = System.currentTimeMillis();
        } else if (event.getKeyCode() == KeyEvent.VK_M || event.getKeyCode() == KeyEvent.VK_ENTER) {
            SolarSystem.setState(new Mars(this.display));
        }

        this.keys[event.getKeyCode()] = true;
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }

    /**
     * Stop receiving key input
     */
    @Override
    public void keyReleased(KeyEvent event) {
        this.keys[event.getKeyCode()] = false;
    }

    /**
     * Interpret key event. Player goes "up" if Up arrow or W is pressed, down if S,
     * left if A, right if D and exit if escape.
     */
    public void update() {
        this.jump = this.keys[KeyEvent.VK_W] || this.keys[KeyEvent.VK_SPACE];
        this.down = this.keys[KeyEvent.VK_S];
        this.right = this.keys[KeyEvent.VK_D];
        this.left = this.keys[KeyEvent.VK_A];
        this.esc = this.keys[KeyEvent.VK_ESCAPE];

        this.aUp = this.keys[KeyEvent.VK_UP];
        this.aDown = this.keys[KeyEvent.VK_DOWN];
        this.aLeft = this.keys[KeyEvent.VK_LEFT];
        this.aRight = this.keys[KeyEvent.VK_RIGHT];

        this.mKey = this.keys[KeyEvent.VK_M];
        this.enterKey = this.keys[KeyEvent.VK_ENTER];
    }
}
