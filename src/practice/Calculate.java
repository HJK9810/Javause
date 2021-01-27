package practice;

public class Calculate {
    private int num1, num2;
    private String org;

    public Integer Calculate(int n1, int n2, String s) {
        num1 = n1;
        num2 = n2;
        org = s;

        switch (s) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case  "*":
                return num1 * num2;
            case "/":
                if (num2 == 0) {
                    return null;
                } else {
                    return num1 / num2;
                }
            default:
                return null;
        }
    }
}
