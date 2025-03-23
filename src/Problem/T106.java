package Problem;

public class T106 {

    int tk;

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

    void dfs(int li, int ri, int[] postorder, int[] inorder, TreeNode root) {
        int mid = -1;
        root.val = postorder[tk];
        for (int i = li; i <= ri; i ++) {
            if (inorder[i] == root.val) {
                mid = i;
                break;
            }
        }
        if (ri > mid) {
            root.right = new TreeNode();
            --tk;
            dfs(mid + 1, ri, postorder, inorder, root.right);
        }
        if (mid > li) {
            root.left = new TreeNode();
            --tk;
            dfs(li, mid - 1, postorder, inorder, root.left);
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = new TreeNode();
        int n = inorder.length;
        tk = n - 1;
        dfs(0, n - 1, postorder, inorder, root);
        return root;
    }

}
