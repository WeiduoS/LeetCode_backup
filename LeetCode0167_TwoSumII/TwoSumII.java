package LeetCode0167_TwoSumII;

import java.util.HashMap;

public class TwoSumII{
	 public int[] twoSumI(int[] numbers, int target) {
	        HashMap<Integer, Integer> map = new HashMap<>();
	        
	        for(int i = 0; i < numbers.length; i++){
	            int left = target - numbers[i];
	            if(map.containsKey(left) && map.get(left) != i){
	                return new int[] {map.get(left) + 1, i + 1};
	            }
	            map.put(numbers[i], i);
	        }
	        
	        return new int[] {-1, -1};
	    }
	    public int[] twoSumII(int[] numbers, int target) {
	        int begin = 0;
	        int end = numbers.length - 1;
	        
	        while(begin < end){
	            int sum = numbers[begin] + numbers[end];
	            if(sum == target){
	                return new int[] {begin + 1, end + 1};
	            }else if(sum < target){
	                begin++;
	            }else if(sum > target){
	                end--;
	            }
	        }
	        
	        return new int[] {-1, -1};
	    }
}