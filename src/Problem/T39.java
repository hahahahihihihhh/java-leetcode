package Problem;

import java.util.*;

public class T39 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    boolean[] vis;
    int n;

    void dfs(int cur, int[] candi, int sum, int tar) {
        if (sum == tar) {
            ans.add(new ArrayList<>(tmp));
            return ;
        }
        if (cur == n)
            return ;
        for (int j = 0; sum + j * candi[cur] <= tar; j ++) {
            if (j >= 1)
                tmp.add(candi[cur]);
            dfs(cur + 1, candi, sum + j * candi[cur], tar);
        }
        for (int j = 1; sum + j * candi[cur] <= tar; j ++) {
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        vis = new boolean[n];
        dfs(0, candidates, 0, target);
        return ans;
    }

}
