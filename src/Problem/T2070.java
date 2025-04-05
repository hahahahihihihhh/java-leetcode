package Problem;
import java.util.*;

public class T2070 {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        List<Map.Entry<Integer, Integer>> objects = new ArrayList<>();
        for (int[] item : items) {
            objects.add(Map.entry(item[0], item[1]));
        }
        objects.sort((o1, o2) -> o1.getKey().equals(o2.getKey()) ? Integer.compare(o1.getValue(), o2.getValue()) : Integer.compare(o1.getKey(), o2.getKey()));
        List<Map.Entry<Integer, Integer>> Q = new ArrayList<>();
        for (int i = 0; i < queries.length; i ++) {
            Q.add(Map.entry(queries[i], i));
        }
        Q.sort(Map.Entry.comparingByKey());
        int point = 0;
        int maxBeauty = 0;
        int[] ans = new int[queries.length];
        for (Map.Entry<Integer, Integer> e : Q) {
            while (point < objects.size() && objects.get(point).getKey() <= e.getKey()) {
                maxBeauty = Math.max(maxBeauty, objects.get(point).getValue());
                point++;
            }
            ans[e.getValue()] = maxBeauty;
        }
        return ans;
    }

}
