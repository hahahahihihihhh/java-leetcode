package Problem;

import java.util.*;

public class T146 {

    static class DLinkListNode {
        DLinkListNode prev;
        DLinkListNode next;
        int key;
        int val;
        DLinkListNode() {}
        DLinkListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    DLinkListNode head, tail;
    Map<Integer, DLinkListNode> hmp;
    int capacity;

    public T146(int capacity) {
        this.capacity = capacity;
        head = new DLinkListNode();
        tail = new DLinkListNode();
        head.next = tail;
        tail.prev = head;
        hmp = new HashMap<>();
    }

    public void update(DLinkListNode cur) {
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;   // cur.
        cur.prev = null;
        cur.next = null;

        tail.prev.next = cur;
        cur.prev = tail.prev;
        cur.next = tail;
        tail.prev = cur;
    }

    public int get(int key) {
        if (hmp.containsKey(key)) {
            DLinkListNode cur = hmp.get(key);
            update(cur);
            return cur.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (hmp.containsKey(key)) {
            DLinkListNode cur = hmp.get(key);
            update(cur);
            cur.val = value;
        } else {
            DLinkListNode cur = new DLinkListNode(key, value);
            tail.prev.next = cur;
            cur.prev = tail.prev;
            cur.next = tail;
            tail.prev = cur;
            hmp.put(key, cur);
            if (hmp.size() > capacity) {
                cur = head.next;
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur.prev = null;
                cur.next = null;
                hmp.remove(cur.key);
            }
        }
    }

}
