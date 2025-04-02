package Problem;

import java.util.*;

public class T68 {

    String toStr(List<String> words, int maxWidth) {
        StringBuilder ans = new StringBuilder();
        if (words.size() == 1) {
            ans.append(words.get(0));
            ans.append(" ".repeat(maxWidth - words.get(0).length()));
            return ans.toString();
        }
        int wordLen = 0;
        for (String word : words) {
            wordLen += word.length();
        }
        int spaceAll = maxWidth - wordLen;
        int space = spaceAll / (words.size() - 1);
        int extra = spaceAll % (words.size() - 1);
        for (int i = 0; i < words.size(); i ++) {
            ans.append(words.get(i));
            if (i == words.size() - 1)  break;
            ans.append(" ".repeat(space));
            if (i + 1 <= extra) ans.append(" ");
        }
        return ans.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        List<String> ans = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        int width = 0;
        for (String word : words) {
            if (width + word.length() + tmp.size() > maxWidth) {
                ans.add(toStr(tmp, maxWidth));
                tmp.clear();
                tmp.add(word);
                width = word.length();
            } else {
                tmp.add(word);
                width += word.length();
            }
        }
        StringBuilder endLine = new StringBuilder();
        for (int i = 0; i < tmp.size(); i ++) {
            endLine.append(tmp.get(i));
            if (i != tmp.size() - 1)
                endLine.append(" ");
        }
        int padding = maxWidth - endLine.length();
        endLine.append(" ".repeat(padding));
        ans.add(endLine.toString());
        return ans;
    }

}
