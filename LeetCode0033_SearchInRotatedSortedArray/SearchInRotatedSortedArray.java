package LeetCode0033_SearchInRotatedSortedArray;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int m = (r + l) / 2;
            if(nums[m] == target) {
                return m;
            }else if(nums[l] <= nums[m]) {
                if(target < nums[m] && target >= nums[l]) {
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else if(nums[m] <= nums[r]) {
                if(target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                }else{
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}