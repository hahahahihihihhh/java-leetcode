package Problem;

public class T61_2 {

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

    void reverse(ListNode H, int l, int r) {
        ListNode lnode = H, rnode = H;
        for (int i = 1; i < l; i ++) {
            lnode = lnode.next;
        }
        for (int i = 1; i <= r; i ++) {
            rnode = rnode.next;
        }
        ListNode cur = lnode.next;
        lnode.next = rnode.next;
        rnode.next = null;
        ListNode tail = rnode;
        while (cur != null) {
            ListNode tmpCur = cur.next;
            cur.next = lnode.next;
            lnode.next = cur;
            cur = tmpCur;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode H = new ListNode(0, head);
        int len = 0;
        ListNode cur = H;
        while (cur.next != null) {
            len += 1;
            cur = cur.next;
        }
        int L = 1, M = len - k % len, R = len;
        reverse(H, L, M);
        reverse(H, M + 1, R);
        reverse(H, L, R);
        return H.next;
    }

}
