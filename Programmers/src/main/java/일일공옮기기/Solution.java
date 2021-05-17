package 일일공옮기기;

import java.util.Stack;

class Solution {
    public String[] solution(String[] s) {
        String[] ans = new String[s.length];
        for (int i = 0; i < s.length; i++) {
            StringBuilder sb = new StringBuilder();
            Stack<Character> st = new Stack<>();
            int sz = 0;
            for (int j = 0; j < s[i].length(); j++) {
                char n1, n2, n3;
                st.push(s[i].charAt(j));
                if (st.size() >= 3) {
                    n3 = st.pop();
                    n2 = st.pop();
                    n1 = st.pop();
                    if (!(n1 == '1' && n2 == '1' && n3 == '0')) {
                        st.push(n1);
                        st.push(n2);
                        st.push(n3);
                    } else {
                        sz++;
                    }
                }
            }
            while (st.size() > 0) {
                sb.insert(0, st.pop());
            }
            int idx = sb.length();
            for (int j = sb.length() - 1; j >= 0; j--) {
                if (sb.charAt(j) == '0') {
                    break;
                }
                idx--;
            }
            idx = Math.max(0, idx);
            for (int k = 0; k < sz; k++) {
                sb.insert(idx, "110");
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}