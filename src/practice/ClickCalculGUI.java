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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(st, BorderLayout.NORTH);
        c.add(cbg, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }
    class ShowTxt extends JPanel {
        private JTextField display;
        public ShowTxt() {
            display = new JTextField(40);
            display.setText("0.0");
            display.setEnabled(false);
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
        ShowTxt txt = new ShowTxt();
        Calculate cal = new Calculate();

        public CalButtonsGruop() {
            setLayout(new GridLayout(0, 5, 3, 3));

            for (int i = 0 ; i < buttons.length ; i++) {
                buttons[i] = new JButton(label[i]);

                if (i % 5 >= 3) {
                    buttons[i].setForeground(Color.red);
                } else {
                    buttons[i].setForeground(Color.black);
                }

                buttons[i].setBackground(Color.orange);
                add(buttons[i]);
                buttons[i].addActionListener(this);
            }
        }
        public void actionPerformed (ActionEvent e) {
            String command = e.getActionCommand();
            String[] str;
            double result;
            String oper = null;

            if (command.charAt(0) == 'C') {
                txt.display.setText("0.0");
            } else if (command.charAt(0) >= '0' && command.charAt(0) <= '9' || command.charAt(0) == '.'){
                txt.display.setText(command);
            } else if (command.charAt(0) == '='){
                str = txt.display.getText().split(oper);
                cal.setCal(str[0], str[1], oper);
                result = cal.compute();
                txt.display.setText(Double.toString(result));
            } else {
                oper = command;
            }
        }
    }
}
