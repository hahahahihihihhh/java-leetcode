package Problem;

import java.util.*;

public class T210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] map = new ArrayList[numCourses];
        Arrays.setAll(map, i -> new ArrayList<>());
        int[] ind =  new int[numCourses];
        List<Integer> ans = new ArrayList<>();
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
        while (!q.isEmpty()) {
            Integer u = q.poll();
            ans.add(u);
            for (Integer v : map[u]) {
                ind[v] --;
                if (ind[v] == 0) {
                    q.offer(v);
                }
            }
        }
        if (ans.size() == numCourses) {
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
        return new int[0];
    }

}
