package Problem;

public class T79 {

    boolean flag = false;
    boolean[][] vis = new boolean[10][10];
    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    String w;
    int n, m;

    void dfs(int x, int y, int cur, int len, char[][] board) {
        if (cur == len) {
            flag = true;
            return ;
        }
        if (x < 0 || x >= n || y < 0 || y >= m) return ;
        if (vis[x][y])  return ;
        if (flag)   return ;
        if (board[x][y] != w.charAt(cur)) return ;
        vis[x][y] = true;
        for (int i = 0; i < 4; i ++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            dfs(nx, ny, cur + 1, len, board);
        }
        vis[x][y] = false;
    }

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        int len = word.length();
        w = word;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (!flag) {
                    dfs(i, j, 0, len, board);
                }
            }
        }
        return flag;
    }

}
