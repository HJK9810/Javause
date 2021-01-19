package practice;

import javax.swing.*;
import java.awt.*;

public class CoffeeOrderGUI extends JFrame {
    NameP N = new NameP();
    CoffeeButtons CB = new CoffeeButtons();
    MainSimulater MS = new MainSimulater();

    public CoffeeOrderGUI() {
        setTitle("Coffee Order");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(N, BorderLayout.NORTH);
        c.add(MS, BorderLayout.CENTER);
        c.add(CB, BorderLayout.SOUTH);

        setVisible(true);
    }
    class NameP extends JPanel {
        private JLabel message;
        public NameP() {
            message = new JLabel("Welcom Hot Coffee!!");
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
        }
    }
    class MainSimulater extends JPanel {
        public MainSimulater() {

        }
    }
}
