package prob402;

import java.math.BigInteger;
import java.util.Stack;

import static java.lang.Integer.getInteger;

public class Solution {

    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        int changeCnt = k;
        for (char ch : num.toCharArray()) {
            while (st.size() > 0 && changeCnt > 0 && st.peek() > ch - '0') {
                st.pop();
                changeCnt--;
            }
            st.push(ch-'0');
        }
        while (changeCnt-- > 0) {
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.pop());
        }
        String reversedStr = sb.reverse().toString();
        int startIdx = -1;
        for (int i=0; i<reversedStr.length(); ++i) {
            if (reversedStr.charAt(i) != '0') {
                startIdx = i;
                break;
            }
        }
        if (startIdx == -1) return "0";
        return reversedStr.substring(startIdx);
    }
}
