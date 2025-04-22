package Problem;

public class T5 {

    public String longestPalindrome(String s) {
        int max = -1, pos = -1;
        StringBuilder sb = new StringBuilder("?");
        for (int i = 0; i < s.length(); i ++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("!");
        for (int i = 1; i < sb.length() - 1; i ++) {
            int l = i, r = i;
            while (sb.charAt(l) == sb.charAt(r)) {
                l --;
                r ++;
            }
            if (r - l - 1 > max) {
                max = r - l - 1;
                pos = l + 1;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = pos; i < pos + max; i ++) {
            if (sb.charAt(i) != '#') {
                ans.append(sb.charAt(i));
            }
        }
        return ans.toString();
    }

}
