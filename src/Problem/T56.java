package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]);
        });
        int n = intervals.length;
        int l = intervals[0][0], r = intervals[0][1];
        List<int[]> ans = new ArrayList<>();
        for (int i = 1; i < n; i ++) {
            if (intervals[i][0] > r) {
                int[] pair = new int[2];
                pair[0] = l; pair[1] = r;
                ans.add(pair);
                l = intervals[i][0]; r = intervals[i][1];
            } else {
                r = Math.max(r, intervals[i][1]);
            }
        }
        int[] pair = new int[2];
        pair[0] = l; pair[1] = r;
        ans.add(pair);
        return ans.toArray(new int[ans.size()][]);
    }

}
