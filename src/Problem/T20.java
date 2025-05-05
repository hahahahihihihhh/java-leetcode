package Problem;

import java.util.*;

public class T20 {

    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stk.push(s.charAt(i));
            } else {
                if (!stk.isEmpty() && ((stk.peek() == '(' && s.charAt(i) == ')') || (stk.peek() == '[' && s.charAt(i) == ']') || (stk.peek() == '{' && s.charAt(i) == '}'))) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

}
