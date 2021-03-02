package Search2DMatrix;

// 해당 수가 mid의 첫번째 수보다 작으면 right = mid -1
// 해당 수가 mid의 마지막 수보다 크면 left =mid+1
// row를 찾으면 해당 row에서 binary search

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        if (r == 0) return false;
        int c = matrix[0].length;
        if (c == 0) return false; // [ [] ] 인 경우
        int left = 0;
        int right = r-1;
        int rowIdx = -1;
        while (left <= right){
            int mid = (left+right)/2;
            if (target < matrix[mid][0]){
                right = mid-1;
            }
            else if (target > matrix[mid][c-1]){
                left = mid+1;
            }
            else if (target >= matrix[mid][0] && target <= matrix[mid][c-1]){
                rowIdx = mid;
                break;
            }
        }
        if (rowIdx == -1) return false;
        left = 0;
        right = c-1;
        while (left <= right){
            int mid = (left+right)/2;
            if (target < matrix[rowIdx][mid]){
                right = mid-1;
            }
            else if (target > matrix[rowIdx][mid]){
                left = mid+1;
            }
            else return true;
        }
        return false;
    }
}