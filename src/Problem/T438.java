package Problem;
import java.util.*;

public class T438 {

    static final int LIM = 26;

    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        s = " " + s;
        int[][] pre = new int[n + 1][LIM];
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < LIM; j ++) {
                pre[i][j] = pre[i - 1][j] + (s.charAt(i) == ('a' + j) ? 1 : 0);
            }
        }
        int m = p.length();
        List<Integer> ans = new ArrayList<>();
        int[] cntp = new int[LIM];
        for (int i = 0; i < m; i ++) {
            cntp[p.charAt(i) - 'a'] ++;
            System.out.println(p.charAt(i) - 'a');
        }
        for (int i = 1; i + m - 1 <= n; i ++) {
            boolean flag = true;
            for (int j = 0; j < LIM; j ++) {
                if (cntp[j] != pre[i + m - 1][j] - pre[i - 1][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(i - 1);
            }
        }
        return ans;
    }
}