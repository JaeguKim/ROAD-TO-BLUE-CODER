import java.util.HashSet;

class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int minNum = 1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums){
            hashSet.add(num);
        }
        for (int i=0; i<hashSet.size(); i++){
            if (hashSet.contains(minNum)){
                minNum++;
            }
        }
        return minNum;
    }
}