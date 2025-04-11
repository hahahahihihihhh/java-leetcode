package Problem;

public class T678 {

    public boolean checkValidString(String s) {
        int n = s.length();
        boolean[][] vis = new boolean[n + 1][n + 1];
        s = " " + s;
        vis[0][0] = true;
        for (int i = 1; i <= n; i ++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                for (int j = 0; j <= n; j ++) {
                    if (vis[i - 1][j] && j + 1 <= n) {
                        vis[i][j + 1] = true;
                    }
                }
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '*') {
                for (int j = 0; j <= n; j ++) {
                    if (vis[i - 1][j] && j - 1 >= 0) {
                        vis[i][j - 1] = true;
                    }
                }
            }
            if (s.charAt(i) == '*') {
                for (int j = 0; j <= n; j ++) {
                    if (vis[i - 1][j]) {
                        vis[i][j] = true;
                    }
                }
            }
        }
        return vis[n][0];
    }

}
