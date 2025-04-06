package Problem;

import java.util.*;

public class T23 {


     static public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        ListNode[] h = new ListNode[n];
        Queue<ListNode> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.next.val, o2.next.val));
        for (int i = 0; i < n; i ++) {
            h[i] = new ListNode();
            h[i].next = lists[i];
            if (h[i].next != null)
                q.offer(h[i]);
        }
        ListNode H = new ListNode();
        ListNode cur = H;
        while (!q.isEmpty()) {
            ListNode top = q.poll();
            ListNode tmp = top.next;
            top.next = top.next.next;
            cur.next = tmp;
            tmp.next = null;
            cur = tmp;
            if (top.next != null) {
                q.offer(top);
            }
        }
        return H.next;
    }

}
