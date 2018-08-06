package LeetCode0283_MoveZeroes;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        if (nums.length == 0) return;
        /*
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[start++] = nums[i];
            }
        }
        
        while (start < nums.length) {
            nums[start++] = 0;
        }*/
        
        for(int i = 0, j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i++] = temp;
            }
        }
    }
}