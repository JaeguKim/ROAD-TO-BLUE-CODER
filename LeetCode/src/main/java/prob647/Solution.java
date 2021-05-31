package prob647;

class Solution {

    public int getCnt(char[] arr, int left, int right) {
        int cnt = 0;
        while (left >= 0 && right < arr.length && arr[left] == arr[right]) {
            cnt++; left--; right++;
        }
        return cnt;
    }

    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int ans = s.length();
        for (int i=1;i<=arr.length-1;i++) {
            ans += getCnt(arr,i-1,i+1);
            ans += getCnt(arr,i-1,i);
        }
        return ans;
    }
}
