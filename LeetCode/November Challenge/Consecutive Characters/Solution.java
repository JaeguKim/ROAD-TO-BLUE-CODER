class Solution {
    
    public int maxPower(String s) {
        int cnt = 1;
        int maxVal = -1;
        for (int i=1;i<s.length();i++){
            if (s.charAt(i) == s.charAt(i-1)) cnt++;
            else {
                maxVal = Math.max(maxVal,cnt);
                cnt = 1;
            }
        }
        return maxVal;
    }
}