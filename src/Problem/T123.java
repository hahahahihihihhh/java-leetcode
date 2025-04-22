package Problem;

public class T123 {

    final int INF = 0x3f3f3f3f;

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] preMin = new int[n + 2];
        int[] sufMax = new int[n + 2];
        preMin[0] = INF;
        sufMax[n + 1] = - INF;
        for (int i = 1; i <= n; i ++)
            preMin[i] = Math.min(preMin[i - 1], prices[i - 1]);
        for (int i = n; i >= 1; i --)
            sufMax[i] = Math.max(sufMax[i + 1], prices[i - 1]);
        int[] preAns = new int[n + 2];
        preAns[0] = - INF;
        for (int i = 1; i <= n; i ++) {
            preAns[i] = Math.max(preAns[i - 1], prices[i - 1] - preMin[i]);
        }
        int[] sufAns = new int[n + 2];
        sufAns[n + 1] = - INF;
        for (int i = n; i >= 1; i --) {
            sufAns[i] = Math.max(sufAns[i + 1], sufMax[i] - prices[i - 1]);
        }
        int ans = - INF;
        for (int i = 1; i <= n; i ++) {
            ans = Math.max(preAns[i] + sufAns[i], ans);
        }
        return ans;
    }


}
