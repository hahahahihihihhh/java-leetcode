package Problem;

import java.util.*;

public class T57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int l = newInterval[0], r = newInterval[1];
        int L = l, R = r;
        boolean flag = false;
        for (int i = 0; i < n; i ++) {
            if (intervals[i][1] < l || intervals[i][0] > r) {
                if (intervals[i][0] > r && !flag) {
                    flag = true;
                    ans.add(new int[]{L, R});
                }
                ans.add(intervals[i]);
            } else {
                L = Math.min(L, intervals[i][0]);
                R = Math.max(R, intervals[i][1]);
            }
        }
        if (!flag) {
            ans.add(new int[]{L, R});
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
