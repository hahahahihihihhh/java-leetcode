package Problem;

import java.util.*;

public class T437 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    Map<TreeNode, Map<Long, Integer>> map = new HashMap<>();
    int ans = 0;
    void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return ;
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        map.put(root, new HashMap<>());
        for (Map.Entry<Long, Integer> e : map.get(root.left).entrySet()) {
            long tar = e.getKey() + root.val;
            if (tar == targetSum)
                ans += e.getValue();
            map.get(root).put(tar, map.get(root).getOrDefault(tar, 0) + e.getValue());
        }
        for (Map.Entry<Long, Integer> e : map.get(root.right).entrySet()) {
            long tar = e.getKey() + root.val;
            if (tar == targetSum)
                ans += e.getValue();
            map.get(root).put(tar, map.get(root).getOrDefault(tar, 0) + e.getValue());
        }
        if (root.val == targetSum)  ans ++;
        map.get(root).put((long) root.val, map.get(root).getOrDefault((long) root.val, 0) + 1);     // java 泛型是类型严格匹配的
    }

    public int pathSum(TreeNode root, int targetSum) {
        map.put(null, new HashMap<>());
        dfs(root, targetSum);
        return ans;
    }

}
