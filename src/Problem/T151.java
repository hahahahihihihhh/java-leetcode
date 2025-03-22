package Problem;

public class T151 {

    public String reverseWords(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int l = 0; l < n; l ++) {
            if (s.charAt(l) != ' ') {
                int r;
                for (r = l; r < n && s.charAt(r) != ' '; r ++);
                ans.insert(0, s.substring(l, r) + " ");
                l = r - 1;
            }
        }
        return ans.substring(0, ans.length() - 1);
    }

}
