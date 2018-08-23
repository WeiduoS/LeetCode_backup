package LeetCode0034_FindFirstAndLastPositionOfElementInSortedArray;

public class FindFirstAndLastPositionOfElementInSortedArray {
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1, -1};
        int first = findFirst(nums, target);
        if(first == -1) return new int[] {-1, -1};
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    private int findFirst(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                r = m;
            }else if(nums[m] > target) {
                r = m;
            }else if(nums[m] < target) {
                l = m;
            }
        }

        if(nums[l] == target) return l;
        if(nums[r] == target) return r;
        return -1;
    }
    private int findLast(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l + 1 < r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                l = m;
            }else if(nums[m] < target) {
                l = m;
            }else if(nums[m] > target) {
                r = m;
            }
        }

        if(nums[r] == target) return r;
        if(nums[l] == target) return l;
        return -1;
    }
}