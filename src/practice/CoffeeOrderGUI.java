package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    class CoffeeButtons extends JPanel implements ActionListener {
        private JButton black, suGar, dabang, reset;
        public CoffeeButtons() {
            black = new JButton("Black Coffee");
            black.addActionListener(this);
            suGar = new JButton("Sugar Coffee");
            suGar.addActionListener(this);
            dabang = new JButton("Dabang Coffee");
            dabang.addActionListener(this);
            reset = new JButton("Reset");
            reset.addActionListener(this);

            add(black);
            add(suGar);
            add(dabang);
            add(reset);
        }
        public void actionPerformed(ActionEvent e) {
            Object s = e.getSource();
            if (s.equals(black)) {
                if (cup > 0 && coffee > 0 && water > 0) {
                    cup--;
                    coffee--;
                    water--;
                    repaint();

                    JOptionPane.showMessageDialog(null,"블랙커피 나왔습니다.", "커피나왔습니다", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"부족한 것이 있습니다. 충전이 필요합니다.", "재료부족 경고", JOptionPane.WARNING_MESSAGE);
                }
            } else if (s.equals(suGar)) {
                if (cup > 0 && coffee > 0 && water > 0 && sugar > 0) {
                    cup--;
                    coffee--;
                    sugar--;
                    water--;
                    repaint();

                    JOptionPane.showMessageDialog(null, "설탕커피 나왔습니다.", "커피나왔습니다.", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"부족한 것이 있습니다. 충전이 필요합니다.", "재료부족 경고", JOptionPane.WARNING_MESSAGE);
                }
            } else if (s.equals(dabang)) {
                if (cup > 0 && coffee > 0 && water > 0 && sugar > 0 && cream > 0) {
                    cup--;
                    coffee--;
                    sugar--;
                    water--;
                    cream--;
                    repaint();

                    JOptionPane.showMessageDialog(null, "다방커피 나왔습니다.", "커피나왔습니다.", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null,"부족한 것이 있습니다. 충전이 필요합니다.", "재료부족 경고", JOptionPane.WARNING_MESSAGE);
                }
            } else if (s.equals(reset)) {
                cup = 10;
                coffee = 10;
                water = 10;
                sugar = 10;
                cream = 10;
                repaint();

                JOptionPane.showMessageDialog(null,"재료가 모두 충전되었습니다.", "충전완료", JOptionPane.PLAIN_MESSAGE);
            }
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
