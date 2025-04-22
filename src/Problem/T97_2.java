package Problem;

public class T97_2 {

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (n + m != s3.length()) return false;
        s1 = " " + s1;
        s2 = " " + s2;
        s3 = " " + s3;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i ++) {
            if (s1.charAt(i) == s3.charAt(i))
                dp[i][0] = true;
            else
                break;
        }
        for (int j = 1; j <= m; j ++) {
            if (s2.charAt(j) == s3.charAt(j))
                dp[0][j] = true;
            else
                break;
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if ((dp[i - 1][j] && s3.charAt(i + j) == s1.charAt(i)) || (dp[i][j - 1] && s3.charAt(i + j) == s2.charAt(j))) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[n][m];
    }

}
