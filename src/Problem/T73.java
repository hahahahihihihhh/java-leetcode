package Problem;

class T73 {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    for (int jj = 0; jj < m; jj ++) {
                        if (matrix[i][jj] != 0)
                            matrix[i][jj] = (1 << 31) + 2;
                    }
                    for (int ii = 0; ii < n; ii ++) {
                        if (matrix[ii][j] != 0)
                            matrix[ii][j] = (1 << 31) + 2;
                    }
                }
            }
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (matrix[i][j] == (1 << 31) + 2) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
