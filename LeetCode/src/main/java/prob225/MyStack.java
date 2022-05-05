package prob225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private int top;
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        top = -1;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // O(1) time
    public void push(int x) {
        q1.add(x);
        top = x;
    }

    // O(N) time
    public int pop() {
        while (q1.size() > 1) {
            top = q1.poll();
            q2.add(top);
        }
        int res = q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return res;
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return q1.size() == 0;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

class OneQueueSolution {

    private Queue<Integer> q;

    public OneQueueSolution() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
        int sz = q.size();
        while (sz-- > 1) {
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.size() == 0;
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */