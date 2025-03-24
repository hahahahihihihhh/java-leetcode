package Problem;

import java.util.*;

public class T133 {


    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    Map<Node, Boolean> vis = new HashMap<>();
    Map<Node, Node> tmap = new HashMap<>();

    void dfs(Node cur) {
        if (vis.containsKey(cur))   return ;
        vis.put(cur, true);
        tmap.put(cur, new Node(cur.val));
        for (Node node : cur.neighbors) {
            dfs(node);
        }
    }

    void dfs2(Node cur) {
        if (vis.containsKey(cur))   return ;
        vis.put(cur, true);
        for (Node node : cur.neighbors) {
            Node tmp = tmap.get(node);
            tmap.get(cur).neighbors.add(tmp);
            dfs2(node);
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)   return node;
        dfs(node);
        vis.clear();
        dfs2(node);
        return tmap.get(node);
    }

}
