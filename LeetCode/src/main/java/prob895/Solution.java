package prob895;

import java.util.*;

public class Solution {

}

class FreqStack {

    Map<Integer,Integer> mp;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public FreqStack() {
        mp = new HashMap<>();
        group = new HashMap<>();
    }

    public void push(int val) {
        int freq = mp.getOrDefault(val,0)+1;
        mp.put(val,freq);
        group.computeIfAbsent(freq, z->new Stack<>()).push(val);
        maxFreq = Math.max(maxFreq,freq);
    }

    public int pop() {
        int k = group.get(maxFreq).pop();
        mp.put(k,mp.get(k)-1);
        if (group.get(maxFreq).size() == 0) maxFreq--;
        return k;
    }
}