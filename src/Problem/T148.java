package Problem;

public class T148 {

     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    ListNode sort(ListNode H) {
        if (H.next.next == null)
            return H;
        ListNode fast = H, slow = H;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode lH = H, rH = new ListNode();
        rH.next = slow.next;
        slow.next = null;
        ListNode l = sort(lH), r = sort(rH);
        ListNode h = new ListNode();
        ListNode t = h;
        while (l.next != null && r.next != null) {
            ListNode tmp;
            if (l.next.val <= r.next.val) {
                tmp = l.next;
                l.next = l.next.next;
            } else {
                tmp = r.next;
                r.next = r.next.next;
            }
            t.next = tmp;
            t = tmp;
        }
        if (l.next != null) {
            t.next = l.next;
        } else {
            t.next = r.next;
        }
        return h;
    }

    public ListNode sortList(ListNode head) {
        if (head == null)   return head;
        ListNode H = new ListNode();
        H.next = head;
        return sort(H).next;
    }

}
