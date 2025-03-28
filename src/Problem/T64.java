package Problem;

public class T64 {

    final int INF = 0x3f3f3f3f;

    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i ++) {
            dp[i][0] = INF;
        }
        for (int j = 0; j <= m; j ++) {
            dp[0][j] = INF;
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (i == 1 && j == 1)   dp[i][j] = grid[0][0];
                else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[n][m];
    }

}
