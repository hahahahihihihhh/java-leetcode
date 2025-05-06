package Problem;

import java.util.*;

public class T394 {

    public String decodeString(String s) {
        Stack<Integer> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        int n = s.length();
        StringBuilder d = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                d.append(s.charAt(i));
            } else if (s.charAt(i) == '[') {
                stk1.push(Integer.parseInt(d.toString()));
                stk2.push('[');
                d = new StringBuilder();
            } else if (s.charAt(i) == ']'){
                StringBuilder tmp = new StringBuilder();
                while (stk2.peek() != '[') {
                    tmp.append(stk2.pop());
                }
                stk2.pop();
                int num = stk1.pop();
                for (int j = 0; j < num; j ++) {
                    for (int k = tmp.length() - 1; k >= 0; k --) {
                        stk2.push(tmp.charAt(k));
                    }
                }
            } else {
                stk2.push(s.charAt(i));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!stk2.isEmpty()) {
            ans.append(stk2.pop());
        }
        return ans.reverse().toString();
    }

}
