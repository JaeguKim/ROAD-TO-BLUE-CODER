import java.util.ArrayList;
import java.util.List;

// TIME COMPLEXITY : O(N^2)
class Solution {
    public int maxDistToClosest(int[] seats) {
        List<Integer> emptySeats = new ArrayList<>();
        List<Integer> occupiedSeats = new ArrayList<>();
        for (int i=0; i<seats.length; i++){
            if (seats[i] == 0) emptySeats.add(i);
            else occupiedSeats.add(i);
        }
        int ans = Integer.MIN_VALUE;
        for (int emptySeat : emptySeats){
            int localMin = Integer.MAX_VALUE;
            for (int occupiedSeat : occupiedSeats){
                localMin = Math.min(Math.abs(emptySeat-occupiedSeat),localMin);
            }
            ans = Math.max(ans,localMin);
        }
        return ans;
    }
}

//TIME COMPLEXITY : O(n)
// 연속한 zero의 갯수에 따른 규칙 발견
// e.g. 1 0 1 -> 1+1 / 2 = 1, 1 0 0 1 -> 2+1 / 2 = 1, ... , 1 0 0 0 0 0 1 -> 5+1 / 2 = 3
class Solution2 {
    public int maxDistToClosest(int[] seats) {
        int idx1 = -1; 
        int idx2 = -1;
        int empty = 0;
        int ans = Integer.MIN_VALUE;
        int n = seats.length;

        for (int i=0;i<seats.length;i++){
            if (seats[i] == 1){
                empty = 0;
                if (idx1 == -1) idx1 = i;
                idx2 = i;
            }
            else {
                empty++;
                ans =  Math.max(ans,(empty+1)/2);
            }
        }
        return Math.max(ans,Math.max(idx1,n-1-idx2));
    }
}