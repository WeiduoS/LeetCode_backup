package LeetCode0280_WiggleSort;

public class WiggleSort {
	public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if(i % 2 == 0) {
                if(nums[i] > nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
            if(i % 2 == 1) {
                if(nums[i] < nums[i - 1]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}
