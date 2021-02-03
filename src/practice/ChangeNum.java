package practice;

import java.util.Stack;

//스택으로 입력한 숫자를 각 자리수로 배치.
public class ChangeNum {
    private Stack<Character> stack = new Stack<>();
    public ChangeNum() {}

    public void setExper(Stack<Character> stack1) {
        stack = stack1;
    }

    public String changeNum() {
        Character[] arrayNum = new Character[stack.size()];
        int n = stack.size();
        String str;
        for (int i  = 0 ; i < n ; i++) {
            arrayNum[i] = stack.pop();
        }
        str = String.valueOf(arrayNum);
        return str;
    }
}
