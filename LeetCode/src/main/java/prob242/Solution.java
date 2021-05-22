package prob242;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch-'a'] += 1;
        }
        for (char ch : t.toCharArray()) {
            cnt[ch-'a'] -= 1;
        }
        for (int num : cnt) if (num != 0) return false;
        return true;
    }
}