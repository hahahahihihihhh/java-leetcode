package Problem;

public class T169 {

    final int INF = 0x3f3f3f3f;
    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int cur = INF;
        int cnt = 0;
        for (int num : nums) {
            if (num != cur) {
                cnt --;
                if (cnt == -1) {
                    cnt = 1;
                    cur = num;
                }
            } else {
                cnt ++;
            }
        }
        return cur;
    }

}
