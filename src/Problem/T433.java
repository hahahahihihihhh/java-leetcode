package Problem;

import java.util.*;

public class T433 {

    Map<String, Integer> bk = new HashMap<>();
    List<Character> gen = new ArrayList<>();
    int INF = Integer.MAX_VALUE;

    void dfs(StringBuilder cur, String target, int step) {
        if (bk.get(cur.toString()) != null && bk.get(cur.toString()) > step) {
            bk.put(cur.toString(), step);
        } else {
            return ;
        }
        for (int i = 0; i < cur.length(); i ++) {
            Character ci = cur.charAt(i);
            for (Character c : gen) {
                if (ci != c) {
                    cur.deleteCharAt(i);
                    cur.insert(i, c);
                    dfs(cur, target, step + 1);
                    cur.deleteCharAt(i);
                    cur.insert(i, ci);
                }
            }
        }
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        bk.put(startGene, INF);
        for (String g : bank) {
            bk.put(g, INF);
        }
        gen.addAll(List.of('A', 'C', 'G', 'T'));
        dfs(new StringBuilder(startGene), endGene, 0);
        return !bk.containsKey(endGene) || bk.get(endGene) == INF ? -1 : bk.get(endGene);
    }

}
