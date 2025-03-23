package Problem;

import java.util.*;

public class T199 {

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

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)   return new ArrayList<>();
        Map<Integer, Integer> hmp = new TreeMap<>();
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(Map.entry(root, 1));
        while (!q.isEmpty()) {
            TreeNode cur = q.peek().getKey();
            int layer = q.peek().getValue();
            q.poll();
            hmp.put(layer, cur.val);
            if (cur.left != null) {
                q.offer(Map.entry(cur.left, layer + 1));
            }
            if (cur.right != null) {
                q.offer(Map.entry(cur.right, layer + 1));
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> e : hmp.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

}
