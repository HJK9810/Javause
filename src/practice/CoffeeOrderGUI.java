package practice;

import javax.swing.*;
import java.awt.*;

public class CoffeeOrderGUI extends JFrame {
    NameP N = new NameP();
    CoffeeButtons CB = new CoffeeButtons();
    MainSimulater MS = new MainSimulater();
    int cup = 10, coffee = 10, water = 10, sugar = 10, cream = 10;

    public CoffeeOrderGUI() {
        setTitle("Coffee Order");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(N, BorderLayout.NORTH);
        c.add(MS, BorderLayout.CENTER);
        MS.setLayout(null);
        c.add(CB, BorderLayout.SOUTH);

        setVisible(true);
    }
    class NameP extends JPanel {
        private JLabel message;
        public NameP() {
            message = new JLabel("Welcom Hot Coffee!!");
            message.setBackground(Color.pink);
            add(message);
        }
    }
    class CoffeeButtons extends JPanel {
        private JButton black, sugar, dabang, reset;
        public CoffeeButtons() {
            black = new JButton("Black Coffee");
            sugar = new JButton("Sugar Coffee");
            dabang = new JButton("Dabang Coffee");
            reset = new JButton("Reset");

            add(black);
            add(sugar);
            add(dabang);
            add(reset);
        }
    }
    class MainSimulater extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.lightGray);
            g.fillRect(90, (140-(12*cup)), 40, (12*cup));
            g.fillRect(160, (140-(12*coffee)), 40, (12*coffee));
            g.fillRect(230, (140-(12*water)), 40, (12*water));
            g.fillRect(300, (140-(12*sugar)), 40, (12*sugar));
            g.fillRect(370, (140-(12*cream)), 40, (12*cream));
            g.setColor(Color.black);
            g.drawRect(90, 20, 40, 120);
            g.drawRect(160, 20, 40, 120);
            g.drawRect(230, 20, 40, 120);
            g.drawRect(300, 20, 40, 120);
            g.drawRect(370, 20, 40, 120);
            g.drawString("Cup", 100, 160);
            g.drawString("Coffee", 160, 160);
            g.drawString("Water", 230, 160);
            g.drawString("Sugar", 300, 160);
            g.drawString("Cream", 370, 160);
        }
    }
}
