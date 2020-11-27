import java.util.Arrays;

// Devide & Conquer
/*
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (n == 0 || n < k) return 0;
        if (k <= 1) return n;
        
        Map<Character,Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()){
            counts.put(c,counts.getOrDefault(c, 0)+1);
        }

        int l = 0;
        while (l < n && counts.get(s.charAt(l)) >= k) l++;
        if (l >= n-1) return l;

        int ls1 = longestSubstring(s.substring(0,l),k);
        while (l < n && counts.get(s.charAt(l)) < k) l++;
        int ls2 = (l < n) ? longestSubstring(s.substring(l),k) : 0;
        return Math.max(ls1,ls2);
    }
}
*/

// Sliding Window
public class Solution {

    public int longestSubstring(String s, int k){
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++){
            Arrays.fill(countMap,0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < str.length) {
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    windowEnd++;
                }
                else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK) {
                    result = Math.max(windowEnd - windowStart, result);
                }
            }
        }
        return result;
    }

    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i=0; i < s.length(); i++){
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i)-'a'] = true;
            }
        }
        return maxUnique;
    }
}