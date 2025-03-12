package Problem;
import java.util.*;

public class T11 {

    public int maxArea(int[] height) {
        ArrayList<Map.Entry<Integer, Integer>> s = new ArrayList<>();
        for (int i = 0; i < height.length; i ++) {
            s.add(Map.entry(height[i], i));
        }
        s.sort((o1, o2) -> {
            return Integer.compare(o2.getKey(), o1.getKey());
        });
        int l = height.length - 1, r = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> e : s) {
            l = Math.min(l, e.getValue());
            r = Math.max(r, e.getValue());
            ans = Math.max((r - l) * e.getKey(), ans);
        }
        return ans;
    }

}
