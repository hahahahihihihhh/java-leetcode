package Problem;

import java.util.*;

public class T30 {

    public List<Integer> findSubstring(String s, String[] words) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        Map<String, Integer> mark = new HashMap<>();
        Map<String, Integer> exist = new HashMap<>();
        for (String word : words) {
            exist.put(word, exist.getOrDefault(word, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        int len = words[0].length();
        for (int i = 0; i < len; i ++) {
            int r = i;
            int cnt = 0;
            for (int l = i; l < n; l += len) {
                r = Math.max(l, r);
                while (r + len <= n && mark.getOrDefault(sb.substring(r, r + len), 0) + 1 <= exist.getOrDefault(sb.substring(r, r + len).toString(), 0)) {
                    String word = sb.substring(r, r + len);
                    mark.put(word, mark.getOrDefault(word, 0) + 1);
                    r = r + len;
                    cnt += 1;
                }
                if (cnt == words.length) {
                    ans.add(l);
                }
                if (l < r) {
                    String word = sb.substring(l, l + len);
                    mark.put(word, mark.get(word) - 1);
                    cnt -= 1;
                }
            }
        }
        return ans;
    }

}
