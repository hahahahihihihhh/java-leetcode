package Problem;

import java.util.*;

public class T138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> mp = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            mp.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            mp.get(cur).next = mp.get(cur.next);
            mp.get(cur).random = mp.get(cur.random);
            cur = cur.next;
        }
        return mp.get(head);
    }

}
