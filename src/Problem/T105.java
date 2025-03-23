package Problem;

public class T105 {

     int tk = 0;

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

    void dfs(int li, int ri, int[] preorder, int[] inorder, TreeNode root) {
        root.val = preorder[tk];
        int mid = -1;
        for (int i = li; i <= ri; i ++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        if (mid > li) {
            root.left = new TreeNode();
            ++tk;
            dfs(li, mid - 1, preorder, inorder, root.left);
        }
        if (ri > mid) {
            root.right = new TreeNode();
            ++tk;
            dfs(mid + 1, ri, preorder, inorder, root.right);
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();
        int n = inorder.length;
        dfs(0, n - 1, preorder, inorder, root);
        return root;
    }

}
