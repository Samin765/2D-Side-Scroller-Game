import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Display extends Canvas implements ActionListener {
    private JFrame frame;
    private Dimension size;

    public Circle button1;
    public Circle button2;
    public Circle button3;

    private static String title = "No man's budget";
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    public Display() {
        this.button1 = new Circle(640, 360, 50, Color.YELLOW);
        this.button2 = new Circle(450, 360, 50, Color.GREEN);
        this.button3 = new Circle(640, 250, 50, Color.RED);

        this.button1.addActionListener(this);
        this.button2.addActionListener(this);
        this.button3.addActionListener(this);

        this.frame = new JFrame(title);

        this.size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);

        this.frame.add(this.button1);
        this.frame.add(this.button2);
        this.frame.add(this.button3);

        this.frame.add(this);
        this.frame.pack();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        this.frame.setVisible(true);
    }

    public void setNewTitle(String title) {
        this.frame.setTitle(title);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button1) {
            System.out.println("Poo");
        } else if (e.getSource() == this.button2) {
            System.out.println("Piss");
        } else {
            System.out.println("Fart");
        }
    }
}
