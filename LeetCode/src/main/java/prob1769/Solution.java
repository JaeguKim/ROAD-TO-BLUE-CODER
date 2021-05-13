package prob1769;

class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        for (int i=0;i<boxes.length();i++) {
            int ans = 0;
            for (int j=0;j<boxes.length();j++) {
                if (i != j && boxes.charAt(j)=='1') {
                    ans += Math.abs(i-j);
                }
            }
            res[i] = ans;
        }
        return res;
    }
}