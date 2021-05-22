package prob852;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int i=1,j=arr.length-2;
        while (i<=j) {
            int mid = (i+j)/2;
            if (arr[mid] > arr[mid-1] && arr[mid+1] > arr[mid]) i = mid+1;
            else j = mid-1;
        }
        return i;
    }
}