package LeetCode0035_SearchInsertPosition;

public class SearchInsertPosition {
	/*
    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        return pos >= 0 ? pos : -pos - 1;
    }*/
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                return m;
            }else if(nums[m] < target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return nums[l] < target ? l + 1 : l;
    }
}
