package 프로그래밍2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {

    boolean isRight(String s) {
        Stack<Character> q = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (q.empty() == false) {
                if (q.peek() == '[' && ch == ']') {
                    q.pop();
                }
                else if (q.peek() == '(' && ch == ')') {
                    q.pop();
                }
                else if (q.peek() == '{' && ch == '}') {
                    q.pop();
                }
                else {
                    q.push(ch);
                }
            }
            else {
                q.push(ch);
            }
        }
        return q.empty();
    }

    String rotate(String s) {
        return s.substring(1)+s.charAt(0);
    }

    public int solution(String s) {
        int ans = 0;
        if (isRight(s)) {
            ans++;
        }
        String newStr = s;
        for (int i=0;i<s.length()-1;i++) {
            newStr = rotate(newStr);
            if (isRight(newStr)) ans++;
        }
        return ans;
    }
}