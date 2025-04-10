package Problem;

public class T5 {

    public String longestPalindrome(String s) {
        int max = 1;
        String ans = String.valueOf(s.charAt(0));
        for (int i = 0; i < s.length(); i ++) {
            int l = i, r = i;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
            }
            if (r - l - 1 > max) {
                StringBuilder tmp = new StringBuilder(s);
                ans = tmp.substring(l + 1, r);
                max = r - l - 1;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l --;
                r ++;
            }
            if (r - l - 1 > max) {
                StringBuilder tmp = new StringBuilder(s);
                ans = tmp.substring(l + 1, r);
                max = r - l - 1;
            }
        }
        return ans;
    }

}
