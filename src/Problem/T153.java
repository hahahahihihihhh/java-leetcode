package Problem;

public class T153 {

    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        if (nums[r] >= nums[0]) return nums[0];
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return nums[l];
    }

}
