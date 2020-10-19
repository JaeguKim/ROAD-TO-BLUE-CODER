import java.util.HashMap;


// 같은 수로 만들수있는 후보 수를 찾는다(6*n)
// 후보군의 수가 0이면 -1
// 아니면 각각의 후보군을 대상으로 최소한의 뒤집는수를 찾아서
// 최소값을 리턴

// 위 아래 hashmap 각각두고 위에만있는경우 위에 푸시, 아래만 있는경우 아래에 푸시 ,둘다 있는경우 한쪽에 푸시
// 이때 1-6 중에서 hashmap에 있는 원소 합이 n이면 후보이고 이때의 최소뒤집는 경우의수를 저장
// 후보군 각각에 대해서 위를 반복하며 최소값을 갱신
// 시간 복잡도 : O(n*2+6)
public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        HashMap<Integer,Integer> up = new HashMap<>();
        HashMap<Integer,Integer> bottom = new HashMap<>();
        HashMap<Integer,Integer> totCnt = new HashMap<>();
        int n = A.length;
        for (int i=0; i<n; i++){
            if (A[i] != B[i]){
                int upCnt = up.getOrDefault(A[i], 0);
                up.put(A[i],upCnt+1);
                totCnt.put(A[i],totCnt.getOrDefault(A[i],0)+1);

                int bottomCnt = bottom.getOrDefault(B[i],0);
                bottom.put(B[i],bottomCnt+1);
                totCnt.put(B[i],totCnt.getOrDefault(B[i],0)+1);
            }
            else{
                totCnt.put(A[i],totCnt.getOrDefault(A[i],0)+1);
            }
        }
        int cnt = 0;
        int minVal = Integer.MAX_VALUE;
        for (int i=1;i<=6;i++){
            int upCnt = up.getOrDefault(i,0);
            int bottomCnt = bottom.getOrDefault(i,0);
            if (totCnt.getOrDefault(i,0) == n){
                cnt += 1;
                minVal = Math.min(minVal,Math.min(upCnt,bottomCnt));
            }
        }
        if (cnt == 0) return -1;
        return minVal;
    }
}
