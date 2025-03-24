package Problem;

import java.util.*;

public class T22 {

    boolean geibit(int x, int p) {
        return ((x >> p) & 1) == 1;
    }

    String gen(int x, int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            if (geibit(x, i)) {
                s.append('(');
            } else {
                s.append(')');
            }
        }
        return s.toString();
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        n <<= 1;
        for (int i = 0; i < (1 << n); i ++) {
            int cnt = 0;
            for (int j = 0; j < n; j ++) {
                if (geibit(i, j)) {
                    cnt ++;
                } else {
                    cnt --;
                }
                if (cnt < 0)    break;
            }
            if (cnt == 0) {
                ans.add(gen(i, n));
            }
        }
        return ans;
    }

}
