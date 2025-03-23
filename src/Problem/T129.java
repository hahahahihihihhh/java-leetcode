package Problem;

import java.util.LinkedList;
import java.util.Queue;

public class T129 {

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

    int ans = 0;

    void dfs(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            ans += sum;
            return ;
        }
        if (root.left != null) {
            dfs(root.left, sum * 10 + root.left.val);
        }
        if (root.right != null) {
            dfs(root.right, sum * 10 + root.right.val);
        }
    }

    public int sumNumbers(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }
}
