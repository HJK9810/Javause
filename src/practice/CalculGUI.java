package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

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
            setLayout(new GridLayout(3, 1));
            setBackground(Color.black);

            display[0] = new JLabel("계산을 입력하세요.");
            display[0].setFont(new Font("맑은고딕", 0, 20));
            display[1] = new JLabel(" ");
            display[1].setFont(new Font("맑은고딕", 0, 40));
            display[2] = new JLabel(" ");
            display[2].setFont(new Font("맑은고딕", 0, 20));

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
        ChangeNum chN = new ChangeNum();
        Calculate c = new Calculate();

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
                    bt[i].setBackground(Color.orange);
                } else if (i == 12 || i == 14) {
                    bt[i].setBackground(Color.lightGray);
                } else {
                    bt[i].setBackground(Color.gray);
                }
                bt[i].addActionListener(this);
                add(bt[i]);
            }
        }

        public void actionPerformed (ActionEvent e) {
            Showtxt showtxt = new Showtxt();
            Object s = e.getSource();
            String command = e.getActionCommand();
            Stack<Character> stack = new Stack<>();
            String[] num = new String[2];
            String operater = null;
            String n = null;

            if (s.equals("C")) {

            } else if (s.equals("=")) {
                c.setCal(num[0], num[1], operater);
                n = String.valueOf(c.compute());
                showtxt.display[2].setText(n);
            } else if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
                stack.push(command.charAt(0));
                showtxt.display[1].setText(command);
            } else {
                operater = String.valueOf(command.charAt(0));
                showtxt.display[1].setText(command);
                chN.setExper(stack);

                if(num[1] == null) {
                    if (num[0] == null) {
                        num[0] = chN.changeNum();
                    } else {
                        num[1] = chN.changeNum();
                        c.setCal(num[0], num[1], operater);
                        n = String.valueOf(c.compute());
                        num[0] = n;
                        num[1] = null;
                    }
                }
            }
        }
    }
}
