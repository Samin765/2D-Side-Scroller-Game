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

    private int xSpeed = rand.nextInt() % 5 + 1;
    private int ySpeed = rand.nextInt() % 5 + 1;

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
        this.xPos = x;
        this.yPos = y;
        this.radius = radius;

        this.xPos -= radius;
        this.yPos -= radius;
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

    public void move() {
        this.xPos += xSpeed;
        this.yPos += ySpeed;
    }

    public int getX() {
        return this.xPos;
    }

    public int getY() {
        return this.yPos;
    }

    public static void main(String[] args) {
        // Circle sun = new Circle(640, 360, 50, g2, Color.YELLOW);
        // System.out.println(sun.getX());
        // System.out.println(sun.getY());
        // System.out.println(sun.getRadius());
    }
}
