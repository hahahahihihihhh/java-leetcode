package Problem;

public class T73_2 {

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean flagCol = false;
        boolean flagRow = false;
        for (int i = 0; i < n; i ++) {
            if (matrix[i][0] == 0)
                flagCol = true;
        }
        for (int j = 0; j < m; j ++) {
            if (matrix[0][j] == 0)
                flagRow = true;
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (flagCol) {
            for (int i = 0; i < n; i ++) {
                matrix[i][0] = 0;
            }
        }
        if (flagRow) {
            for (int j = 0; j < m; j ++) {
                matrix[0][j] = 0;
            }
        }
    }



}

