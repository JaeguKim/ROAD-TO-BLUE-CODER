import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
// hashmap에 카운트를 저장
// 두개이상 인것만 리스트에 저장

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        HashMap<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i=0; i<=n-10;i++){
            String subStr = s.substring(i,i+10);
            map.put(subStr,map.getOrDefault(subStr,0)+1);
        }
        for (String key : map.keySet()){
            if (map.get(key) > 1){
                result.add(key);
            }
        }
        return result;
    }
}