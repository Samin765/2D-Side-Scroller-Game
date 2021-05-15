import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JButton;

/**
 * Class Circle - Draws a clickable JButton in the form of a circle on the
 * JFrame's window
 * 
 * @author Love Lindgren
 * @version 2021-05-16
 */
public class Circle extends JButton {
    private static Graphics2D g2;

    private int xPos;
    private int yPos;
    private int diameter;
    private Color color;

    /**
     * Creates a circle object
     * 
     * @param xPos   The position along the x-axis
     * @param yPos   The position along the y-axis (inverted y-axis)
     * @param radius The radius of the circle
     * @param g2     The graphics engine
     * @param color  The circle's color
     */
    public Circle(int x, int y, int radius, Color color) {
        this.xPos = x - radius;
        this.yPos = y - radius;
        this.diameter = 2 * radius;
        this.color = color;

        this.setBounds(this.xPos, this.yPos, this.diameter, this.diameter);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(true);
    }

    /**
     * Fill the body of the circle
     * 
     * @param g2    The graphics engine
     * @param color The circle's color
     */
    public void draw(Graphics2D g2) {
        g2.setColor(this.color);
        g2.fillOval(this.xPos, this.yPos, this.diameter, this.diameter);
    }

    /**
     * Moves circle in orbit around another circle
     * 
     * @param centerX   Center position on the x-axis
     * @param centerY   Center position on the y-axis (inverted y-axis)
     * @param clockwise Determines the orbit's direction
     */
    public void move(int centerX, int centerY, boolean clockwise) {
        double xDistance = this.xPos - centerX;
        double yDistance = -(this.yPos - centerY);

        double orbitRadius = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        double theta = Math.atan2(yDistance, xDistance);
        theta += 2 * Math.PI / 360 * (clockwise ? -1 : 1);

        this.xPos = (int) (centerX + orbitRadius * Math.cos(theta));
        this.yPos = (int) (centerY - orbitRadius * Math.sin(theta));

        this.setBounds(this.xPos, this.yPos, this.diameter, this.diameter);
    }

    /**
     * Get the circle's position along the x-axis
     */
    public int getX() {
        return this.xPos;
    }

    /**
     * Get the circle's position along the y-axis
     */
    public int getY() {
        return this.yPos;
    }
}
