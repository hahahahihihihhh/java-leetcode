package Problem;
import java.util.*;

class T239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.getKey(), o1.getKey()));
        int n = nums.length;
        for (int i = 0; i < k - 1; i ++) {
            q.offer(Map.entry(nums[i], i));
        }
        int[] ans = new int[n - k + 1];
        for (int i = 0; i + k - 1 < n; i ++) {
            q.offer(Map.entry(nums[i + k - 1], i + k - 1));
            while (q.peek().getValue() < i) {
                q.poll();
            }
            ans[i] = q.peek().getKey();
        }
        return ans;
    }
}
