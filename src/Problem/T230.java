package Problem;

import java.util.*;

public class T230 {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    final int N = 10005;
    Map<TreeNode, Integer> siz = new HashMap<>();

    void dfs0(TreeNode cur) {
        if (cur == null)    return ;
        dfs0(cur.left);
        dfs0(cur.right);
        siz.put(cur, siz.get(cur.left) + siz.get(cur.right) + 1);
    }

    int dfs(TreeNode cur, int k) {
        if (siz.get(cur.left) == k - 1) return cur.val;
        if (siz.get(cur.left) >= k)  return dfs(cur.left, k);
        else return dfs(cur.right, k - siz.get(cur.left) - 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        siz.put(null, 0);
        dfs0(root);
        return dfs(root, k);
    }

}
