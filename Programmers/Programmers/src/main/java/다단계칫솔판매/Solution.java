package 다단계칫솔판매;

import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<String, String> mapToParent = new HashMap<>();
    Map<String, Integer> mapToGain = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        for (int i = 0; i < enroll.length; i++) {
            mapToParent.put(enroll[i], referral[i]);
            mapToGain.put(enroll[i], 0);
        }
        for (int i = 0; i < seller.length; i++) {
            String curSeller = seller[i];
            int total = 100 * amount[i];
            while (curSeller.equals("-") == false) {
                int gainSoFar = mapToGain.get(curSeller);
                int commission = (int) (total * 0.1);
                int curGain = total - commission;
                if (commission < 1) {
                    curGain = total;
                }
                mapToGain.put(curSeller, gainSoFar + curGain);
                curSeller = mapToParent.get(curSeller);
                total = commission;
            }
        }
        int[] ans = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            ans[i] = mapToGain.get(enroll[i]);
        }
        return ans;
    }
}