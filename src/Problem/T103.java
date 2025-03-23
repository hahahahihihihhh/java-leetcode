package Problem;

import java.util.*;

public class T103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)   return new ArrayList<>();
        Map<Integer, List<Integer>> hmp = new TreeMap<>();
        Queue<Map.Entry<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(Map.entry(root, 1));
        while (!q.isEmpty()) {
            Map.Entry<TreeNode, Integer> e = q.peek();
            q.poll();
            TreeNode cur = e.getKey();
            int layers = e.getValue();
            if (cur.left != null)   q.offer(Map.entry(cur.left, layers + 1));
            if (cur.right != null)  q.offer(Map.entry(cur.right, layers + 1));
            if (!hmp.containsKey(layers)) {
                hmp.put(layers, new ArrayList<>());
            }
            hmp.get(layers).add(cur.val);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> e : hmp.entrySet()) {
            if (e.getKey() % 2 == 0) {
                Collections.reverse(e.getValue());
            }
            ans.add(e.getValue());
        }
        return ans;
    }

}
