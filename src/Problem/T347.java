package Problem;

import java.util.*;

public class T347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Queue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(cnt::get));
        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            q.offer(e.getKey());
            if (q.size() > k) {
                q.poll();
            }
        }
        int[] ans = new int[k];
        int len = 0;
        while (!q.isEmpty()) {
            ans[len ++] = q.poll();
        }
        return ans;
    }

}
