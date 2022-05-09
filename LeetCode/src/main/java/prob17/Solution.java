package prob17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int[] startIdxArr = {0,3,6,9,12,15,19,22,26};
    private List<String> res;

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.length() == 0)
            return res;
        recur(digits.toCharArray(),new char[digits.length()],0);
        return res;
    }

    private void recur(char[] digits, char[] cur, int idx) {
        if (idx > digits.length-1) {
            res.add(String.valueOf(cur));
            return;
        }
        int startIdx = startIdxArr[digits[idx]-'2'];
        int endIdx = startIdxArr[digits[idx]-'1']-1;
        for (int i=startIdx; i<=endIdx; ++i) {
            cur[idx] = alphabet.charAt(i);
            recur(digits,cur,idx+1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<String> res = sol.letterCombinations("23");
        for (String e : res) {
            System.out.println(e);
        }
        res = sol.letterCombinations("");
        for (String e : res) {
            System.out.println(e);
        }
        res = sol.letterCombinations("23");
        for (String e : res) {
            System.out.println(e);
        }
    }
}
