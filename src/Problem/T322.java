package Problem;

import java.util.*;

public class T322 {

    final int INF = 0x3f3f3f3f;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < amount; i ++)
            for (int coin : coins)
                if ((long) i + coin <= amount)
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
        return dp[amount] == INF ? -1 : dp[amount];
    }

}
