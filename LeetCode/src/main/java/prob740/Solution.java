package prob740;

import java.util.*;

public class Solution {
    public int solveTopDownWay(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        Map<Integer,Integer> cache = new HashMap<>();
        int mx = Integer.MIN_VALUE;
        for (int num:nums) {
            mp.put(num,mp.getOrDefault(num,0)+num);
            mx = Math.max(mx,num);
        }
        return getMax(mp,cache,mx);
    }

    private int getMax(Map<Integer,Integer> mp, Map<Integer,Integer> cache, int num) {
        if (num == 0) return 0;
        if (num == 1) return mp.getOrDefault(num,0);
        if (cache.containsKey(num)) return cache.get(num);
        int res = Math.max(getMax(mp,cache,num-1),getMax(mp,cache,num-2)+mp.getOrDefault(num,0));
        cache.put(num,res);
        return res;
    }

    public int solveBottomUpWay(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int mx = Integer.MIN_VALUE;
        for (int num:nums) {
            mp.put(num,mp.getOrDefault(num,0)+num);
            mx = Math.max(mx,num);
        }
        int oneback = mp.getOrDefault(1,0);
        int twoback = 0;
        int res = mp.getOrDefault(1,0);
        for (int i=2;i<=mx;++i) {
            res = Math.max(oneback,twoback+mp.getOrDefault(i,0));
            twoback = oneback;
            oneback = res;
        }
        return res;
    }

    public int deleteAndEarn(int[] nums) {
        //return solveTopDownWay(nums);
        return solveBottomUpWay(nums);
    }
}
