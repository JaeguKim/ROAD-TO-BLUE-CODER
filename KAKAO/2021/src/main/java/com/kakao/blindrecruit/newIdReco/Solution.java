package com.kakao.blindrecruit.newIdReco;

class Solution {
    public String solution(String new_id) {
        String lower_id = new_id.toLowerCase();
        String ans = "";
        for (char ch : lower_id.toCharArray()) {
            if (Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                ans += ch;
            }
        }
        while (ans.contains("..")) {
            ans = ans.replace("..",".");
        }
        while (ans.length() > 0 && (ans.charAt(0) == '.' || ans.charAt(ans.length()-1) == '.')) {
            if (ans.length() == 1) ans = "";
            else {
                if (ans.charAt(0) == '.') {
                    ans = ans.substring(1);
                }
                else {
                    ans = ans.substring(0,ans.length()-1);
                }
            }
        }

        if (ans.isEmpty()) ans = "a";
        if (ans.length() >= 16){
            ans = ans.substring(0,15);
            if (ans.charAt(ans.length()-1) == '.') {
                ans = ans.substring(0,ans.length()-1);
            }
        }
        if (ans.length() <= 2){
            char lastCh = ans.charAt(ans.length()-1);
            while (ans.length() < 3){
                ans += lastCh;
            }
        }
        return ans;
    }

    public String regexpSolution(String new_id) {
        String lower_id = new_id.toLowerCase();
        String ans = lower_id.replaceAll("[^-_.a-z0-9]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("^[.]|[.]$", "");
        if (ans.equals("")) ans += "a";
        if (ans.length() >= 16) ans = ans.substring(0, 15).replaceAll("[.]$", "");
        if (ans.length() <= 2) {
            char lastCh = ans.charAt(ans.length() - 1);
            while (ans.length() < 3)
                ans += lastCh;
        }
        return ans;
    }
}
