import java.util.HashSet;
import java.util.Set;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] tb = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String word:words){
            String s = "";
            for (char c : word.toCharArray()){
                s+=tb[c-'a'];
            }
            set.add(s);
        }
        return set.size();
    }
}