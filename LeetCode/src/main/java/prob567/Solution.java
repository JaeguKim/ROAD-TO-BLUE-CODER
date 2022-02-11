package prob567;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        char[] charArr1 = s1.toCharArray();
        char[] charArr2 = s2.toCharArray();
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i=0; i<s1.length(); ++i) {
            map1[charArr1[i]-'a']++;
            map2[charArr2[i]-'a']++;
        }
        if (match(map1,map2)) {
            return true;
        }
        for (int i=1; i<=s2.length()-s1.length(); ++i) {
            map2[charArr2[i-1]-'a']--;
            map2[charArr2[i+s1.length()-1]-'a']++;
            if (match(map1,map2)) return true;
        }
        return false;
    }

    private boolean match(int[] map1, int[]map2) {
        for (int i=0; i<26; ++i) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }
}
