package Problem;

import java.util.*;

public class T102 {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)   return new ArrayList<>();
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        Map<Integer, List<Integer>> hmp = new TreeMap<>();
        q.offer(Map.entry(root, 1));
        while (!q.isEmpty()) {
            TreeNode node = q.peek().getKey();
            Integer layer = q.peek().getValue();
            q.poll();
            if (!hmp.containsKey(layer)) {
                hmp.put(layer, new ArrayList<>());
            }
            hmp.get(layer).add(node.val);
            if (node.left != null) {
                q.offer(Map.entry(node.left, layer + 1));
            }
            if (node.right != null) {
                q.offer(Map.entry(node.right, layer + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : hmp.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }

}
