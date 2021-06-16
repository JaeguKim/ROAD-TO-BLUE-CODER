package prob22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    public void helper(int len, List<String> list, char[] arr, int idx) {
        if (idx == len) {
            Stack<Character> st = new Stack<>();
            for (char ch : arr) {
                if (ch == ')' && st.size() > 0 && st.peek() == '(' ) st.pop();
                else st.push(ch);
            }
            if (st.size() == 0) list.add(new String(arr));
            return;
        }
        arr[idx] = '(';
        helper(len,list,arr,idx+1);
        arr[idx] = ')';
        helper(len,list,arr,idx+1);
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n*2,ans,new char[n*2],0);
        return ans;
    }
}