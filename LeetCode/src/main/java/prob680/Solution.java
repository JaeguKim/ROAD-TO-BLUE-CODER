package prob680;

public class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    public boolean validPalindrome(String s) {
        if (isPalindrome(s)) return true;
        int l=0,r=s.length()-1;
        char[] arr = s.toCharArray();
        while (l < r) {
            if (arr[l] == arr[r]) {
                l++;
                r--;
            } else {
                return isPalindrome(s.substring(l,r)) || isPalindrome(s.substring(l+1,r+1));
            }
        }
        return true;
    }
}
