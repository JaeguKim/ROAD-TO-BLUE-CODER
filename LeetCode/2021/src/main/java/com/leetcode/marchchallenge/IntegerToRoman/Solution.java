package com.leetcode.marchchallenge.IntegerToRoman;
class Solution {
    public String intToRoman(int num) {
        int thousandCnt = num/1000;
        int thousand = thousandCnt*1000;
        num -= thousand;
        int hundredCnt = num/100;
        int hundred = hundredCnt*100;
        num -= hundred;
        int tenCnt = num/10;
        int ten = tenCnt*10;
        num -= ten;
        int digit = num;

        String ans = "";

        while (thousandCnt-- > 0)
            ans += "M";
        if (hundredCnt == 4) {
            ans += "CD";
        } else if (hundredCnt == 9) {
            ans += "CM";
        } else if (hundredCnt >= 5) {
            ans += "D";
            int remainder = hundredCnt-5;
            while (remainder-- > 0)
                ans += "C";
        } else {
            while (hundredCnt-- > 0)
                ans += "C";
        }
        if (tenCnt == 4) {
            ans += "XL";
        } else if (tenCnt == 9) {
            ans += "XC";
        } else if (tenCnt >= 5) {
            ans += "L";
            int remainder = tenCnt-5;
            while (remainder-- > 0)
                ans += "X";
        } else {
            while (tenCnt-- > 0)
                ans += "X";
        }
        if (digit == 4) {
            ans += "IV";
        } else if (digit == 9) {
            ans += "IX";
        } else if (digit >= 5) {
            ans += "V";
            int remainder = digit-5;
            while (remainder-- > 0)
                ans += "I";
        } else {
            while (digit-- > 0)
                ans += "I";
        }
        return ans;
    }
}
