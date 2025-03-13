package Problem;

public class T19 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fastPoint = head, slowPoint = head;
        for (int i = 0; i <= n; i ++) {
            fastPoint = fastPoint.next;
            if (fastPoint == null && i != n) {
                return head.next;
            }
        }
        while (fastPoint != null) {
            fastPoint = fastPoint.next;
            slowPoint = slowPoint.next;
        }
        slowPoint.next = slowPoint.next.next;
        return head;
    }
}
