package Problem;

public class T45 {

    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int[] dp = new int[n];
        int l, r = 0;
        for (int i = 0; i < n; i ++) {
            if (i <= r) {
                if (i + nums[i] > r) {
                    l = r + 1;
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
