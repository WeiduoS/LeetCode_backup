package LeetCode0075_SortColors;

public class SortColors {
	public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length - 1;
        for(int i = 0; i < nums.length;) {
            if(nums[i] == 0 && i > zeroIndex) {
                swap(nums, i, zeroIndex++);
            }else if(nums[i] == 2 && i < twoIndex) {
                swap(nums, i, twoIndex--);
            }else{
                i++;   
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }	
}