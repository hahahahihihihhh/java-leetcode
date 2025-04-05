package Problem;

import java.util.*;

public class T207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new ArrayList[numCourses];
        Arrays.setAll(map, i -> new ArrayList<>());
        int[] ind =  new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int u = prerequisite[0], v = prerequisite[1];
            map[v].add(u);
            ind[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
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
