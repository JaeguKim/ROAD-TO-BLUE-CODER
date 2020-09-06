// Time : O(N^4)
// Space : O(N^2)
class Solution {
    
    int globalW;
    int W;
    int[][] B;
    int[][] patternMap;

    int[][] getCurrentMap(int r_offset,int c_offset){
        int[][] newTargetMap = new int[globalW][globalW];
        for (int i=0; i<W; i++){
            for (int j=0; j<W; j++){
                newTargetMap[r_offset+i][c_offset+j] = B[i][j];
            }
        }
        return newTargetMap;
    }

    int getOverlap(int[][] targetMap){
        int overlap = 0;
        for (int i=W; i<2*W; i++){
            for (int j=W; j<2*W; j++){
                if (targetMap[i][j] == 1 && patternMap[i][j] == 1){
                    overlap += 1;
                }
            }
        }
        return overlap;
    }
    
    public int largestOverlap(int[][] A, int[][] B) {
            W = A.length;
            globalW = 3*W;
            patternMap = new int[globalW][globalW];
            this.B = B;
            int ans = 0;
        
            for (int i=W; i<2*W; i++){
                for (int j=W; j<2*W; j++){
                    patternMap[i][j] = A[i-W][j-W];
                }
            }
            
            for (int r_offset=1; r_offset<2*W; r_offset++){
                for (int c_offset=1; c_offset<2*W; c_offset++){
                    int[][] targetMap = getCurrentMap(r_offset,c_offset);
                    ans = Math.max(ans,getOverlap(targetMap));
                }
            }
            
        return ans;
    }
}

// Better Solution
// Space : O(1)
// Time : O(N^4)

class Solution {
    private int shift_count(int[][] A, int[][] B){
        int n = A.length, count = 0;
        for (int x = 0; x < n; ++x){
            for (int y = 0; y < n; ++y) {
                int temp = 0;
                for (int i = 0; i < n; ++i){
                    for (int j=0; j<n; ++j){
                        if (A[i][j] == 1 && B[i-y][j-x] == 1) temp++;
                    }
                }
                count = Math.max(count,temp);
            }
        }
        return count;
    }

    public int largestOverlap(int[][] A, int[][] B){
        return Math.max(shift_count(A,B),shift_count(B,A));
    }
}