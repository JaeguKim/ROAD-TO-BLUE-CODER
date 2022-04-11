package prob682;

import java.util.Stack;

public class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                int n2 = st.pop();
                int n1 = st.pop();
                st.push(n1);
                st.push(n2);
                st.push(n1+n2);
            } else if (op.equals("D")) {
                st.push(st.peek()*2);
            } else if (op.equals("C")) {
                st.pop();
            } else {
                st.push(Integer.parseInt(op));
            }
        }
        return st.stream().mapToInt(i->i).sum();
    }
}

