package Problem;

import java.util.*;

public class T224 {

    public int calculate(String s) {
        StringBuilder ns = new StringBuilder();
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) != ' ') {
                ns.append(s.charAt(i));
            }
        }
        s = "(" + ns + ")";
        int n = s.length();
        Stack<String> stk = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                tmp.append(s.charAt(i));
            } else {
                if (!tmp.isEmpty()) {
                    stk.push(tmp.toString());
                    tmp = new StringBuilder();
                }
                if (s.charAt(i) == ')') {
                    int ans = 0;
                    String d;
                    while (!stk.isEmpty() && !((d = stk.pop()).equals("("))) {
                        String sgn = stk.pop();
                        if (sgn.equals("-")) {
                            ans -= Integer.parseInt(d);
                        } else {
                            ans += Integer.parseInt(d);
                            if (sgn.equals("("))
                                break;
                        }
                    }
                    stk.push(Integer.toString(ans));
                } else {
                    stk.push(String.valueOf(s.charAt(i)));
                }
            }
        }
        return Integer.parseInt(stk.pop());
    }

}
