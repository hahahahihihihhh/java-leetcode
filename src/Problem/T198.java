package Problem;

public class T198 {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            if (i == 1) {
                dp[i] = nums[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
            }
        }
        return dp[n];
    }

}
