package Problem;

import java.util.*;

public class T909 {

    public int snakesAndLadders(int[][] board) {
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1, o2) -> o1.getKey().equals(o2.getKey()) ? Integer.compare(o1.getValue(), o2.getValue()) : Integer.compare(o1.getKey(), o2.getKey()));
        int n = board.length;
        Map<Integer, Integer> func = new HashMap<>();
        Set<Integer> vis = new HashSet<>();
        int tot = 0;
        for (int i = n - 1; i >= 0; i --) {
            if ((n - i) % 2 == 1) {
                for (int j = 0; j < n; j ++) {
                    ++ tot;
                    func.put(tot, board[i][j]);
                }
            } else {
                for (int j = n - 1; j >= 0; j --) {
                    ++ tot;
                    func.put(tot, board[i][j]);
                }
            }
        }
        int target = n * n;
        q.offer(Map.entry(0, 1));
        vis.add(1);
        while (!q.isEmpty()) {
            int step = q.peek().getKey(), pos = q.peek().getValue();
            q.poll();
            if (pos == target) {
                return step;
            }
            for (int i = 1; i <= 6 && pos + i <= target; i ++) {
                int next = pos + i;
                if (func.get(next) != -1) {
                    next = func.get(next);
                }
                if (!vis.contains(next)) {
                    q.offer(Map.entry(step + 1, next));
                    vis.add(next);
                }
            }
        }
        return -1;
    }

}
