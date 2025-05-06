package Problem;

import java.util.*;

public class T763 {

    final int N = 26;

    public List<Integer> partitionLabels(String s) {
        int[] maxPos = new int[N];
        Arrays.fill(maxPos, - 2);
        int n = s.length();
        for (int i = 0; i < n; i ++) {
            maxPos[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (l < n) {
            int max = -2;
            while (r < n && r - 1 != max) {
                max = Math.max(max, maxPos[s.charAt(r) - 'a']);
                r ++;
            }
            ans.add(r - l);
            l = r;
        }
        return ans;
    }

}
