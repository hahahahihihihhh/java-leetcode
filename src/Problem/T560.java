package Problem;
import java.util.*;

public class T560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
            ans += mp.getOrDefault(sum - k, 0);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

}
