import java.awt.Color;
import java.awt.Graphics2D;

import java.util.Random;

/**
 * Class Circle - Draws a circle on the JFrame's window
 * 
 * @author Love Lindgren
 * @version 2021-05-08
 */
public class Circle {
    private static Graphics2D g2;
    private static Random rand = new Random();

    private int xPos;
    private int yPos;
    private int radius;

    private double speed = rand.nextDouble() % 5 + 1;

    /**
     * Creates a circle object
     * 
     * @param xPos   The position along the x-axis
     * @param yPos   The position along the y-axis (inverted y-axis)
     * @param radius The radius of the circle
     * @param g2     The graphics engine
     * @param color  The circle's color
     */
    public Circle(int x, int y, int radius) {
        this.xPos = x - radius;
        this.yPos = y - radius;
        this.radius = radius;
    }

    /**
     * Fill the body of the circle
     * 
     * @param g2
     * @param color
     */
    public void draw(Graphics2D g2, Color color) {
        int diameter = this.radius * 2;

        g2.setColor(color);
        g2.fillOval(this.xPos, this.yPos, diameter, diameter);
    }

    /**
     * Moves circle in orbit around another circle
     * 
     * @param circle
     */
    public void move(int centerX, int centerY) {
        double xDistance = this.xPos - centerX;
        double yDistance = -(this.yPos - centerY);

        double orbitRadius = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        double theta = Math.atan2(yDistance, xDistance);
        theta += 2 * Math.PI / 360;

        this.xPos = (int) (centerX + orbitRadius * Math.cos(theta));
        this.yPos = (int) (centerY - orbitRadius * Math.sin(theta));
    }

    public int getX() {
        return this.xPos;
    }

    public int getY() {
        return this.yPos;

    }
    
}