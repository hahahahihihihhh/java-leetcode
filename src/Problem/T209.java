package Problem;

public class T209 {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int r = 0;
        int sum = 0;
        int ans = n + 1;
        for (int l = 0; l < n; l ++) {
            while (r < n && sum < target) {
                sum += nums[r];
                r ++;
            }
            if (sum >= target) {
                ans = Math.min(ans, r - l);
            }
            sum -= nums[l];
        }
        return ans == n + 1 ? 0 : ans;
    }

}
