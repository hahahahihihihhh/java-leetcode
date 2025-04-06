package Problem;

public class T52 {

    int ans = 0;

    void dfs(int cur, int n, boolean[] c, boolean[][] d) {
        if (cur == n) {
            ans ++;
            return ;
        }
        for (int i = 0; i < n; i ++) {
            if (!c[i] && !d[cur - i + n][0] && !d[cur + i][1]) {
                c[i] = true;
                d[cur - i + n][0] = true;
                d[cur + i][1] = true;
                dfs(cur + 1, n, c, d);
                d[cur + i][1] = false;
                d[cur - i + n][0] = false;
                c[i] = false;
            }
        }
    }

    public int totalNQueens(int n) {
        boolean[] c = new boolean[n];
        boolean[][] d = new boolean[n + n][2];
        dfs(0, n, c, d);
        return ans;
    }

}
