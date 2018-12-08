package LeetCode0540_SingleElementInASortedArray;

public class SingleElementInASortedArray {
	public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = l +(r - l) / 2;
            if(nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) return nums[m];
            if(nums[m] == nums[m - 1]) {
                if((m - l) % 2 == 0) {
                    r = m - 2;
                }else{
                    l = m + 1;
                }
            }else if(nums[m] == nums[m + 1]) {
                if((r - m) % 2 == 0) {
                    l = m + 2;
                }else{
                    r = m - 1;
                }
            }
        }
        return nums[l];
    }
}
