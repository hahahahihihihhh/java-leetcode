package Problem;

import java.util.*;

public class T207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new ArrayList[numCourses];
        Arrays.setAll(map, i -> new ArrayList<>());
        int[] ind =  new int[numCourses];
        int n = prerequisites.length;
        for (int i = 0; i < n; i ++) {
            int u = prerequisites[i][1], v = prerequisites[i][0];
            map[v].add(u);
            ind[u] ++;
        }
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < numCourses; i ++) {
            if (ind[i] == 0) {
                q.offer(i);
            }
        }
        int cnt = 0;
        while (!q.isEmpty()) {
            Integer u = q.poll();
            cnt += 1;
            for (Integer v : map[u]) {
                ind[v] --;
                if (ind[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return cnt == numCourses;
    }

}
