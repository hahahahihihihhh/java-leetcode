package Problem;

import java.util.*;

public class T98 {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<TreeNode, Long> min = new HashMap<>();
    Map<TreeNode, Long> max = new HashMap<>();

    void dfs0(TreeNode cur) {
        if (cur == null)    return ;
        dfs0(cur.left);
        dfs0(cur.right);
        min.put(cur, Math.min(Math.min(min.get(cur.left), min.get(cur.right)), cur.val));
        max.put(cur, Math.max(Math.max(max.get(cur.left), max.get(cur.right)), cur.val));
    }

    boolean dfs(TreeNode cur) {
        if (cur == null)    return true;
        return dfs(cur.left) && dfs(cur.right) && max.get(cur.left) < cur.val && min.get(cur.right) > cur.val;
    }

    public boolean isValidBST(TreeNode root) {
        min.put(null, Long.MAX_VALUE);
        max.put(null, Long.MIN_VALUE);
        dfs0(root);
        return dfs(root);
    }
}
