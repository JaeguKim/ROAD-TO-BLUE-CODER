class Solution {
    public static int findPivot(int[] nums){
        int l=0;
        int r=nums.length-1;
        while (l<=r){
            int m=(l+r)/2;
            //System.out.println(l);
            //System.out.println(r);
            //System.out.println(m);
            if (m > 0 && nums[m-1] > nums[m] && (m < nums.length-1 && nums[m] <= nums[m+1])){
                return m;
            }
            else if (m==0 || nums[m]>nums[r]){
                l=m+1;
            }
            else if (m==nums.length-1 && m>1 && nums[m-1]>nums[m]){
                return m;
            }
            else {
                r=m-1;
            }
        }
        return -1;
    }

    public static boolean binarySearch(int[] nums,int target,int l,int r){
        while (l<=r){
            int m = (l+r)/2;
            if (nums[m]<target){
                l = m+1;
            }
            else if (nums[m]==target){
                return true;
            }
            else {
                r = m-1;
            }
        }
        return false;
    }

    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        int pivot = findPivot(nums);
        if (pivot == -1){
            return binarySearch(nums, target, 0, nums.length-1);
        }
        return binarySearch(nums, target, 0, pivot-1) || binarySearch(nums, target, pivot, nums.length-1);
    }

    public static void main(String[] args){
        int[][] nums = {{3,1,1,1,1},{2,2,2,2},{1,2,2,5,6,0,0},{1,3,5},{1,2,1},{3,1,1},{2,2,2,0,2,2},{3,1},{1,2,3}};
        for (int[] arr : nums){
            System.out.println(findPivot(arr));
        }
        // System.out.println("TEST search");
        // for (int[] arr : nums){
        //     System.out.println(search(arr,3));
        // }
        
    }
}