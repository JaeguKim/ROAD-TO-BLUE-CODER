import java.util.ArrayList;
import java.util.List;

// Space Complexity = O(26)
// Time Complexity = O(N), N : length of S
class partitionLabel {
    public List<Integer> partitionLabels(String S) {
        int[] endIdx = new int[26];
        for (int i=0; i<S.length(); i++){
            endIdx[S.charAt(i)-'a'] = i;
        }

        int start = 0, end = 0;
        List<Integer> result = new ArrayList();
        for (int i=0; i<S.length(); i++) {
            end = Math.max(end, endIdx[S.charAt(i)-'a']);
            if (i == end){
                result.add(end-start+1);
                start = i+1;
            }
        }
        return result;
    }
}