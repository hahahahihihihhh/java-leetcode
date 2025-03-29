package Problem;

public class T201 {

    public int rangeBitwiseAnd(int left, int right) {
        int ans = 0;
        if (left == right)  return left;
        for (int i = 0; i <= 30; i ++) {
            if (right - left <= (1 << i) - 1) {
                if (((left >> i) & 1) == 1 && ((right >> i) & 1) == 1) {
                    ans += (1 << i);
                }
            }
        }
        return ans;
    }

}
