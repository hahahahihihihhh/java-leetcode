package Problem;

public class T63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][1] = 1;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (obstacleGrid[i - 1][j - 1] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

}
