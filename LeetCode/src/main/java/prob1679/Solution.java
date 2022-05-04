package prob1679;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxOperations(int[] nums, int k) {
//        Map<Integer,Integer> mp = new HashMap<>();
//        for (int num : nums) {
//            mp.put(num,mp.getOrDefault(num,0)+1);
//        }
//        int res = 0;
//        for (int num : nums) {
//            if (mp.get(num) > 0 && mp.containsKey(k-num) && mp.get(k-num) > 0) {
//                if (num != k-num || (num == k-num && mp.get(num) > 1)) {
//                    mp.put(num,mp.get(num)-1);
//                    mp.put(k-num,mp.get(k-num)-1);
//                    res++;
//                }
//            }
//        }
//        return res;
        return moreSimpleSolution(nums, k);
    }

    public int moreSimpleSolution(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int x : mp.keySet()) {
            if (k % 2 == 0 && x == k / 2) {
                res += mp.get(x) / 2;
            } else {
                res += Math.min(mp.get(x), mp.getOrDefault(k - x, 0));
                mp.put(x, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxOperations(new int[]{1, 2, 3, 4}, 5));
        System.out.println(sol.maxOperations(new int[]{3, 1, 3, 4, 3}, 6));
    }
}
