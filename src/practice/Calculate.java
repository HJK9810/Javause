package practice;

public class Calculate {
    private double num1, num2;
    private String oper;
    public Calculate() {}

    public void setCal(String n1, String n2, String s) {
        num1 = Double.parseDouble(n1);
        num2 = Double.parseDouble(n2);
        oper = s;
    }
    double compute() {
        switch (oper) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case  "X":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return Double.NaN;
                } else {
                    return num1 / num2;
                }
            default:
                return Double.NaN;
        }
    }
}
