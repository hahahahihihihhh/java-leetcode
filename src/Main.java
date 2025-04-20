import java.util.*;
import java.math.*;

public class Main {
    static int base = 10;

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>(); // push pop peek isEmpty size clear
        Map<Integer, Integer> hmp = new HashMap<>();     // get put remove isEmpty size clear entrySet Map.entry
        Map<Integer, Integer> tmp = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1)); // (o1, o2) -> Integer.compare(o2, o1)

        Queue<Integer> q = new LinkedList<>();          // offer poll peek isEmpty size clear
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));      // (o1, o2) -> Integer.compare(o2, o1)

        Set<Integer> hs = new HashSet<>();      // contains add remove isEmpty size clear
        Set<Integer> ts = new TreeSet<>((o1, o2) -> Integer.compare(o2, o1));   // (o1, o2) -> Integer.compare(o2, o1)

        stk.add(1);
        stk.add(2);
        System.out.println(stk.empty() + " " + stk.isEmpty());

        int x = 4, y = 2;
        BigInteger bx = BigInteger.valueOf(x), by = BigInteger.valueOf(y);
        int gcd = bx.gcd(by).intValue();
        System.out.println(bx + " " + by + " " + gcd);

        assert stk.empty() != stk.isEmpty();
//        System.out.println(stk.search(111));
        return ;
//        Map<Integer, Integer> mp;
//        mp.

    }
}