package com.leetcode.stack.simplifyPath;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        char[] arr = path.toCharArray();
        String s = "";
        for (int i=0;i<arr.length;i++) {
           if (arr[i] != '/') {
              s += arr[i];
           }
           if (arr[i] == '/' || i == arr.length-1) {
               if (s.isEmpty() == false) {
                   if (s.equals("..")) {
                       if (st.size() > 0) {
                           st.pop();
                       }
                   }
                   else if (s.equals(".") == false) {
                       st.push(s);
                   }
                   s = "";
               }
           }
        }
        List<String> list = st.stream().collect(Collectors.toList());
        String ans = "";
        for (String item : list) {
            ans += "/" + item;
        }
        if (ans.isEmpty()) ans = "/";
        return ans;
    }
}