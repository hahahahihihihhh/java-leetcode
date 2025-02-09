package Problem;

import java.lang.Math;
import java.util.Arrays;

public class T80 {

    public int removeDuplicates(int[] nums) {
        int cnt = 1;
        int ans = 0;
        int tk = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i - 1]) {
                cnt ++;
            } else {
                ans += Math.max(cnt - 2, 0);
                cnt = 1;
            }
            if (cnt <= 2) {
                nums[tk] = nums[i];
                tk ++;
            }
        }
        ans += Math.max(cnt - 2, 0);
        System.out.println(Arrays.toString(nums));
        return nums.length - ans;
    }

}
