package Problem;

public class T322 {

    final int INF = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++)
            dp[i] = INF;
        for (int i = 0; i < amount; i ++)
            for (int j = 0; j < coins.length; j ++)
                if (dp[i] != INF && (long) i + coins[j] <= amount)
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);

        return dp[amount] == INF ? -1 : dp[amount];
    }

}
