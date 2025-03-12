package Problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class T15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i ++) {
            int r = nums.length - 1;
            int sum = nums[i];
            for (int l = 0; l < r; l ++) {
                sum += nums[l];
                while (r > l && sum + nums[r] > 0) {
                    r --;
                }
                while (r > l && sum + nums[r] == 0) {
                    List<Integer> lst = new ArrayList<>();
                    if (l != i && r != i) {
                        lst.add(nums[i]);
                        lst.add(nums[l]);
                        lst.add(nums[r]);
                        lst.sort(Integer::compareTo);
                        hs.add(lst);
                    }
                    r --;
                }
                sum -= nums[l];
            }
        }
        return new ArrayList<>(hs);
    }

}
