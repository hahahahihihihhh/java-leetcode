package Problem;

import java.util.*;

public class T127 {

    final int INF = 0x3f3f3f3f;

    boolean connect(String a, String b) {
        int cnt = 0;
        int n = a.length();
        for (int i = 0; i < n; i ++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt ++;
                if (cnt == 2)   break;
            }
        }
        return cnt == 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();
        boolean[][] g = new boolean[n + 1][n + 1];
        int[] d  = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        for (int i = 0; i <= n; i ++) {
            d[i] = INF;
        }
        int tar = -1;
        for (int i = 0; i < n; i ++) {
            if (wordList.get(i).equals(endWord))    tar = i + 1;
            if (connect(beginWord, wordList.get(i)))    g[0][i + 1] = true;
            for (int j = i + 1; j < n; j ++) {
                if (connect(wordList.get(i), wordList.get(j))) {
                    g[i + 1][j + 1] = true;
                    g[j + 1][i + 1] = true;
                }
            }
        }
        d[0] = 1;
        for (int i = 1; i <= n; i ++) {
            int minDisId = -1, dis = INF;
            for (int j = 0; j <= n; j ++) {
                if (!vis[j] && d[j] < dis) {
                    dis = d[j];
                    minDisId = j;
                }
            }
            if (minDisId == -1) break ;
            vis[minDisId] = true;
            for (int j = 0; j <= n; j ++) {
                if (g[minDisId][j]) {
                    d[j] = Math.min(d[j], d[minDisId] + 1);
                }
            }
        }
        if (tar == -1)  return 0;
        return d[tar] == INF ? 0 : d[tar];
    }

}
