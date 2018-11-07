package LeetCode0081_SearchInRotatedSortedArrayII;

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        if(nums.length == 0) return false;
        int l = 0, r = nums.length - 1;
        while(l < r) {
            //System.out.println("l: " + l + ", r: " + r);
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                return true;
            }else if(nums[m] == nums[l]){
                l++; 
            }else if(nums[l] <= nums[m]) {
                if(target < nums[m] && target >= nums[l]) {
                    r = m - 1;
                }else{
                    l = m;
                }
            }else if(nums[m] <= nums[r]) {
                if(target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                }else{
                    r = m;
                }
            }
        }
        
        return nums[l] == target;
    }	
}