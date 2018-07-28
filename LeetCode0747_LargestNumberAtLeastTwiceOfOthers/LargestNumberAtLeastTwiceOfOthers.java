package LeetCode0747_LargestNumberAtLeastTwiceOfOthers;

public class LargestNumberAtLeastTwiceOfOthers {
	 public int dominantIndex(int[] nums) {
	        int largest = -1;
	        int second = -1;
	        int index = 0;
	        
	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] > largest) {
	                largest = nums[i];
	                index = i;
	            }
	        }
	        
	        for(int i = 0; i < nums.length; i++){
	            if(nums[i] > second && nums[i] < largest) {
	                second = nums[i];
	            }
	        }
	        
	        
	        if(largest >= second + second){
	            return index;
	        }
	        return -1;
	    }
}