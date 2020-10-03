import java.util.HashMap;
import java.util.HashSet;

public class KDiffPairsInAnArray
{
    public int findPairs(int[] nums, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        int res = 0;
        if (k == 0){
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for (int num : nums){
                int val = hashMap.getOrDefault(num,0);
                hashMap.put(num,val+1);
            }
            for (int num : hashMap.keySet()){
                int val = hashMap.get(num);
                if (val > 1){
                    res++;
                }
            }
        }
        else {
            for (int num : nums){
                hashSet.add(num);
            }
            for (int key : hashSet){
                if (hashSet.contains(key+k)){
                    res++;
                }
            }
        }
        return res;
    }
}
