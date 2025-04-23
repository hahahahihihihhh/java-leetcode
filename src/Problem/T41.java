package Problem;

public class T41 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i ++)    nums[i] --;
        for (int i = 0; i < n; i ++) {
            int pre = nums[i];
            while (pre >= 0 && pre < n && nums[pre] != pre) {
                int tmp = pre;
                pre = nums[pre];
                nums[tmp] = tmp;
            }
        }
        for (int i = 0; i < n; i ++) {
            if (nums[i] != i) {
                return i + 1;
            }
        }
        return n + 1;
    }

}
