package Problem;

import java.util.*;

public class T155 {

    Stack<Integer> stk;
    Stack<Map.Entry<Integer, Integer>> pos;

    public T155() {
        stk = new Stack<>();
        pos = new Stack<>();
    }

    public void push(int val) {
        stk.push(val);
        if (pos.isEmpty() || pos.peek().getKey() > val) {
            pos.push(Map.entry(val, stk.size()));
        }
    }

    public void pop() {
        stk.pop();
        while (!pos.isEmpty() && pos.peek().getValue() > stk.size()) {
            pos.pop();
        }
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return pos.peek().getKey();
    }

}
