class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[] tempRow = new int[m];

        for (int i=0; i<n; i++){
            for (int j=0;j<m;j++){
                int flippedBit = A[i][m-1-j];
                int invertedBit = flippedBit == 1 ? 0 : 1;
                tempRow[j] = invertedBit;
            }
            for (int j=0;j<m;j++){
                A[i][j] = tempRow[j];
            }
        }
        return A;
    }
}