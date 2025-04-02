package Problem;

import java.util.*;

public class T135 {

    public int candy(int[] ratings) {
        Queue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(ratings[o1], ratings[o2]));
        for (int i = 0; i < ratings.length; i ++) {
            q.offer(i);
        }
        int n = ratings.length;
        int[] candies = new int[n];
        int ans = 0;
        while (!q.isEmpty()) {
            int pos = q.peek();
            q.poll();
            int cur = 1;
            if (pos >= 1 && ratings[pos] > ratings[pos - 1])   cur = Math.max(cur, candies[pos - 1] + 1);
            if (pos < n - 1 && ratings[pos] > ratings[pos + 1]) cur = Math.max(cur, candies[pos + 1] + 1);
            candies[pos] = cur;
            ans += candies[pos];
        }
        return ans;
    }

}
