package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculGUI extends JFrame {
    Showtxt showtxt = new Showtxt();
    ButtonPanel buttonPanel = new ButtonPanel();
    public CalculGUI() {
        setTitle("Calculater");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(showtxt, BorderLayout.NORTH);
        c.add(buttonPanel, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    class Showtxt extends JPanel{
        private JLabel[] display = new JLabel[3];
        public Showtxt() {

            display[0] = new JLabel("계산을 입력하세요.");
            display[0].setFont(new Font("맑은고딕", 0, 20));
            display[1] = new JLabel(" ");
            display[1].setFont(new Font("맑은고딕", 0, 40));

            for (int i  = 0 ; i < display.length ; i++) {
                display[i].setBackground(Color.black);
                display[i].setForeground(Color.white);
                display[i].setHorizontalAlignment(SwingConstants.RIGHT);

                add(display[i]);
            }
        }
    }
    class ButtonPanel extends JPanel implements ActionListener {
        private JButton[] bt = new JButton[16];
        public ButtonPanel() {
            setBackground(Color.black);
            setLayout(new GridLayout(4, 4, 5, 5));

            bt[0] = new JButton("7");
            bt[1] = new JButton("8");
            bt[2] = new JButton("9");
            bt[3] = new JButton("+");

            bt[4] = new JButton("4");
            bt[5] = new JButton("5");
            bt[6] = new JButton("6");
            bt[7] = new JButton("-");

            bt[8] = new JButton("1");
            bt[9] = new JButton("2");
            bt[10] = new JButton("3");
            bt[11] = new JButton("*");

            bt[12] = new JButton("C");
            bt[13] = new JButton("0");
            bt[14] = new JButton("=");
            bt[15] = new JButton("/");

            for (int i = 0 ; i  < bt.length; i++) {
                bt[i].setFont(new Font("맑은고딕", 0, 30));
                bt[i].setForeground(Color.white);

                if (i % 4 == 3) {
                    bt[i].setBackground(Color.gray);
                } else {
                    bt[i].setBackground(Color.orange);
                }
                bt[i].addActionListener(this);
                add(bt[i]);
            }
        }
        public void actionPerformed (ActionEvent e) {

        }
    }
}
