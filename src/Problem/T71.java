package Problem;

import java.util.ArrayList;
import java.util.List;

public class T71 {

    public String simplifyPath(String path) {
        int n = path.length();
        String[] dirs = path.split("/");
        List<String> p = new ArrayList<>();
        for (int i = 0; i < dirs.length; i ++) {
            if (dirs[i].isEmpty() || dirs[i].equals(".")) {
                continue ;
            } else if (dirs[i].equals("..")) {
                if (!p.isEmpty()) {
                    p.remove(p.size() - 1);
                }
            } else {
                p.add(dirs[i]);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < p.size(); i ++) {
            ans.append("/");
            ans.append(p.get(i));
        }
        if (ans.isEmpty()) {
            return "/";
        }
        return ans.toString();
    }

}
