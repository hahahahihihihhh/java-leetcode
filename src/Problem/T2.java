package Problem;

import java.util.*;

public class T2 {


     static public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2;
        ListNode H = new ListNode();
        ListNode t = H;
        int jin = 0;
        while (t1 != null || t2 != null) {
            int val1 = t1 == null ? 0 : t1.val, val2 = t2 == null ? 0 : t2.val;
            int val = (val1 + val2 + jin) % 10;
            jin = (val1 + val2 + jin) / 10;
            t.next = new ListNode(val);
            t = t.next;
            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }
        if (jin != 0) {
            t.next = new ListNode(jin);
        }
        return H.next;
    }

}
