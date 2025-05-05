package Problem;

public class T152 {

    final int INF = Integer.MAX_VALUE;

    public int maxProduct(int[] nums) {
        int n = nums.length;
        long negMax = -INF;
        long mul = 1;
        long ans = -INF;
        for (int i = 0; i < n; i ++) {
            ans = Math.max(ans, nums[i]);
            if (nums[i] == 0) {
                mul = 1;
                negMax = - INF;
                continue ;
            }
            mul *= nums[i];
            if (mul > 0)
                ans = Math.max(mul, ans);
            else {
                if (negMax != -INF)
                    ans = Math.max(mul / negMax, ans);
                negMax = Math.max(mul, negMax);
            }
        }
        return (int) ans;
    }

}
