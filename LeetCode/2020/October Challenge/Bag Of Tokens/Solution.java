import java.util.Arrays;


class Solution {

    public int bagOfTokensScore(int[] tokens, int P) {
        if (tokens.length == 0) return 0;
        int left = 0;
        int right= tokens.length-1;
        int maxScore = 0;
        int score = 0;
        Arrays.sort(tokens);
        while (left < right){
            if (tokens[left] <= P){
                left += 1;
                score += 1;
                maxScore = Math.max(maxScore,score);
            }
            else if (P >= 1){
                score -= 1;
                P -= tokens[right--];
            }
            else {
                return maxScore;
            }
        }
        return maxScore;
    }
}
