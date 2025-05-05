package Problem;

import java.util.*;

public class T300 {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        int ans = 0;
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j < i; j ++) {
                if (nums[j - 1] < nums[i - 1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans + 1;
    }

}
