package Problem;
import java.util.*;

public class T49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> word = new TreeMap<>();
        for (String str : strs) {
            List<Character> s = new ArrayList<>();
            for (int j = 0; j < str.length(); j++) {
                s.add(str.charAt(j));
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
            word.get(s2).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> e : word.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

}
