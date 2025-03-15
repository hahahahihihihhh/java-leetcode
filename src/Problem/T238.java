package Problem;

public class T238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n + 2];
        int[] suf = new int[n + 2];
        pre[0] = suf[n + 1] = 1;
        for (int i = 0; i < n; i ++) {
            pre[i + 1] = pre[i] * nums[i];
        }
        for (int i = n - 1; i >= 0; i --) {
            suf[i + 1] = suf[i + 2] * nums[i];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i ++) {
            ans[i] = pre[i] * suf[i + 2];
        }
        return ans;
    }

}
