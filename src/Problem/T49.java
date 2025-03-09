package Problem;
import java.util.*;

public class T49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> word = new TreeMap<>();
        for (int i = 0; i < strs.length; i ++) {
            List<Character> s = new ArrayList<>();
            for (int j = 0; j < strs[i].length(); j ++) {
                s.add(strs[i].charAt(j));
            }
            s.sort(Character::compareTo);
            StringBuilder sb = new StringBuilder();
            for (Character c : s) {
                sb.append(c);
            }
            String s2 = sb.toString();
            if (!word.containsKey(s2)) {
                word.put(s2, new ArrayList<>());
            }
            word.get(s2).add(strs[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : word.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

}
