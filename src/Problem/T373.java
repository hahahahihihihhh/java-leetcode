package Problem;

import java.util.*;

public class T373 {

    int n, m;

    long check(long x, int[] a, int[] b) {
        int tk = 0;
        long ans = 0;
        for (int i = n - 1; i >= 0; i --) {
            while (tk < m && a[i] + b[tk] <= x) {
                tk ++;
            }
            ans += tk;
        }
        return ans;
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        n = nums1.length; m = nums2.length;
        long l = -Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (l + r) >> 1;
            if (check(mid, nums1, nums2) >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        long cntAll = k - check(r, nums1, nums2);
        long cnt = 0;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                if (nums1[i] + nums2[j] < l) {
                    ans.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
                } else if (nums1[i] + nums2[j] == l && cnt < cntAll) {
                    ans.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
                    cnt ++;
                } else {
                    break ;
                }
            }
        }
        return ans;
    }

}
