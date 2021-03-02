package BuddyString;

class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) return false;
        else if (A.equals(B)){
            boolean[] seen = new boolean[26];
            for (int i=0; i<A.length(); i++){
                if (seen[A.charAt(i)-'a']) return true;
                seen[A.charAt(i)-'a'] = true;
            }
            return false;
        }
        int cnt = 0;
        String a = "";
        String b = "";
        for (int i=0; i<A.length(); i++){
            if (A.charAt(i) != B.charAt(i)){
                cnt++;
                a += A.charAt(i);
                b += B.charAt(i);
                if (cnt > 2) return false;
            }
        }
        StringBuilder strBuilder = new StringBuilder(a);
        return strBuilder.reverse().toString().equals(b);
    }
}