package Problem;

import java.util.*;

public class T502 {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Map.Entry<Integer, Integer>> lst = new ArrayList<>();
        int n = profits.length;
        for (int i = 0; i < n; i ++) {
            lst.add(Map.entry(capital[i], profits[i]));
        }
        Collections.sort(lst, (o1, o2) -> o1.getKey().equals(o2.getKey()) ? Integer.compare(o1.getValue(), o2.getValue()) : Integer.compare(o1.getKey(), o2.getKey()));
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int ans = w;
        int cnt = 0;
        int tk = 0;
        while (cnt < k) {
            while (tk < n && lst.get(tk).getKey() <= ans) {
                q.offer(lst.get(tk).getValue());
                tk ++;
            }
            if (q.isEmpty())  break;
            ans += q.poll();
            cnt ++;
        }
        return ans;
    }

}
