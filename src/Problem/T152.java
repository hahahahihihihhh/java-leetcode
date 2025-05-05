package Problem;

public class T152 {

    final int INF = Integer.MAX_VALUE;

    public int maxProduct(int[] nums) {
        int n = nums.length;
        long negMax = -INF;
        long mul = 1;
        long ans = -INF;
        for (int num : nums) {
            ans = Math.max(ans, num);
            if (num == 0) {
                mul = 1;
                negMax = - INF;
                continue ;
            }
            mul *= num;
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
