import java.awt.Color;
import java.awt.Graphics2D;

/**
 * Class Circle - Draws a circle on the JFrame's window
 * 
 * @author Love Lindgren
 * @version 2021-05-06
 */
public class Circle {

    /**
     * Creates a circle object
     * 
     * @param x      The position along the x-axis
     * @param y      The position along the y-axis (inverted y-axis)
     * @param radius The radius of the circle
     * @param g2     The graphics engine
     * @param color  The circle's color
     */
    public Circle(int x, int y, int radius, Graphics2D g2, Color color) {
        x -= radius;
        y -= radius;
        int diameter = radius * 2;

        // Fill the body of the planet
        g2.setColor(color);
        g2.fillOval(x, y, diameter, diameter);
    }
}
