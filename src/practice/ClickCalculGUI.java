package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickCalculGUI extends JFrame {
    ShowTxt st = new ShowTxt();
    CalButtonsGruop cbg = new CalButtonsGruop();

    public ClickCalculGUI() {
        setTitle("Calculater");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(st, BorderLayout.NORTH);
        c.add(cbg, BorderLayout.CENTER);
        cbg.setLayout(null);

//        pack();
        setVisible(true);
    }
    class ShowTxt extends JPanel {
        private JTextField display;
        public ShowTxt() {
            display = new JTextField(35);
            display.setText("0.0");
            add(display);
        }
    }
    class CalButtonsGruop extends JPanel implements ActionListener {
        private JButton[] buttons = new JButton[25];
        private String[] label =
                {"<x=", "", "", "C", "CE",
                "1", "2", "3","+", "%",
                "4", "5", "6", "-", "1/x",
                "7", "8", "9", "X", "!",
                "+/-", "0", ".", "/", "="};

        public CalButtonsGruop() {
            setLayout(new GridLayout(5, 5, 3, 3));

            for (int i = 0 ; i < buttons.length ; i++) {
                buttons[i] = new JButton(label[i]);
                add(buttons[i]);
                buttons[i].addActionListener(this);

                if (i % 5 >= 3)
                    buttons[i].setForeground(Color.red);
                else
                    buttons[i].setForeground(Color.black);

                buttons[i].setBackground(Color.orange);
            }
        }
        public void actionPerformed (ActionEvent e) {
            Object command = e.getActionCommand();
        }
    }
}
