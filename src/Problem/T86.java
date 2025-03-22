package Problem;

import java.util.*;

public class T86 {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        List<Integer> a = new ArrayList<>();
        ListNode H = new ListNode(0);
        H.next = head;
        ListNode cur = H;
        while (cur.next != null) {
            a.add(cur.next.val);
            cur = cur.next;
        }
        H.next = null;
        for (int i = a.size() - 1; i >= 0; i --) {
            if (a.get(i) >= x) {
                ListNode node = new ListNode(a.get(i));
                node.next = H.next;
                H.next = node;
            }
        }
        for (int i = a.size() - 1; i >= 0; i --) {
            if (a.get(i) < x) {
                ListNode node = new ListNode(a.get(i));
                node.next = H.next;
                H.next = node;
            }
        }
        return H.next;
    }

}
