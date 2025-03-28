package Problem;

public class T34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int L, R;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        R = l - 1;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        L = l;
        if (L <= R) {
            return new int[]{L, R};
        } else {
            return new int[]{-1, -1};
        }
    }
}
