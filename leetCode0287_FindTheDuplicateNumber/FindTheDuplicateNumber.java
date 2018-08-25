package leetCode0287_FindTheDuplicateNumber;

public class FindTheDuplicateNumber {
	 public int findDuplicate(int[] nums) {
	        int walker = nums[0];
	        int runner = nums[nums[0]];
	        while(walker != runner) {
	            walker = nums[walker];
	            runner = nums[nums[runner]];
	        }
	        
	        int find = 0;
	        while(find != walker) {
	            walker = nums[walker];
	            find = nums[find];
	        }
	        
	        return walker;
	    }	
}