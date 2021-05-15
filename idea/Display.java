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

    private JButton button1;
    private JButton button2;
    private JButton button3;

    private static String title = "No man's budget";
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    public Display() {
        this.button1 = new JButton("Boton");
        this.button1.setBounds(590, 310, 100, 100);
        this.button1.addActionListener(this);

        this.button2 = new JButton("New Boton");
        this.button2.setBounds(400, 335, 100, 50);
        this.button2.setVisible(false);
        this.button2.addActionListener(this);

        this.button3 = new JButton("Last boton");
        this.button3.setBounds(590, 200, 100, 100);
        this.button3.setOpaque(false);
        this.button3.setContentAreaFilled(false);
        this.button3.setBorderPainted(false);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button1) {
            this.button2.setVisible(true);
            System.out.println("Poo");
        } else if (e.getSource() == this.button2) {
            System.out.println("Piss");
        } else {
            System.out.println("Fart");
        }
    }

    public static void main(String[] args) {
        new Display();
    }
}
