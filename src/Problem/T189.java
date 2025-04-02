package Problem;

public class T189 {

    void reverse(int[] nums, int l, int r) {
        for (int i = l, j = r; i < j; i ++, j --) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int l = 0, r = n - 1, m = n - k;
        reverse(nums, l, m - 1);
        reverse(nums, m, r);
        reverse(nums, l, r);
    }

}
