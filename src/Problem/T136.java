package Problem;

public class T136 {

    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums)
            ans ^= num;
        return ans;
    }

}
