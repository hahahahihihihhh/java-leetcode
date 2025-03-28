package Problem;

public class T221 {

    int n, m;
    boolean check(int l, int[][] pre) {
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (i + l - 1 <= n && j + l - 1 <= m) {
                    if (pre[i + l - 1][j + l - 1] - pre[i - 1][j + l - 1] - pre[i + l - 1][j - 1] + pre[i - 1][j - 1] == l * l) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int maximalSquare(char[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int[][] pre = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + (matrix[i - 1][j - 1] - '0');
            }
        }
        int l = 0, r = Math.min(n, m);
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (check(mid, pre)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r * r;
    }

}
