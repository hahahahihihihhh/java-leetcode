package Problem;

public class T240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int x = n - 1, y = 0;
        while (x >= 0 && y < m) {
            if (matrix[x][y] < target) {
                y ++;
            } else if (matrix[x][y] > target) {
                x --;
            } else {
                return true;
            }
        }
        return false;
    }

}
