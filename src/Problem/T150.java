package Problem;

import java.util.*;

public class T150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i ++) {
            if (tokens[i].equals("+")) {
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(a + b);
            } else if (tokens[i].equals("-")) {
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(b - a);
            } else if (tokens[i].equals("*")) {
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(a * b);
            } else if (tokens[i].equals("/")) {
                Integer a = s.pop();
                Integer b = s.pop();
                s.push(b / a);
            } else {
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        StringBuilder tmp = new StringBuilder();
        return s.pop();
    }

}
