package Problem;

import java.util.*;

public class T78 {

    boolean getbit(int x, int p) {
        return ((x >> p) & 1) == 1;
    }

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (getbit(i, j)) {
                    tmp.add(nums[j]);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }

}
