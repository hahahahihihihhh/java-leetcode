package Problem;

import java.util.*;

public class T739 {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for (int i = 0; i < temperatures.length; i ++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                ans[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            ans[s.pop()] = 0;
        }
        return ans;
    }

}
