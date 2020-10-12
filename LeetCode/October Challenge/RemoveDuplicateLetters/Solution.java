package RemoveDuplicateLetters;

import java.util.Stack;

//traverse string get store last idx
//traverse string and do following task
// 1. if statck is empty, push item, update hash set
// 2. if stack is not empty, if current item is in stack continue
//                           else pop last item and last idx of last element is right side 
//                           then compare order, if order should be fixed, pop last element, push current element
//                            update item from hash set,
//                           

class Solution {
    public String removeDuplicateLetters(String s) {
        //HashMap<Character, Integer> lastIdx = new HashMap<>();
        int[] lastIdx = new int[26];
        //HashSet<Character> visited = new HashSet<>();
        boolean[] visited = new boolean[26];
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            lastIdx[s.charAt(i)-'a'] = i;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!visited[ch-'a']) {
                while (!stack.isEmpty()) {
                    char last = stack.peek();
                    if (last > ch && lastIdx[ch-'a'] > i) {
                        stack.pop();
                        visited[last-'a'] = false;
                    }
                    else {
                        break;
                    }
                }
                stack.push(ch);
                visited[ch-'a'] = true;
            }
        }
        while (!stack.empty()) {
            ans += stack.pop();
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(ans);
        return strBuilder.reverse().toString();
    }
}