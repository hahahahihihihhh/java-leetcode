package Problem;

public class T994 {

    int n, m;

    public boolean check(int[][] map) {
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (map[i][j] == 1) return false;
            }
        }
        return true;
    }

    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] map = new int[n + 2][m + 2];
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                map[i + 1][j + 1] = grid[i][j];
            }
        }
        if (check(map)) return 0;
        for (int t = 1; t < 100; t ++) {
            int[][] tmp = new int[n + 2][m + 2];
            for (int i = 1; i <= n; i ++) {
                for (int j = 1; j <= m; j ++) {
                    if (tmp[i][j] != 2) {
                        tmp[i][j] = map[i][j];
                    }
                    if (map[i][j] == 2) {
                        for (int k = 0; k < 4; k ++) {
                            int ni = i + dir[k][0], nj = j + dir[k][1];
                            if (map[ni][nj] == 1) {
                                tmp[ni][nj] = 2;
                            }
                        }
                    }
                }
            }
            map = tmp;
            if (check(map)) return t;
        }
        return -1;
    }

}
