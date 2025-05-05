package Problem;

import java.util.*;

public class T131 {

    List<List<String>> ans = new ArrayList<>();
    List<String> tmp = new ArrayList<>();

    boolean check(String s) {
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i ++, j --) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    void dfs(int cur, String s) {
        int n = s.length();
        if (cur == n) {
            ans.add(new ArrayList<>(tmp));
            return ;
        }
        for (int nxt = cur + 1; nxt <= n; nxt ++) {
            if (!check(s.substring(cur, nxt)))  continue ;
            tmp.add(s.substring(cur, nxt));
            dfs(nxt, s);
            tmp.remove(tmp.size() - 1);
        }
        return ;
    }

    public List<List<String>> partition(String s) {
        dfs(0, s);
        return ans;
    }

}
