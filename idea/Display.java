import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Display extends Canvas implements ActionListener {
    private JFrame frame;
    private JButton button;
    private JButton button2;
    private Dimension size;

    private static String title = "No man's budget";
    static final int WIDTH = 1280;
    static final int HEIGHT = 720;

    public Display() {
        this.button = new JButton("Boton");
        this.button.setBounds(590, 310, 100, 100);
        this.button.addActionListener(this);

        this.button2 = new JButton("New Boton");
        this.button2.setBounds(400, 335, 100, 50);
        this.button2.setVisible(false);
        this.button2.addActionListener(this);

        this.frame = new JFrame(title);

        this.size = new Dimension(WIDTH, HEIGHT);
        this.setPreferredSize(size);

        this.frame.add(this.button);
        this.frame.add(this.button2);
        this.frame.add(this);
        this.frame.pack();

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setLocationRelativeTo(null);
        this.frame.setResizable(false);

        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.button) {
            this.button2.setVisible(true);
            System.out.println("Poo");
        } else {
            System.out.println("Piss");
        }
    }

    public static void main(String[] args) {
        new Display();
    }
}
