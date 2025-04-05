package Problem;

public class T124 {

    int ans = Integer.MIN_VALUE;

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

    int dfs(TreeNode r) {
        if (r == null)  return 0;
        int ls = dfs(r.left), rs = dfs(r.right);
        ans = Math.max(ls + rs + r.val, ans);
        return Math.max(Math.max(ls, rs) + r.val, 0);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

}
