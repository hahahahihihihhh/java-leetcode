package Problem;

import java.util.*;

public class T134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int N = n * 2;
        int[] tgas = new int[N], tcos = new int[N], pre = new int[N];
        for (int i = 0; i < n; i ++) {
            tgas[i] = gas[i];
            tgas[n + i] = gas[i];
            tcos[i] = cost[i];
            tcos[n + i] = cost[i];
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1, o2) ->
            o1.getKey().equals(o2.getKey()) ? Integer.compare(o1.getValue(), o2.getValue()) : Integer.compare(o1.getKey(), o2.getKey())
        );
        pre[0] = tgas[0] - tcos[0];
        for (int i = 1; i < N; i ++) {
            pre[i] = pre[i - 1] + tgas[i] - tcos[i];
            System.out.println(i + " " + pre[i]);
        }
        for (int i = 0; i < n; i ++) {
            q.offer(Map.entry(pre[i], i));
        }
        for (int i = n - 1; i < N - 1; i ++) {
            while (q.peek().getValue() <= i - n) {
                q.poll();
            }
            if (q.peek().getKey() - (i - n < 0 ? 0 : pre[i - n]) >= 0) {
                return i - n + 1;
            }
            q.offer(Map.entry(pre[i + 1], i + 1));
        }
        return -1;
    }

}
