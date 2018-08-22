package LeetCode0153_FindMinimumInRotatedSortedArray;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = (l + r) / 2;
            //System.out.println(m);
            if(nums[l] <= nums[m]) {
                if(nums[l] < nums[r]) {
                    r = m - 1;
                }else{
                    l = m + 1;
                }
            }else if(nums[m] <= nums[r]){
                if(nums[l] < nums[r]) {
                    l = m;
                }else{
                    r = m;
                }
            }
        }
        return nums[l]; 
    }	
}