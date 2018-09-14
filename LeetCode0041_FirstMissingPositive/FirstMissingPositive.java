package LeetCode0041_FirstMissingPositive;

public class FirstMissingPositive {
	/*
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 1;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0) nums[i] = Integer.MAX_VALUE;
        }
        //System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if(num <= n) nums[num - 1] = -Math.abs(nums[num - 1]);
            //System.out.println("nums[i]: " + nums[i] + ", " + Arrays.toString(nums));
        }
        //System.out.println(Arrays.toString(nums));
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) return ++i;
        }
        
        return n + 1;
    }*/
    
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(nums == null || n == 0) return 1;
        for(int i = 0; i < n; i++) {
            /* wrong loop
            if(nums[i] > 0 && nums[i] < n) {
                swap(nums, nums[i] - 1, i);
                System.out.println(Arrays.toString(nums));
            }*/
            while(nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
                //System.out.println("i:" + i + " " + Arrays.toString(nums));   
            }
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] - 1 != i) return i + 1;
        }
        
        return n + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }	
}