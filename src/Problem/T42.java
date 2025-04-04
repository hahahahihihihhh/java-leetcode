package Problem;

import java.util.*;

public class T42 {

    final int MAXN = 100005;

    public int trap(int[] height) {
        int n = height.length;
        List<Integer>[] a = new ArrayList[MAXN];
        Arrays.setAll(a, i -> new ArrayList<>());
        int maxH = 0;
        for (int i = 0; i < height.length; i ++) {
            a[height[i]].add(i);
            maxH = Math.max(height[i], maxH);
        }
        int L = n - 1, R = 0;
        int cnt = 0, ans = 0;
        for (int i = maxH; i >= 0; i --) {
            if (!a[i].isEmpty()) {
                L = Math.min(L, a[i].get(0));
                R = Math.max(R, a[i].get(a[i].size() - 1));
            }
            cnt += a[i].size();
            ans += R - L  + 1 - cnt;
        }
        return ans;
    }

}
