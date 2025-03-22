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
        List<Node> org = new ArrayList<>();
        Map<Node, Node> mp = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node tmp = new Node(cur.val);
            org.add(tmp);
            mp.put(cur, tmp);
            cur = cur.next;
        }
        cur = head;
        for (int i = 0; i < org.size(); i ++) {
            if (i == org.size() - 1) {
                org.get(i).next = null;
            } else {
                org.get(i).next = org.get(i + 1);
            }
            if (cur.random != null) {
                org.get(i).random = mp.get(cur.random);
            } else {
                org.get(i).random = null;
            }
            cur = cur.next;
        }
        return org.isEmpty() ? null : org.get(0);
    }

}
