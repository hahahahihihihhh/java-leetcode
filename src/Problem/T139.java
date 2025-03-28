package Problem;

import java.util.*;

public class T139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Map<String, Boolean> dict = new HashMap<>();
        for (String word : wordDict) {
            dict.put(word, true);
        }
        boolean[] dp = new boolean[n + 1];
        s = " " + s;
        dp[0] = true;
        for (int i = 1; i <= n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (dp[j] && dict.containsKey(s.substring(j + 1, i + 1))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
