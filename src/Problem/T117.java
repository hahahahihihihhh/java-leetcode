package Problem;

public class T117 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}
        public Node(int _val) {
            val = _val;
        }
        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root) {
        Node start = root;
        while (start != null) {
            Node pre = null;
            Node nextStart = null;
            for (Node cur = start; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                        pre = cur.left;
                    } else {
                        pre = cur.left;
                        nextStart = pre;
                    }
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                        pre = cur.right;
                    } else {
                        pre = cur.right;
                        nextStart = pre;
                    }
                }
            }
            start = nextStart;
        }
        return root;
    }

}
