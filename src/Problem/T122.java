package Problem;

public class T122 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] pre = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i ++) {
            if (i == 0) {
                pre[i] = i;
            } else {
                if (prices[i] > prices[i - 1]) {
                    pre[i] = pre[i - 1];
                } else {
                    pre[i] = i;
                }
            }
        }
        dp[0] = 0;
        int ans = 0;
        for (int i = 1; i < n; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[pre[i]] + prices[i] - prices[pre[i]]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

}
