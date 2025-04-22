package Problem;

public class T188 {

    final int INF = 0x3f3f3f3f;

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] rangeMin = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][k + 1];
        for (int kk = 1; kk <= k; kk ++) {
            for (int i = 1; i <= n; i ++) {
                dp[i][kk] = dp[i - 1][kk];
                int mn = INF;
                for (int j = i; j >= 1; j --) {
                    mn = Math.min(mn, prices[j - 1]);
                    dp[i][kk] = Math.max(dp[i][kk], dp[j][kk - 1] + prices[i - 1] - mn);
                }
            }
        }
        return dp[n][k];
    }

}
