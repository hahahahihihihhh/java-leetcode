package Problem;

import java.util.*;

public class T17 {

    List<String> ans = new ArrayList<>();
    List<Character>[] rec = new ArrayList[10];

    void dfs(int cur, String d, StringBuilder tmp) {
        if (cur == d.length()) {
            ans.add(tmp.toString());
            return ;
        }
        for (Character c : rec[d.charAt(cur) - '0']) {
            tmp.append(c);
            dfs(cur + 1, d, tmp);
            tmp.deleteCharAt(tmp.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())   return new ArrayList<>();
        rec[2] = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        rec[3] = new ArrayList<>(Arrays.asList('d', 'e', 'f'));
        rec[4] = new ArrayList<>(Arrays.asList('g', 'h', 'i'));
        rec[5] = new ArrayList<>(Arrays.asList('j', 'k', 'l'));
        rec[6] = new ArrayList<>(Arrays.asList('m', 'n', 'o'));
        rec[7] = new ArrayList<>(Arrays.asList('p', 'q', 'r', 's'));
        rec[8] = new ArrayList<>(Arrays.asList('t', 'u', 'v'));
        rec[9] = new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z'));
        dfs(0, digits, new StringBuilder());
        return ans;
    }

}
