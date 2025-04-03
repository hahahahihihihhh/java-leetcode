package Problem;

public class T76 {

    public String minWindow(String s, String t) {
        int[] cnt = new int[1000], cntTmp = new int[1000];
        int tj = 0, tjTmp = 0;
        for (int i = 0; i < t.length(); i ++) {
            cnt[t.charAt(i)] ++;
            if (cnt[t.charAt(i)] == 1)
                tj ++;
        }
        int r = 0, n = s.length();
        int ansLen = n + 1, ansPos = - 1;
        for (int l = 0; l < n; l ++) {
            while (r < n && tj > tjTmp) {
                cntTmp[s.charAt(r)] ++;
                if (cntTmp[s.charAt(r)] == cnt[s.charAt(r)]) {
                    tjTmp ++;
                }
                r ++;
            }
            if (tj == tjTmp) {
                if (r - l < ansLen) {
                    ansPos = l;
                    ansLen = r - l;
                }
            }
            if (cntTmp[s.charAt(l)] == cnt[s.charAt(l)]) {
                tjTmp --;
            }
            cntTmp[s.charAt(l)] --;
        }
        return ansPos == -1 ? "" : s.substring(ansPos, ansPos + ansLen);
    }

}
