package practice;

import javax.swing.*;
import java.awt.*;

public class OrderMenuGUI extends JFrame {
    WelcomeP wP = new WelcomeP();
    TypeP tP = new TypeP();
    ToppingP toP = new ToppingP();
    SizeP sP = new SizeP();
    OrderP oP = new OrderP();

    public OrderMenuGUI() {
        setTitle("Order Menu");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.add(wP, BorderLayout.NORTH);
        c.add(tP, BorderLayout.EAST);
        c.add(toP, BorderLayout.CENTER);
        c.add(sP, BorderLayout.WEST);
        c.add(oP, BorderLayout.SOUTH);

        setVisible(true);
    }
}
class WelcomeP extends JPanel {

    private JLabel message;
    public WelcomeP() {
        message = new JLabel("Welcome to Pizzastore");
        add(message);
    }
//    add(message);
}
class TypeP extends JPanel {

    private JRadioButton combo, potato, bulgogi;
    public TypeP() {
        setLayout(new GridLayout(3, 1));
        combo = new JRadioButton("콤보", true);
        potato = new JRadioButton("포테이토");
        bulgogi = new JRadioButton("불고기");

        ButtonGroup bg = new ButtonGroup();
        bg.add(combo);
        bg.add(potato);
        bg.add(bulgogi);

        setBorder(BorderFactory.createTitledBorder("종류"));
        add(combo);
        add(potato);
        add(bulgogi);
    }
}
class ToppingP extends JPanel {

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
}
class SizeP extends JPanel {

    private JRadioButton small, meddium, large;
    public SizeP() {
        setLayout(new GridLayout(3, 1));
        small = new JRadioButton("Small", true);
        meddium = new JRadioButton("Medium");
        large = new JRadioButton("Large");

        ButtonGroup bg = new ButtonGroup();
        bg.add(small);
        bg.add(meddium);
        bg.add(large);

        setBorder(BorderFactory.createTitledBorder("종류"));
        add(small);
        add(meddium);
        add(large);
    }
}
class OrderP extends JPanel {

    private JButton order, cancle;
    private JTextField cost;
    public OrderP() {
        order = new JButton("주문");
        cancle = new JButton("취소");

        cost = new JTextField();
        cost.setEditable(false);
        cost.setColumns(6);

        add(order);
        add(cancle);
        add(cost);
    }
}