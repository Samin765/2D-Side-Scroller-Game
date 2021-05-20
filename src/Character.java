import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class Character - Creates a object that moves by keyboard inputs. The title,
 * position, size, color/image and closeability of the window is predetermined.
 * 
 * @author Love Lindgren
 * @author Samin Chowdhury
 * @version 2021-05-09
 */
public class Character extends JPanel implements ActionListener, KeyListener {
    Timer animation = new Timer(5, this);
    int xPos;
    int yPos;
    int xSpeed;
    int ySpeed;

    public Character() {
        animation.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(Graphics2D g2) {
        // super.paintComponent(g2);
        g2.setColor(Color.RED);
        g2.fillRect(xPos, yPos, 100, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (xPos < 0) {
            xSpeed = 0;
            xPos = 0;
        }
        if (xPos > 1280) {
            xSpeed = 0;
            xPos = 1280;
        }

        if (yPos < 0) {
            yPos = 0;
            ySpeed = 0;
        }

        if (yPos > 670) {
            yPos = 670;
            ySpeed = 0;
        }

        xPos = xPos + xSpeed;
        yPos = yPos + ySpeed;
        repaint(); // paints the same object but in a different location on the frame
    }

    public void keyPressed(KeyEvent event) {
        int c = event.getKeyCode(); // Returns what key is pressed

        if (c == KeyEvent.VK_LEFT) {
            xSpeed = -1; // goes left on the screen
            ySpeed = 0;
        }
        if (c == KeyEvent.VK_RIGHT) {
            xSpeed = 1; // goes left on the screen
            ySpeed = 0;
        }
        if (c == KeyEvent.VK_UP) {
            xSpeed = 0; // goes left on the screen
            ySpeed = -1;
        }

        if (c == KeyEvent.VK_DOWN) {
            xSpeed = 0; // goes left on the screen
            ySpeed = 1;
        }

    }

    public void keyTyped(KeyEvent e) {
        // maybe implement

    }

    public void keyReleased(KeyEvent e) {
        xSpeed = 0;
        ySpeed = 0;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

}