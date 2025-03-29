package Problem;

import java.util.PriorityQueue;

public class T427 {

    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    Node gen(int left, int right, int up, int down, int[][] grid) {
        boolean zero = false, one = false;
        for (int i = up; i < down; i ++) {
            for (int j = left; j < right; j ++) {
                if (grid[i][j] == 1) {
                    one = true;
                } else {
                    zero = true;
                }
            }
        }
        int len = right - left;
        if (one && zero) {
            // 分治
            int l1 = left + (len >> 1), up1 = up + (len >> 1);
            return new Node(false, false, gen(left, l1, up, up1, grid), gen(l1, right, up, up1, grid), gen(left, l1, up1, down, grid), gen(l1, right, up1, down, grid));
        }
        return one ? new Node(true, true) : new Node(false, true);
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        return gen(0, n, 0, n, grid);
    }

}
