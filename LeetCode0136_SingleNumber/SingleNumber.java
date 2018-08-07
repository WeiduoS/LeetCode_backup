package LeetCode0136_SingleNumber;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SingleNumber {
	// solution 1: XOR
    public int singleNumberI (int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum = sum ^ nums[i];
        }
        return sum;
    }
    
    // solution 2: HashMap
    public int singleNumberII (int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }else{
                set.add(nums[i]); 
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}