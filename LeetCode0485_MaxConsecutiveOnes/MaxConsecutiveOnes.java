package LeetCode0485_MaxConsecutiveOnes;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutive = 0;
        
        for(int i = 0; i < nums.length; i++){
            int temp = 0;
            while(i < nums.length && nums[i] == 1){
                temp++;
                i++;
            }
            maxConsecutive = Math.max(maxConsecutive, temp);
        }
        return maxConsecutive;
    }
}