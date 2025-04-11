package Problem;

public class T74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l1 = 0, r1 = n - 1;
        while (l1 <= r1) {
            int m1 = (l1 + r1) >> 1;
            if (matrix[m1][0] > target) {
                r1 = m1 - 1;
            } else if (matrix[m1][0] < target) {
                l1 = m1 + 1;
            } else {
                return true;
            }
        }
        if (r1 < 0) return false;
        int l2 = 0, r2 = m - 1;
        while (l2 <= r2) {
            int m2 = (l2 + r2) >> 1;
            if (matrix[r1][m2] > target) {
                r2 = m2 - 1;
            } else if (matrix[r1][m2] < target) {
                l2 = m2 + 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
