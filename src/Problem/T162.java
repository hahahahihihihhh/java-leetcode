package Problem;

public class T162 {

    public int findPeakElement(int[] nums) {
        int n = nums.length;
        long[] a = new long[n + 2];
        for (int i = 1; i <= n; i ++) {
            a[i] = nums[i - 1];
        }
        a[0] = a[n + 1] = Long.MIN_VALUE;
        int l = 1, r = n;
        while (l <= r) {
            int m = (l + r) >> 1;
            if (a[m] >= a[m - 1]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return r - 1;
    }

}
