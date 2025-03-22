package Problem;

public class T36 {

    final int N = 9;
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[N][N];
        boolean[][] col = new boolean[N][N];
        boolean[][][] rc = new boolean[N][N][N];
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j < N; j ++) {
                if (board[i][j] == '.')   continue ;
                int c = board[i][j] - '1';
                if (!row[i][c])    row[i][c] = true;
                else    return false;
                if (!col[j][c]) col[j][c] = true;
                else    return false;
                if (!rc[i / 3][j / 3][c])   rc[i / 3][j / 3][c] = true;
                else    return false;
            }
        }
        return true;
    }

}
