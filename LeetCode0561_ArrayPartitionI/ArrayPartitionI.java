package LeetCode0561_ArrayPartitionI;

import java.util.Arrays;

public class ArrayPartitionI {
public int arrayPairSumI(int[] nums) {
        
        nums =  mergeSort(nums, 0, nums.length - 1);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i = i + 2){
            sum = sum + nums[i];
        }
        
        return sum;
    }
    
    private static int[] mergeSort(int[] nums, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;
            mergeSort(nums, left, middle);
            mergeSort(nums, middle + 1, right);
            merge(nums, left, middle, right);
        }
        return nums;
    }
    
    private static void merge(int[] nums, int left, int middle, int right){
        int[] l = Arrays.copyOfRange(nums, left, middle + 1);
        int[] r = Arrays.copyOfRange(nums, middle + 1, right + 1);
        
        int i = 0;
        int j = 0;
        
        for(int k = left; k <= right; k++){
             if(i >= l.length){
                nums[k] = r[j];
				j++;
				continue;
            }
            if(j >= r.length){
                nums[k] = l[i];
				i++;
				continue;
            }
            
            if(l[i] <= r[j]){
                nums[k] = l[i];
                i++;
            }else{
                nums[k] = r[j];
                j++;
            }
        }
    }
 
    public int arrayPairSumII(int[] nums){
        int[] arr = new int[20001];
        int lim = 10000;
        
        for(int i = 0; i < nums.length; i++){
            arr[nums[i] + lim]++;
        }
        
        int i = -10000, sum = 0;
        boolean first = true;
        
        while(i <= 10000){
            if(arr[lim + i] == 0){
                i++;
                continue;
            }
            if(first){
                sum += i;
                first = !first;
            }else{
                first = !first;
            }
            
            arr[lim + i]--;
        }
        
        return sum;
    }
    
    public int arrayPairSumIII(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            //if(sum!=0) System.out.println("sum: "+ sum + ", i:" + i );
            //d = (2 + arr[i + lim] - d) % 2;
            d = (arr[i + lim] + d) % 2;
        }
        return sum;
    }
}