package Problem;

public class T287 {

    public int findDuplicate(int[] nums) {
        int x = 0, y = 0;
        do {
            x = nums[x];
            y = nums[nums[y]];
        } while (x != y);
        x = 0;
        while (x != y) {
            x = nums[x];
            y = nums[y];
        }
        return x;
    }

}
