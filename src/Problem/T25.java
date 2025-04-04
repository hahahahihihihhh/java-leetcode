package Problem;

import java.util.*;

public class T25 {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode H = new ListNode(0, head);
        ListNode L = H;
        while (true) {
            ListNode R = L;
            for (int i = 0; i < k; i ++) {
                R = R.next;
                if (R == null)
                    return H.next;
            }
            ListNode cur = L.next;
            ListNode nL = cur;
            L.next = R.next;
            for (int i = 0; i < k; i ++) {
                ListNode tmpCur = cur.next;
                cur.next = L.next;
                L.next = cur;
                cur = tmpCur;
            }
            L = nL;
        }
    }

}
