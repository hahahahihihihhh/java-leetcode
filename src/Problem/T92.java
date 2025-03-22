package Problem;

public class T92 {

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode H = new ListNode(1);
        H.next = head;
        ListNode cur = H;
        for (int i = 1; i < left; i ++) {
            cur = cur.next;
        }
        ListNode L = cur.next;
        ListNode leftNode = L;
        cur.next = null;
        for (int i = 1; i <= right - left + 1; i ++) {
            ListNode tmpL = L.next;
            L.next = cur.next;
            cur.next = L;
            L = tmpL;
        }
        leftNode.next = L;
        return H.next;
    }

}
