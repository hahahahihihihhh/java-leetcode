package Problem;

import java.util.*;

public class T918 {

    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int N = (n << 1);
        int[] a = new int[N];
        for (int i = 0; i < n; i ++) {
            a[i] = nums[i];
            a[i + n] = nums[i];
        }
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1, o2) -> o1.getKey() == o2.getKey() ? Integer.compare(o1.getValue(), o2.getValue()) : Integer.compare(o1.getKey(), o2.getKey()));
        int[] pre = new int[N];
        for (int i = 1; i < N; i ++) {
            pre[i] = pre[i - 1] + a[i - 1];
        }
        q.offer(Map.entry(pre[0], 0));
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < N; i ++) {
            while (q.peek().getValue() < i - n) {
                q.poll();
            }
            ans = Math.max(ans, pre[i] - q.peek().getKey());
            q.offer(Map.entry(pre[i], i));
        }
        return ans;
    }

}
