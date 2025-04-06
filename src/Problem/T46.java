package Problem;

import java.util.*;

public class T46 {

    boolean[] vis;
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();
    int n;

    void dfs(int cur, int[] nums) {
        if (cur == n) {
            ans.add(new ArrayList<>(tmp));
            return ;
        }
        for (int i = 0; i < n; i ++) {
            if (!vis[i]) {
                vis[i] = true;
                tmp.add(nums[i]);
                dfs(cur + 1, nums);
                tmp.remove(tmp.size() - 1);
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        vis = new boolean[n];
        dfs(0, nums);
        return ans;
    }

}
