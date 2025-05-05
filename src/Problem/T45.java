package Problem;

public class T45 {

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int r = 0;
        for (int i = 0; i < n; i ++) {
            if (i <= r) {
                if (i + nums[i] > r) {
                    int l = r + 1;
                    r = Math.min(n - 1, i + nums[i]);
                    for (int j = l; j <= r; j ++) {
                        dp[j] = dp[i] + 1;
                    }
                }
            }
        }
        return dp[n - 1];
    }

}
