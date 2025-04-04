package Problem;

import java.util.*;

public class T236 {


     static public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    Map<TreeNode, Integer> d = new HashMap<>();
    Map<TreeNode, TreeNode> f = new HashMap<>();

    void dfs(TreeNode cur, int dep) {
        d.put(cur, dep);
        if (cur.left != null) {
            f.put(cur.left, cur);
            dfs(cur.left, dep + 1);
        }
        if (cur.right != null) {
            f.put(cur.right, cur);
            dfs(cur.right, dep + 1);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, 1);
        if (d.get(p) > d.get(q)) {
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        TreeNode curp = p, curq = q;
        while (d.get(curp) < d.get(curq)) {
            curq = f.get(curq);
        }
        while (curp != curq) {
            curp = f.get(curp);
            curq = f.get(curq);
        }
        return curp;
    }

}
