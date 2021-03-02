import java.util.HashSet;
import java.util.Set;

class Solution { 
    public int smallestRepunitDivByK(int K) {
        Set<Integer> set = new HashSet<>();
        int rem = 1%K;
        int len = 1;
        while (rem != 0 && !set.contains(rem)){
            set.add(rem);
            rem = (rem*10+1)%K;
            len += 1;
        }

        if (rem == 0){
            return len;
        }
        else {
            return -1;
        }
    }
}