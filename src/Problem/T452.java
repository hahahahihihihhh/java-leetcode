package Problem;

import java.util.*;

public class T452 {

    public int findMinArrowShots(int[][] points) {
        List<int[]> p = new ArrayList<>();
        int n = points.length;
        for (int i = 0; i < n; i ++) {
            p.add(points[i]);
        }
        p.sort((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
        int cnt = 0;
        int l = p.get(0)[0], r = p.get(0)[1];
        for (int i = 1; i < n; i ++) {
            if (p.get(i)[0] <= r) {
                l = p.get(i)[0];
                r = Math.min(r, p.get(i)[1]);
            } else {
                cnt ++;
                l = p.get(i)[0];
                r = p.get(i)[1];
            }
        }
        return cnt + 1;
    }

}
