package Problem;

import java.util.*;

public class T274 {

    public int hIndex(int[] citations) {
        Integer[] tmp_citations = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp_citations, Collections.reverseOrder());
        int[] c = Arrays.stream(tmp_citations).mapToInt(Integer::intValue).toArray();
        int n = c.length;
        int ans = 0;
        for (int i = 0; i < n; i ++) {
            if (c[i] >= i + 1) {
                ans = i + 1;
            }
        }
        return ans;
    }

}
