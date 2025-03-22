package Problem;

public class T289 {

    boolean check(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public void gameOfLife(int[][] board) {
        int[][] dir = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};
        int n = board.length, m = board[0].length;
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int live = 0;
                for (int k = 0; k < 8; k ++) {
                    int x = i + dir[k][0], y = j + dir[k][1];
                    if (check(x, y, n, m)) {
                        live += board[x][y];
                    }
                }
                if (board[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        tmp[i][j] = 0;
                    } else {
                        tmp[i][j] = 1;
                    }
                } else {
                    if (live == 3) {
                        tmp[i][j] = 1;
                    } else {
                        tmp[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                board[i][j] = tmp[i][j];
            }
        }
    }

}
