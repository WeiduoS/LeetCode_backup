package LeetCode0026_RemoveDuplicatesFromSortedArray;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int i = 0;
        int j = 1;
        /*
        for(int j = 1; j < len; j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;*/
        
        while(j < len){
            if(nums[j] == nums[i] && j < len){
                j++;
            }else{
                i++;
                nums[i] = nums[j];
                j++; 
            }
        }
        
        return i + 1;
        
    }
}