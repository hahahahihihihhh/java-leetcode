package Problem;

public class T114 {

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

    TreeNode dfs(TreeNode pre, TreeNode cur) {
        pre.right = cur;
        pre.left = null;
        if (cur == null) {
            return pre;
        }
        TreeNode R = cur.right;
        TreeNode tail = dfs(cur, cur.left);
        return dfs(tail, R);
    }

    public void flatten(TreeNode root) {
        TreeNode H = new TreeNode();
        dfs(H, root);
    }

}
