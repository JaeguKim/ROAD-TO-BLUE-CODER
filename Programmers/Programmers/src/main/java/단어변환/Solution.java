package 단어변환;

public class Solution {

    int min = 0;
    String target;
    String[] words;

    public int getDiff(String a, String b) {
        int cnt = 0;
        for (int i=0;i<a.length();i++) {
            if (a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }


    public void dfs(int d, int[] perm, String s) {
        if (d > perm.length) return;
        if (s.equals(target)) {
            if (min == 0) {
                min = d;
            } else {
                min = Math.min(d,min);
            }
            return;
        }
        for (int i=0;i<perm.length;i++) {
            if (perm[i] == 0 && getDiff(s,words[i]) == 1) {
                perm[i] = 1;
                dfs(d+1,perm,words[i]);
                perm[i] = 0;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        this.target = target;
        this.words = words;
        dfs(0,new int[words.length],begin);
        return min;
    }
}
