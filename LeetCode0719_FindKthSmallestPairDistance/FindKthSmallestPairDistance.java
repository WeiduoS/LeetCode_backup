package LeetCode0719_FindKthSmallestPairDistance;

import java.util.Arrays;

public class FindKthSmallestPairDistance {
	
    public int smallestDistancePairI(int[] nums, int k) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        
        int[] sameValueRcord = new int[nums.length];
        sameValueRcord[0] = 0;
        // it solves the problems that:
        // 1 -> 3      1 relation
        
        // 1 -> 3
        // | /         3 relations 1 to 3 + 1 to 3 + 1 to another 1
        // 1 
        
        // 1 -> 3
        // | /  |      6 relations 1 to 3 + 1 to 3 + 1 to 3 + 1 to second 1 + 1 to third 1 + second 1 to third 1
        // 1   /
        // | /
        // 1
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]) {
               sameValueRcord[i] = sameValueRcord[i - 1] + 1; 
            }
        }
        // System.out.println(Arrays.toString(sameValueRcord));
        
        // implement the preSum of the number less than the current one;
        int[] distance = new int[nums[nums.length - 1] * 2];
        int preSum = 0;
        for(int i = 0; i < distance.length; i++) {
            while(preSum < nums.length && nums[preSum] == i) {
                preSum++;
            }
            distance[i] = preSum;
        }
        // System.out.println(Arrays.toString(distance));
        int l = 0;
        int r = nums[nums.length - 1];
        while(l < r) {
            int m = l + (r - l) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                count = count + distance[nums[i] + m] - distance[nums[i]] + sameValueRcord[i];
            }
            
            if(count >= k) {
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }
    public int smallestDistancePairII(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums[nums.length - 1] - nums[0];
        while(l < r) {
            int m = l + (r - l) / 2;
            int count = 0;
            int j = 0;
            System.out.println("l: " + l + ", m: " + m + ", r: " + r);
            for(int i = 0; i < nums.length; i++) {
                while(j < nums.length && nums[j] - nums[i] <= m) {
                    j++;
                }
                // the j can be the number 1 larger than the candidate
                count = count + j - 1 - i;
            }
            if(count >= k) {
                r = m;
            }else{
                l = m + 1;
            }
        }
        return l;
    }	
}
