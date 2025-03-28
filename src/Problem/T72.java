package Problem;

public class T72 {

    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        word1 = " " + word1;
        word2 = " " + word2;
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= l1; i ++)  dp[i][0] = i;
        for (int j = 1; j <= l2; j ++)  dp[0][j] = j;
        for (int i = 1; i <= l1; i ++) {
            for (int j = 1; j <= l2; j ++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                }
            }
        }
        return dp[l1][l2];
    }

}
