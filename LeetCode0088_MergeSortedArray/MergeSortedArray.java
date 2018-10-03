package LeetCode0088_MergeSortedArray;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = n - 1;
        int k = m + n - 1;
        while(left > -1 && right > -1) {
            //System.out.println("left: " + left + ", right: " + right + ", k: " + k + " " + Arrays.toString(nums1));
            if(nums1[left] >= nums2[right]) {
                nums1[k--] = nums1[left--];
            }else{
                nums1[k--] = nums2[right--];
            }
        }
        //System.out.println("left: " + left + ", right: " + right + ", k: " + k + " " + Arrays.toString(nums1));
        while(right >= 0) nums1[k--] = nums2[right--];
    }	
}