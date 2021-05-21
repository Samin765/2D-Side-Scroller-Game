import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class Character - Creates a object that moves by keyboard inputs. The title,
 * position, size, color/image and closeability of the window is predetermined.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-20
 */
public class CharacterMovement extends JPanel implements ActionListener, KeyListener {
    private Timer animation = new Timer(5, this);
    private int xPos;
    private int yPos;
    private int xSpeed;
    private int ySpeed;

    /**
     * Start the animation and set up keylistener
     */
    public CharacterMovement() {
        this.animation.start();
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
    }

    /**
     * If the character moves outside the screen, put them at the edge again.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.xPos < 0) {
            this.xPos = 0;
            this.xSpeed = 0;
        }
        if (this.xPos > 1280) {
            this.xPos = 1280;
            this.xSpeed = 0;
        }
        if (this.yPos < 0) {
            this.yPos = 0;
            this.ySpeed = 0;
        }
        if (this.yPos > 670) {
            this.yPos = 670;
            this.ySpeed = 0;
        }

        // paints the same object but in a different location on the frame
        this.xPos = this.xPos + this.xSpeed;
        this.yPos = this.yPos + this.ySpeed;
        repaint();
    }

    /**
     * Move in direction depending on the pressed button
     */
    @Override
    public void keyPressed(KeyEvent event) {
        // Returns what key is pressed
        int c = event.getKeyCode();

        // Moves left on the screen
        if (c == KeyEvent.VK_LEFT) {
            this.xSpeed = -1;
            this.ySpeed = 0;
        }
        // Moves right on the screen
        if (c == KeyEvent.VK_RIGHT) {
            this.xSpeed = 1;
            this.ySpeed = 0;
        }
        // goes up on the screen
        if (c == KeyEvent.VK_UP) {
            this.xSpeed = 0;
            this.ySpeed = -1;
        }
        // goes down on the screen
        if (c == KeyEvent.VK_DOWN) {
            this.xSpeed = 0;
            this.ySpeed = 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // maybe implement
    }

    /**
     * Stop moving
     */
    @Override
    public void keyReleased(KeyEvent e) {
        this.xSpeed = 0;
        this.ySpeed = 0;
    }

    /**
     * get the character's current x-position
     */
    public int getX() {
        return this.xPos;
    }

    /**
     * get the character's current y-position
     */
    public int getY() {
        return this.yPos;
    }
}