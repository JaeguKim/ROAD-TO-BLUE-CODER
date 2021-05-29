package prob424;

class Solution {
    // A A B A B B A, K = 1
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxCnt = 0;
        int[] cnt = new int[26];
        int ans = 0;
        for (int r=0;r<s.length();r++) {
            maxCnt = Math.max(maxCnt,++cnt[s.charAt(r)-'A']);
            while (r-l+1-maxCnt > k) {
                cnt[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}