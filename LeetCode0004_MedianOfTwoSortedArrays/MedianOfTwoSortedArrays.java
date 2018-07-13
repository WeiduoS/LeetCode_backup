package LeetCode0004_MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays{
	private static double solution (int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		
		if(len1 > len2) return MedianOfTwoSortedArrays.solution(nums2, nums1);
		
		int halfLen = (len1 + len2 + 1) / 2;
		int m = len1 / 2;
		int n = halfLen - m;
		int start = len1 / 2, end = len1;

		while(m <= nums1.length) {
			if(m < nums1.length  && nums1[m] < nums2[n-1]) { // m is too small
				m = m + Math.max((end - start) / 2, 1);
				start = m;
				n = halfLen - m;				
			}else if(m > 0 && nums1[m-1] > nums2[n]) { // m is too large
				m = m - Math.max((end - start) / 2, 1);
				end = m;
				n = halfLen - m;
			}else {
				int maxLeft = 0;
				int minRight = 0;
				//System.out.println("ready m:" + m);
				//System.out.println("ready n:" + n);
				// the maximum left number of median
				if(m == 0) {
					maxLeft = nums2[n-1];
				}else if(n == 0) {
					maxLeft = nums1[m-1];
				}else {
					maxLeft = Math.max(nums1[m-1], nums2[n-1]);
				}
				
				if((len1 + len2) % 2 == 1) {
					return maxLeft;
				}
				// the minimum right number of median
				if(m == nums1.length) {
					minRight = nums2[n];
				}else if (n == nums2.length){
					minRight = nums1[m]; 
				}else {
					minRight = Math.min(nums1[m], nums2[n]);
				}
				
				return (maxLeft + minRight) / 2.0;
			}
			
		}
		return 0.0;
	}
	
	
	public static void main (String[] args) {
		int[] nums1 = {2};
		int[] nums2 = {1,3};
		
		int[] nums3 = {};
		int[] nums4 = {1};
		
		int[] nums5 = {4,5,6};
		int[] nums6 = {1,2,3};
		
		int[] nums7 = {1,2};
		int[] nums8 = {3,4};
		
		int[] nums9 = {1,2,3};
		int[] nums10 = {4,5,6,7};
		
		double result1 = MedianOfTwoSortedArrays.solution(nums1, nums2);
		double result2 = MedianOfTwoSortedArrays.solution(nums3, nums4);
		double result3 = MedianOfTwoSortedArrays.solution(nums5, nums6);
		double result4 = MedianOfTwoSortedArrays.solution(nums7, nums8);
		double result5 = MedianOfTwoSortedArrays.solution(nums9, nums10);
		System.out.println("{2} and {1,3} the median is:" + result1);
		System.out.println("{} and {1} the median is:" + result2);
		System.out.println("{4,5,6} and {1,2,3} the median is:" + result3);
		System.out.println("{1,2} and {3,4} the median is:" + result4);
		System.out.println("{1,2,3} and {4,5,6,7} the median is:" + result5);
	}
	
}