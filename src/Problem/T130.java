package Problem;

public class T130 {

    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    boolean dfs0(int x, int y, boolean[][] vis, int[][] mat) {
        if (mat[x][y] == 0) {
            return false;
        }
        if (mat[x][y] == 2 || vis[x][y])  return true;
        vis[x][y] = true;
        boolean flag = true;
        for (int i = 0; i < 4; i ++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            if (!dfs0(nx, ny, vis, mat)) {
                flag = false;
            }
        }
        return flag;
    }

    void dfs(int x, int y, int[][] mat) {
        if (mat[x][y] == 2)  return ;
        mat[x][y] = 2;
        for (int i = 0; i < 4; i ++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            dfs(nx, ny, mat);
        }
    }

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] mat = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i ++) {
            for (int j =  1; j <= m; j ++) {
                mat[i][j] = board[i - 1][j - 1] == 'X' ? 2 : 1;
            }
        }
        boolean[][] vis = new boolean[n + 2][m + 2];
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                if (mat[i][j] == 1 && !vis[i][j]) {
                    if (dfs0(i, j, vis, mat)) {
                        dfs(i, j, mat);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i ++) {
            for (int j = 1; j <= m; j ++) {
                board[i - 1][j - 1] = mat[i][j] == 2 ? 'X' : 'O';
            }
        }
    }

}
