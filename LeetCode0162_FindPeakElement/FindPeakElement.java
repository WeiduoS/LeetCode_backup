package LeetCode0162_FindPeakElement;

public class FindPeakElement {
	/*
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            if((r - l) <= 1) {
                return binarySearch(nums, l, r);
            }else{
               int m = l + (r - l) / 2;
                if(nums[m] > nums[m - 1] && nums[m] > nums[m + 1]){
                    return m;
                }
                if(nums[m - 1] > nums[m]){
                    r = m;
                }else if(nums[m + 1] > nums[m]){
                    l = m;
                } 
            }
        }
        return 0;
    }
    
    private int binarySearch(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        return nums[l] >= nums[r] ? l : r;
    }*/
    // optimize solution 
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1])
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}