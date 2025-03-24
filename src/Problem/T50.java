package Problem;

public class T50 {

    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        long N = n;
        boolean sgnb = !(x < 0 && Math.abs(N) % 2 == 1);
        boolean sgnp = N > 0;
        x = Math.abs(x);
        N = Math.abs(N);
        double ans = 1.0;
        while (N != 0) {
            if ((N & 1) == 1) {
                ans *= x;
            }
            N >>= 1;
            x *= x;
        }
        if (!sgnb)   ans = -ans;
        if (!sgnp)   ans = 1.0 / ans;
        return ans;
    }

}
