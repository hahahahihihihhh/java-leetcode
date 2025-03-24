package Problem;

import java.util.*;

public class T399 {

    Map<String, Boolean> vis = new HashMap<>();
    Map<String, List<Map.Entry<String, Double>>> map = new HashMap<>();
    double ans = -1.0;

    void dfs(String source, String target, double mul) {
        if (source.equals(target)) {
            ans = mul;
            return ;
        }
        if (ans != -1.0) {
            return ;
        }
        if (vis.containsKey(source))    return ;
        for (Map.Entry<String, Double> e : map.get(source)) {
            vis.put(source, true);
            dfs(e.getKey(), target, e.getValue() * mul);
            vis.remove(source);
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        for (int i = 0; i < n; i ++) {
            String a = equations.get(i).get(0);
            String b =  equations.get(i).get(1);
            double v = values[i];
            if (!map.containsKey(a))    map.put(a, new ArrayList<>());
            if (!map.containsKey(b))    map.put(b, new ArrayList<>());
            map.get(a).add(Map.entry(b, v));
            map.get(b).add(Map.entry(a, 1.0 / v));
        }
        int m = queries.size();
        double[] res = new double[m];
        for (int i = 0; i < m; i ++) {
            String source = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            if (!map.containsKey(source) || !map.containsKey(target)) {
                res[i] = -1.0;
                continue ;
            }
            ans = -1.0;
            dfs(source, target, 1.0);
            res[i] = ans;
        }
        return res;
    }

}
