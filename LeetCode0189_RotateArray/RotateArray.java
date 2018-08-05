package LeetCode0189_RotateArray;

public class RotateArray {
	// Solution 1: extra array
    public void rotateI (int[] nums, int k) {
        int[] arr = new int[nums.length];
        int len = nums.length;
        
        for(int i = 0; i < arr.length; i++){
            arr[(i + k) % len] = nums[i];
        }
        
        for(int i = 0; i < len; i++){
            nums[i] = arr[i];
        }
    }
    
    // Solution 2: reverse the array
    public void rotateII (int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1); 
        reverse(nums, nums.length - k, nums.length - 1); 
        reverse(nums, 0, nums.length - 1); 
    }
    
    private static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    // arrange k numbers each time, the last k numbers depends on the previous loop
    // the len - 2k numbers always rotated by k
    // in the another loop, the number rotate k - (len - 2k)*n times
    // re-set the k and continue the program
    
    //Solution 3: partiton rotation
    public void rotateIII (int[] nums, int k) {
        k = k % nums.length;
        if(k == 0 || k == nums.length) return;
        rotate(nums, k, 0, nums.length);
    }
    
    private static void rotate(int[] nums, int k, int start, int len) {
        //System.out.println("k: " + k + ", start: " + start + ", len: " + len );
        if(start == len - k || k == 0) return;
        for(int i = start; i < start + k; i++){
            int temp = nums[i];
            nums[i] = nums[len - k + (i - start)];
            nums[len - k + (i - start)] = temp;
            //System.out.println(Arrays.toString(nums));
        }
        start = start + k;
        if(start < len - k){
            rotate(nums, k, start, len);
        }else{
            rotate(nums, k - (k/(len - start))*(len - start), start, len);
        }
    }
    
    // solution 4: cycle replacement
    public void rotateIV (int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if(len == 0 || k == 0) return;
        
        int count = 0;
        int curr = 0;
        int change = curr;
        int pre = nums[0];
        
        while(count < nums.length){
            //System.out.println(Arrays.toString(nums));
            //System.out.println("curr: " + curr + ", change: " + change);
            curr = (curr + k) % len;
            int temp = nums[curr];
            nums[curr] = pre;
            
            if(curr == change) {
                curr++;
                change++;
                pre = nums[curr];
            }else{
                pre = temp;  
            }
            
            count++;
        }
    }
    // solution 5
    public void rotateV (int[] nums, int k) {
        if(nums.length == 0) return;
        int rest = nums.length;
        int start = 0;
        
        while(rest > 0 && (k %= rest) > 0) {
            for(int i = 0; i < k; i++){
                int temp = nums[i + start];
                nums[i + start] = nums[rest - k + i + start];
                nums[rest - k + i + start] = temp;
            }
            start = start + k;
            rest = rest - k; 
        }
    }
    
}