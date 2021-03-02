import java.util.Arrays;

class Solution {

    int findDigits(int a){
        return Integer.toString(a).length();
    }

    int stoi(String s){
        int res = 0;
        int n = s.length();
        int mult = 1;
        for (int i=n-1;i>-1;i--){
            res += mult*(s.charAt(i)-'0');
            mult *= 10;
        }
        return res;
    }

    int helper(String[] digits, String num) {
        int ans = 0;
        int i = 0;
        if (num.length() == 0){
            return 1;
        }
        
        int mult = (int) Math.pow(digits.length, num.length() - 1);
        while (i < digits.length && stoi(digits[i]) < (num.charAt(0)-'0')){
            ans += mult;
            i++;
        }
        if (i<digits.length && stoi(digits[i]) == (num.charAt(0)-'0')){
            ans += helper(digits,num.substring(1));
        }
        return ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        Arrays.sort(digits);
        int ans = 0;
        int d = findDigits(n);
        int mult = 1;
        for (int i=1;i<=d-1;i++){
            mult *= digits.length;
            ans += mult;
        }
        String num = Integer.toString(n);
        ans += helper(digits,num);
        return ans;
    }
}