package Problem;

public class T97 {

    String a, b, c;
    int[][][][] dp;

    int cal(int l1, int l2, int l3, int flag) {
        if (dp[l1][l2][l3][flag] != -1)    return dp[l1][l2][l3][flag];
        if (l3 == 0) {
            return 1;
        }
        int ans = 0;
        if (flag == 0) {
            if (l1 == 0)    return ans;
            // 从 l1 转移
            int nl1 = l1 - 1, nl3 = l3 - 1;
            for (; nl1 >= 0 && c.charAt(nl3) == a.charAt(nl1); nl1 --, nl3 --) {
                ans = Math.max(cal(nl1, l2, nl3, 1), ans);
            }
        } else {
            if (l2 == 0)    return ans;
            int nl2 = l2 - 1, nl3 = l3 - 1;
            for (; nl2 >= 0 && c.charAt(nl3) == b.charAt(nl2); nl2 --, nl3 --) {
                ans = Math.max(cal(l1, nl2, nl3, 0), ans);
            }
        }
        return dp[l1][l2][l3][flag] = ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        a = s1; b = s2; c = s3;
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        dp = new int[l1 + 1][l2 + 1][l3 + 1][2];
        for (int i = 0; i <= l1; i ++) {
            for (int j = 0; j <= l2; j ++) {
                for (int k = 0; k <= l3; k ++) {
                    dp[i][j][k][0] = dp[i][j][k][1] = -1;
                }
            }
        }
        dp[0][0][0][0] = dp[0][0][0][1] = 1;
        if (l1 + l2 != l3)  return false;
        int ans = Math.max(cal(l1, l2, l3, 0), cal(l1, l2, l3, 1));
        return ans == 1;
    }

}
