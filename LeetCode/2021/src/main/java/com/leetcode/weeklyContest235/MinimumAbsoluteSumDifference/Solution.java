package com.leetcode.weeklyContest235.MinimumAbsoluteSumDifference;

import java.util.TreeSet;

public class Solution {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        int sum=0, dif=0, m=(int)1e9+7;
        for(int i=0;i<nums1.length;i++) {
            sum=(sum+Math.abs(nums1[i]-nums2[i]))%m;
            set.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++) {
            int tmp=Math.abs(nums1[i]-nums2[i]);
            if(set.floor(nums2[i])!=null)
                dif=Math.max(dif,tmp-Math.abs(set.floor(nums2[i])-nums2[i]));
            if(set.ceiling(nums2[i])!=null)
                dif=Math.max(dif,tmp-Math.abs(set.ceiling(nums2[i])-nums2[i]));
        }
        return sum-dif;
    }
}
