import java.util.HashMap;

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            if (hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),hashMap.get(s.charAt(i))+1);
            }
            else {
                hashMap.put(s.charAt(i),1);
            }
        }

        char ans = 'a';

        for (int i=0; i<t.length(); i++){
            if (hashMap.containsKey(t.charAt(i))){
                hashMap.put(t.charAt(i),hashMap.get(s.charAt(i))-1);
                if (hashMap.get(s.charAt(i)) == 0){
                    hashMap.remove(s.charAt(i));
                }
            }
            else {
                ans = t.charAt(i);
                break;
            }
        }
        return ans;
    }
}