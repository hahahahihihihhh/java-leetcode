package Problem;

public class T82 {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode H = new ListNode(0, head);
        int pre = -101;
        ListNode tail = H;
        ListNode preTail = H;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val != pre) {
                tail.next = cur;
                preTail = tail;
                tail = tail.next;
                pre = cur.val;
            } else {
                tail = preTail;
            }
            cur = cur.next;
        }
        tail.next = null;
        return H.next;
    }

}
