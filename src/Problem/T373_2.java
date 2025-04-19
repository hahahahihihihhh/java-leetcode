package Problem;

import java.util.*;

public class T373_2 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((o1, o2) -> Integer.compare(nums1[o1.getKey()] + nums2[o1.getValue()], nums1[o2.getKey()] + nums2[o2.getValue()]));
        for (int i = 0; i < n; i ++) {
            q.offer(Map.entry(i, 0));
        }
        List<List<Integer>> ans = new ArrayList<>();
        int cnt = 0;
        while (cnt < k && !q.isEmpty()) {
            Map.Entry<Integer, Integer> e = q.poll();
            List<Integer> tmp = new ArrayList<>(List.of(nums1[e.getKey()], nums2[e.getValue()]));
            if (e.getValue() + 1 < m) {
                q.offer(Map.entry(e.getKey(), e.getValue() + 1));
            }
            ans.add(tmp);
            cnt ++;
        }
        return ans;
    }

}
