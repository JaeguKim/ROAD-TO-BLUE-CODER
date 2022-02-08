package prob258;

public class Solution {
    public int addDigits(int num) {
        while (num >= 10) {
            String s = ""+num;
            num=0;
            for (char c : s.toCharArray()) {
                num+=c-'0';
            }
        }
        return num;
    }
}
