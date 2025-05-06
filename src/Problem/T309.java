package Problem;

public class T309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 2];
        dp[1] = 0;
        for (int i = 2; i <= n; i ++) {
            int mn = prices[i - 1];
            dp[i] = dp[i - 1];
            for (int j = i - 2; j >= 0; j --) {
                dp[i] = Math.max(dp[i], dp[j] + prices[i - 1] - mn);
                mn = Math.min(mn, prices[j]);
            }
            dp[i] = Math.max(dp[i], prices[i - 1] - mn);
        }
        return dp[n];
    }

}
