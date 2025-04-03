package Problem;

public class T289 {

    int[][] DIR = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    boolean check(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int live = 0;
                for (int k = 0; k < DIR.length; k ++) {
                    int x = i + DIR[k][0], y = j + DIR[k][1];
                    if (check(x, y, n, m)) {
                        live += board[x][y] & 1;
                    }
                }
                if (board[i][j] == 1 && (live == 2 || live == 3) || board[i][j] == 0 && live == 3) {
                    board[i][j] |= 1 << 1;
                }
            }
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                board[i][j] >>= 1;
            }
        }
    }

}
