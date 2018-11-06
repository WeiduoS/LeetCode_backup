package LeetCode0414_ThirdMaximumNumber;

public class ThirdMaximumNumber{
	public int thirdMax(int[] nums) {
        long first = nums[0];
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        /*
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > first) {
                first = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < first && nums[i] > second) {
                second = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < second && nums[i] > third) {
                third = nums[i];
            }
        }*/
        
         for(int i = 1; i < nums.length; i++) {
             //System.out.println(nums[i]);
             if(nums[i] > first) { 
                 third = second;
                 second = first;
                 first = nums[i];
             }else if(nums[i] > second && nums[i] < first) { // if(nums[i] > second) use for unique number
                 third = second;
                 second = nums[i];
             }else if(nums[i] > third && nums[i] < second) { // if(nums[i] > third) use for unique number
                 third = nums[i];
             }
             //System.out.println("first: " + first + ", second: " + second + ", third: "+ third);
             
        }
        
        return (int)(third == Long.MIN_VALUE ? first : third);
    }
}