// O(n*m*k) , n: word length, m: dict elem, k: dictWordLength
import java.util.HashSet;
import java.util.List;

public class WordDict {

    public boolean bruteForce(String s, List<String> wordDict,HashSet<Integer> hashSet, int idx){
        if (s.isEmpty()){
            return true;
        }        
        else if (hashSet.contains(idx)){
            return false;
        }
        hashSet.add(idx);
        for (String word:wordDict){
            if (s.indexOf(word) == 0){
                if (bruteForce(s.substring(word.length()),wordDict,hashSet,idx+word.length())) return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<Integer> hashSet = new HashSet<>();
        return bruteForce(s,wordDict,hashSet,0);
    }
}
