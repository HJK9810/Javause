package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderMenuGUI extends JFrame{
    WelcomeP wP = new WelcomeP();
    TypeP tP = new TypeP();
    ToppingP toP = new ToppingP();
    SizeP sP = new SizeP();
    OrderP oP = new OrderP();

    private int sum, type, topping, size;

    public OrderMenuGUI() {
        setTitle("Order Menu");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(wP, BorderLayout.NORTH);
        c.add(tP, BorderLayout.WEST);
        c.add(toP, BorderLayout.CENTER);
        c.add(sP, BorderLayout.EAST);
        c.add(oP, BorderLayout.SOUTH);

        setVisible(true);
    }

    class WelcomeP extends JPanel {

        private JLabel message;
        public WelcomeP() {
            message = new JLabel("Welcome to PizzaStore");
            add(message);
        }
    }
    class TypeP extends JPanel implements ActionListener {

        private JRadioButton combo, potato, bulgogi;
        public TypeP() {
            setLayout(new GridLayout(3, 1));
            combo = new JRadioButton("콤보", true);
            combo.addActionListener(this);
            potato = new JRadioButton("포테이토");
            potato.addActionListener(this);
            bulgogi = new JRadioButton("불고기");
            bulgogi.addActionListener(this);

            ButtonGroup bg = new ButtonGroup();
            bg.add(combo);
            bg.add(potato);
            bg.add(bulgogi);

            setBorder(BorderFactory.createTitledBorder("종류"));
            add(combo);
            add(potato);
            add(bulgogi);
        }

        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(combo)) {
                type = 30000;
            } else if (e.getSource().equals(potato)) {
                type = 20000;
            } else if (e.getSource().equals(bulgogi)){
                type = 25000;
            } else {
                type = 0;
            }
        }
    }
    class ToppingP extends JPanel implements ActionListener{

        private JRadioButton pimang, cheeze, peplony, bacon;
        public ToppingP() {
            setLayout(new GridLayout(4, 1));
            pimang = new JRadioButton("피망", true);
            cheeze = new JRadioButton("치즈");
            peplony = new JRadioButton("페페로니");
            bacon = new JRadioButton("베어컨");

            ButtonGroup bg = new ButtonGroup();
            bg.add(pimang);
            bg.add(cheeze);
            bg.add(peplony);
            bg.add(bacon);

            setBorder(BorderFactory.createTitledBorder("추가 토핑"));
            add(pimang);
            add(cheeze);
            add(peplony);
            add(bacon);
        }
        public void actionPerformed(ActionEvent e) {
            topping = 0;
            if(e.getSource().equals(pimang)) {
                topping = 400;
            } else if (e.getSource().equals(cheeze)) {
                topping = 500;
            } else if (e.getSource().equals(peplony)) {
                topping = 800;
            } else if (e.getSource().equals(bacon)) {
                topping = 1000;
            }
        }
    }
    class SizeP extends JPanel implements ActionListener{

        private JRadioButton small, meddium, large;
        public SizeP() {
            setLayout(new GridLayout(3, 1));
            small = new JRadioButton("Small", true);
            small.addActionListener(this);
            meddium = new JRadioButton("Medium");
            meddium.addActionListener(this);
            large = new JRadioButton("Large");
            large.addActionListener(this);

            ButtonGroup bg = new ButtonGroup();
            bg.add(small);
            bg.add(meddium);
            bg.add(large);

            setBorder(BorderFactory.createTitledBorder("사이즈"));
            add(small);
            add(meddium);
            add(large);
        }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(meddium)) {
                size = 5000;
            } else if (e.getSource().equals(large)) {
                size = 10000;
            } else {
                size = 0;
            }
        }
    }
    class OrderP extends JPanel implements ActionListener{

        private JButton order, cancle;
        private JTextField cost;
        public OrderP() {
            order = new JButton("주문");
            order.addActionListener(this);
            cancle = new JButton("취소");
            cancle.addActionListener(this);

            cost = new JTextField();
            cost.setEditable(false);
            cost.setColumns(6);

            add(order);
            add(cancle);
            add(cost);
        }
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(order)) {
                sum = type + topping + size;
                cost.setText(" " + sum + "원");
            } else if(e.getSource().equals(cancle)) {
                type = 0;
                topping = 0;
                size = 0;
                sum = 0;
                cost.setText(" " + sum + "원");
            }
        }
    }
}
