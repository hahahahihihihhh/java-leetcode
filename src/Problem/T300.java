package Problem;

import java.util.*;

public class T300 {

    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int pos = Collections.binarySearch(ans, nums[i]);
            int p = - pos - 1;
            if (p == ans.size()) {
                ans.add(nums[i]);
            } else if (p >= 0) {
                ans.set(p, nums[i]);
            }
        }
        return ans.size();
    }

}
