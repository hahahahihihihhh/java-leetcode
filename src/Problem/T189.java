package Problem;

public class T189 {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        k %= n;
        for (int i = n - k; i < n; i ++) {
            ans[i - (n - k)] = nums[i];
        }
        for (int i = 0; i < n - k; i ++) {
            ans[i + k] = nums[i];
        }
        for (int i = 0; i < n; i ++) {
            nums[i] = ans[i];
        }
    }

}
