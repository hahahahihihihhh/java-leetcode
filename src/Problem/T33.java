package Problem;

public class T33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if ((target >= nums[0] && (nums[mid] >= target || nums[mid] < nums[0])) || (target < nums[0] && (nums[mid] >= target && nums[mid] < nums[0]))) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l <= n - 1 && nums[l] == target)
            return l;
        else if (r >= 0 && nums[r] == target)
            return r;
        return -1;
    }
}
