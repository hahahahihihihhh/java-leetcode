package Problem;

public class T61 {

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode H = new ListNode(1);
        H.next = head;
        int len = 0;
        ListNode cur = H, tail = null;
        while (cur.next != null) {
            len += 1;
            cur = cur.next;
            tail = cur;
        }
        if (k % len == 0)   return head;
        len -= k % len;
        cur = H;
        int cnt = 0;
        while (cnt < len) {
            cnt += 1;
            cur = cur.next;
        }
        ListNode nhead = cur.next;
        cur.next = null;
        tail.next = head;
        return nhead;
    }

}
