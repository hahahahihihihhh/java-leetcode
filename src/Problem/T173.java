package Problem;

public class T173 { // 反序中序遍历构建树转单链表

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

    TreeNode prev;
    TreeNode R;

    void dfs(TreeNode cur) {
        if (cur == null)
            return ;
        dfs(cur.right);
        cur.right = prev;
        prev = cur;
        dfs(cur.left);
    }

    public T173(TreeNode root) {
        dfs(root);
        R = new TreeNode(-1, null, prev);
    }

    public int next() {
        R = R.right;
        return R.val;
    }

    public boolean hasNext() {
        return R.right != null;
    }

}
