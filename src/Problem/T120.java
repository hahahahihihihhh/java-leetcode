package Problem;

import java.util.*;

public class T120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) return triangle.get(0).get(0);
        int[][] dp = new int[n][n];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i ++) {
            for (int j = 0; j < triangle.get(i).size(); j ++) {
                if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j));
                } else if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i - 1).get(j) + triangle.get(i).get(j));
                } else {
                    triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j - 1) + triangle.get(i).get(j), triangle.get(i - 1).get(j) + triangle.get(i).get(j)));
                }
                if (i == n - 1)
                    ans = Math.min(ans, triangle.get(i).get(j));
            }
        }
        return ans;
    }

}
