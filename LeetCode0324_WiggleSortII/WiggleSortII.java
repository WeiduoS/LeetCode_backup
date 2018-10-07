package LeetCode0324_WiggleSortII;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int len = nums.length;
        int median = quickSelect(nums, 0, len - 1, (len + 1) / 2);
        //System.out.println(median);
        int left = 0, right = len - 1, i = 0;
        
        while(i <= right) {
           if(nums[mapIndex(i, len)] > median) {
               swap(nums, mapIndex(left++, len), mapIndex(i++, len));
           }else if(nums[mapIndex(i, len)] < median) {
               swap(nums, mapIndex(right--, len), mapIndex(i, len));
           }else{
               i++;
           }
        }
    }
    
    private int mapIndex(int index, int n) {
        return (2 * index + 1) % (n | 1);
    }
    private int quickSelect(int[] nums, int left, int right, int median) {
        if(left == right) return nums[left];
        int index = partition(nums, left, right);
        if(index == median) {
            return nums[index];
        }else if(index < median) {
            return quickSelect(nums, index + 1, right, median);
        }else{
            return quickSelect(nums, left , index - 1, median);
        }
    }
    
    private int partition(int[] nums, int l, int r) {
        int pivot = r;
        int index = l;
        for(int i = l; i < r; i++) {
            if(nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, index, pivot);
        return index;
    }
    private void swap(int[] nums, int first, int second) {
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }
}