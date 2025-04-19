package Problem;

import java.math.*;
import java.util.*;

public class T149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 1;
        for (int i = 0; i < n; i ++) {
            Map<Map.Entry<Integer, Integer>, Integer> mp = new HashMap<>();
            for (int j = 0; j < n; j ++) {
                if (j == i) continue;
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                BigInteger bigx = BigInteger.valueOf(dx);
                BigInteger bigy = BigInteger.valueOf(dy);
                int gcd = bigx.gcd(bigy).intValue();
                dx /= gcd;
                dy /= gcd;
                if (!mp.containsKey(Map.entry(dx, dy)))
                    mp.put(Map.entry(dx, dy), 1);
                mp.put(Map.entry(dx, dy), mp.get(Map.entry(dx, dy)) + 1);
            }
            for (Integer c : mp.values()) {
                ans = Math.max(ans, c);
            }
        }
        return ans;
    }

}
