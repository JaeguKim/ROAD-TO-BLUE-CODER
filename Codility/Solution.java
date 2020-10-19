import java.util.HashSet;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

//hashset에 숫자저장
//1~100,0000 까지 돌면서 hashSEt에 없는것을 반환
class Solution {
    public int solution(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : A){
            set.add(num);
        }
        int MAX = 1000000;
        for (int i=1;i<=MAX;i++){
            if (set.contains(i) == false){
                return i;
            }
        }
        return -1;
    }
}
