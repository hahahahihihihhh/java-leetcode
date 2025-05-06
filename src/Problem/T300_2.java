package Problem;

import java.util.*;

public class T300_2 {

    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int num : nums) {
            int pos = Collections.binarySearch(ans, num);
            int p = - pos - 1;
            if (p == ans.size()) {
                ans.add(num);
            } else if (p >= 0) {
                ans.set(p, num);
            }
        }
        return ans.size();
    }

}
