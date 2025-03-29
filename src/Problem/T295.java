package Problem;

import java.util.*;

public class T295 {

    Queue<Integer> q1, q2;
    double median;

    public T295() {
        q1 = new PriorityQueue<>(Collections.reverseOrder());
        q2 = new PriorityQueue<>();
        median = 0;
    }

    public void addNum(int num) {
        if (q1.isEmpty()) {
            q1.offer(num);
            median = num;
            return ;
        }
        if (num > median) {
            q2.offer(num);
        } else {
            q1.offer(num);
        }
        if (q2.size() > q1.size()) {
            q1.offer(q2.poll());
        } else if (q1.size() > q2.size() + 1) {
            q2.offer(q1.poll());
        }
        if (q1.size() == q2.size()) {
            median = (q1.peek() + q2.peek()) / 2.0;
        } else {
            median = q1.peek();
        }
    }

    public double findMedian() {
        return median;
    }

}
