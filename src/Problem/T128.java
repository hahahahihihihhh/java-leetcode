package Problem;
import java.util.*;

public class T128 {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, true);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        int ans = 0;
        for (int start : map.keySet()) {
            if (dp.containsKey(start))  continue;
            int cnt = 0;
            while (!dp.containsKey(start + cnt + 1) && map.get(start + cnt + 1) != null) {
                dp.put(start + cnt + 1, -1);
                cnt += 1;
            }
            if (dp.containsKey(start + cnt + 1)) {
                dp.put(start, cnt + 1 + dp.get(start + cnt + 1));
            } else {
                dp.put(start, cnt + 1);
            }
            ans = Math.max(ans ,dp.get(start));
        }
        return ans;
    }

}
