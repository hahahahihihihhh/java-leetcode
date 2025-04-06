package Problem;

import java.util.*;

public class T77 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> lst = new ArrayList<>();

    void dfs(int n, int cur, int k, int st) {
        if (cur == k) {
            ans.add(new ArrayList<>(lst));
            return ;
        }
        for (int i = st; i <= n; i ++) {
            lst.add(i);
            dfs(n, cur + 1, k, i + 1);
            lst.remove(cur);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 0, k, 1);
        return ans;
    }

}
