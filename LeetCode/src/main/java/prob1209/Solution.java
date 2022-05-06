package prob1209;

import java.util.Stack;

public class Solution {

    private class Info {
        char ch;
        int cnt;
        public Info(char ch, int cnt) {
            this.ch = ch;
            this.cnt = cnt;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Info> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            int cnt = !st.isEmpty() && st.peek().ch == ch ? st.peek().cnt : 0;
            st.push(new Info(ch,cnt+1));
            if (st.peek().cnt == k) {
                for (int i=0; i<k; ++i)
                    st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0,st.pop().ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeDuplicates("abcd",2));
        System.out.println(sol.removeDuplicates("deeedbbcccbdaa",3));
        System.out.println(sol.removeDuplicates("pbbcggttciiippooaais",2));
    }
}
