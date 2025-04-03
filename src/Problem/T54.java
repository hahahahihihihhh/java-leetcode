package Problem;

import java.util.*;

public class T54 {

    final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int n, m;
    boolean[][] vis;

    boolean check (int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (vis[x][y]) return false;
        return true;
    }

    void dfs(int x, int y, int dir, int[][] matrix, List<Integer> ans) {
        ans.add(matrix[x][y]);
        vis[x][y] = true;
        if (ans.size() == n * m)   return ;
        int nx = x + DIR[dir][0], ny = y + DIR[dir][1];
        if (!check(nx, ny)) {
            dir ++;
            dir %= DIR.length;
            nx = x + DIR[dir][0];
            ny = y + DIR[dir][1];
        }
        dfs(nx, ny, dir, matrix, ans);
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        vis = new boolean[n][m];
        List<Integer> ans = new ArrayList<>();
        dfs(0, 0,0, matrix, ans);
        return ans;
    }

}
