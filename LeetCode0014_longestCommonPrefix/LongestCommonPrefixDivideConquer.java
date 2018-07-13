package LeetCode0014_longestCommonPrefix;


public class LongestCommonPrefixDivideConquer {
	private static String solution(String[] strs) {
		if(strs == null || strs.length == 0) {
			return "";
		}
		
		return MergeSort(strs, 0, strs.length - 1); 
	}
	public static String MergeSort(String[] strs, int left, int right) {
		String lcp = null;
		if(left == right){ 
			return strs[left];
		
		}else{
			int middle = (left + right) / 2;
			String lcpLeft = MergeSort(strs, left, middle);
			String lcpRight = MergeSort(strs, middle + 1, right);
			
			lcp = Merge(lcpLeft, lcpRight);
		}
		return lcp;
	}
	
	public static String Merge(String left, String right) {
		System.out.println("left:" + left);
		System.out.println("right:" + right);
		int minLength = Math.min(left.length(), right.length());
		
		for(int i = 0; i < minLength; i++) {
			if(left.charAt(i) != right.charAt(i)) {
				return left.substring(0, i);
			}
		}
		return left.substring(0, minLength);
	}
	
	public static void main(String[] args) {
		String[] input = {"flower","flow","flight"};
		String res = solution(input);
		System.out.println(res);
	}
	
}