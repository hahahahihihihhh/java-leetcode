package Problem;

public class T53 {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i ++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        int min = 0;
        int ans = -0x3f3f3f3f;
        for (int i = 1; i <= n; i ++) {
            ans = Math.max(ans, pre[i] - min);
            min = Math.min(min, pre[i]);
        }
        return ans;
    }

}
