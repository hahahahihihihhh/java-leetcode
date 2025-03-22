package Problem;

public class T55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxR = nums[0];
        for (int i = 0; i < n; i ++) {
            if (i <= maxR) {
                maxR = Math.max(i + nums[i], maxR);
            } else {
                return false;
            }
        }
        return true;
    }

}
