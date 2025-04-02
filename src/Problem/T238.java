package Problem;

public class T238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            ans[i] = ans[i - 1] * nums[i];
        }
        int suf = 1;
        for (int i = n - 1; i >= 1; i --) {
            ans[i] = ans[i - 1] * suf;
            suf *= nums[i];
        }
        ans[0] = suf;
        return ans;
    }

}
