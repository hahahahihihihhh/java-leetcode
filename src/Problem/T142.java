package Problem;
import java.util.*;

public class T142 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hs = new HashSet<>();
        ListNode cur = head;
        while (cur != null && !hs.contains(cur)) {
            hs.add(cur);
            cur = cur.next;
        }
        return cur;
    }
}