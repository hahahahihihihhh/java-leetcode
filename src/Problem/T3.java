package Problem;

public class T3 {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] exist = new boolean[1000];
        int r = 0;
        int ans = 0;
        for (int l = 0; l < n; l ++) {
            while (r < n && !exist[s.charAt(r)]) {
                exist[s.charAt(r)] = true;
                r ++;
            }
            ans = Math.max(ans, r - l);
            exist[s.charAt(l)] = false;
        }
        return ans;
    }

}
