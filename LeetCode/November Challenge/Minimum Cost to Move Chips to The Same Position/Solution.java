//모든 칩의 위치를 1-2로 변환하고 각각을 카운팅
//시간복잡도 O(N), 공간복잡도 O(1)
class Solution {
    public int minCostToMoveChips(int[] position) {
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : position){
            int convertedNum = num%2+1;
            if (convertedNum == 1) cnt1 += 1;
            else cnt2 += 1;
        }
        if (cnt1 == 0 || cnt2 == 0) return 0;
        return Math.min(cnt1,cnt2);
    }
}