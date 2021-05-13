import java.awt.Color;
import java.awt.Graphics2D;

import javax.swing.JButton;

/**
 * Class Circle - Draws a circle on the JFrame's window
 * 
 * @author Love Lindgren
 * @version 2021-05-12
 */
public class Circle extends JButton {
    private static Graphics2D g2;

    private int xPos;
    private int yPos;
    private int radius;
    private Color color;

    public Circle(int x, int y, int radius, Color color) {
        this.xPos = x - radius;
        this.yPos = y - radius;
        this.radius = radius;
        this.color = color;
    }

    public void draw(Graphics2D g2) {
        int diameter = this.radius * 2;

        g2.setColor(color);
        g2.fillOval(this.xPos, this.yPos, diameter, diameter);
    }

    public void move(int centerX, int centerY, boolean clockwise) {
        double xDistance = this.xPos - centerX;
        double yDistance = -(this.yPos - centerY);

        double orbitRadius = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));

        double theta = Math.atan2(yDistance, xDistance);
        theta += 2 * Math.PI / 360 * (clockwise ? -1 : 1);

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
