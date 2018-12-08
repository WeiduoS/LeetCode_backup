package LeetCode0031_NextPermutation;

import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
	        if(nums.length <= 1) return;
	        int i = nums.length - 2;
	        while(i >= 0) {
	            if(nums[i] < nums[i + 1]) break;
	            i--;
	        }
	        
	        if(i == -1) { // 6 5 4 3 2 1
	            Arrays.sort(nums);
	            return;
	        }

	        int j = i + 1;
	        System.out.println("j: " + j);
	        while(j < nums.length && nums[j] > nums[i]) {
	            j++;
	        }
	        
	        nums[i] ^= nums[j - 1];
	        nums[j - 1] ^= nums[i];
	        nums[i] ^= nums[j - 1];
	        Arrays.sort(nums, i + 1, nums.length);
	        return;
	}
}
