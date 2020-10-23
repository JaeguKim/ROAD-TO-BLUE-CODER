import java.util.HashSet;

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

// 배열을 돌면서 hashSet에 rank를 넣는다
// 배열을 돌면서 rank+1의 사람이 존재하면 카운트를 증가시킨다
// 카운트를 리턴한다
class Solution {
    public int solution(int[] ranks) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int rank : ranks){
            hashSet.add(rank);
        }
        int cnt = 0;
        for (int rank : ranks){
            if (hashSet.contains(rank+1)){
                cnt +=1;
            }
        }
        return cnt;
    }
}
