package Problem;

import java.util.*;

public class T6 {

    final int MAXN = 1005;
    public String convert(String s, int numRows) {
        char[][] str = new char[numRows][MAXN];
        if (numRows == 1)   return s;
        int n = s.length();
        boolean flag = true;
        int px = 0, py = 0;
        for (int i = 0; i < n; i ++) {
            str[px][py] = s.charAt(i);
            if (flag) {
                if (px == numRows - 1) {
                    px --;
                    py ++;
                    flag = false;
                } else {
                    px ++;
                }
            } else {
                if (px == 0) {
                    px ++;
                    flag = true;
                } else {
                    px --;
                    py ++;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i ++) {
            for (int j = 0; j < MAXN; j ++) {
                if (str[i][j] != 0) {
                    ans.append(str[i][j]);
                }
            }
        }
        return ans.toString();
    }

}
