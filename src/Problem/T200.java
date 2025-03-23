package Problem;

public class T200 {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    void dfs(int x, int y, boolean[][] map) {
        if (!map[x][y]) return ;
        map[x][y] = false;
        for (int i = 0; i < 4; i ++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            dfs(nx, ny, map);
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] map = new boolean[n + 2][m + 2];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                map[i + 1][j + 1] = grid[i][j] == '1';
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (map[i][j]) {
                    dfs(i, j, map);
                    ans ++;
                }
            }
        }
        return ans;
    }

}
