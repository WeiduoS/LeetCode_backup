package LeetCode0005_LongestPalindromicSubstring;

public class longestPalindromicSubstringBottonUpManacherAlgorithm{
	
	private static String solution(String s) {
		String res = "";
		
		res = solutionExtend(s);
		
		int n = res.length();
		int[] arr = new int[n];
		int C = 0, R = 0;
		
		for(int i = 1; i < n - 1; i++) {
			int i_mirror = 2*C - i; // equals to i' = C - (i-C)
			
			// the new palindrome affects can not out of the center scope 
			arr[i] = (R > i)? Math.min(R - i, arr[i_mirror]) : 0;
			
			// Attempt to expand palindrome centered at i
			System.out.println(res);
			System.out.println("i + 1 + arr[i]: " + (i + 1 + arr[i]));
			System.out.println("i - 1 - arr[i]: " + (i - 1 - arr[i]));
			while(res.charAt(i + 1 + arr[i]) == res.charAt(i - 1 - arr[i])) {
				arr[i]++;
			}
			
			// If palindrome centered at i expand past R,
		    // adjust center based on expanded palindrome.
			if( i + arr[i] > R) {
				C = i;
				R = i + arr[i];
			}
		}
		
		// Find the maximum element in arr.
		int maxLen = 0;
		int centerIndex = 0;
		for(int i = 1; i < n-1; i++) {
			if (arr[i] > maxLen) {
			      maxLen = arr[i];
			      centerIndex = i;
			    }
		}
		
		System.out.println("maxLen:" + maxLen);
		System.out.println("centerIndex:" + centerIndex);
		/*
		 * a a a a 
		 * 0 1 2 3
		 *   <-*
		 * 
		 * 0 0 1 2 3 4 3 2 1 0 0
		 * ^ # a # a # a # a # $
		 * 0 1 2 3 4 5 6 7 8 9 10
		 *           *
		 * 
		 * maxLen = 4
		 * centerIndex = 5
		 * right = centerIndex / 2 - maxLen / 2 - 1
		 * left = centerIndex / 2 - maxLen / 2
		 *  
		 * 
		 * b a b a d
		 * 0 1 2 3 4;/
		 *   <-*
		 * 
		 * ^ # b # a # b # a #  d  #  $
		 * 0 1 2 3 4 5 6 7 8 9 10 11 12
		 *         *
		 * maxLen:3
		 * centerIndex:4
		 * 
		 * a
		 * 0
		 * <-*
		 * ^ # a # $
		 * 0 1 2 3 4
		 *     *
		 * 
		 * maxLen:1
		 * centerIndex:2
		 * 
		 * centerIndex / 2 - 1 // the right center number of sequence
		 * centerIndex / 2 - 1 + maxLen / 2 // the right bound
		 * centerIndex / 2 - 1 - (maxLen - 1)/ 2 // the left bound
		 * 
		 */
		return s.substring(centerIndex / 2 - 1 - (maxLen - 1)/ 2, centerIndex / 2 - 1 + maxLen / 2 + 1);
	}
	
	private static String solutionExtend(String s) {
		int n = s.length();
		String res = "^";
		
		if(n == 0) return "^$";
		for(int i = 0; i < s.length(); i++) {
			
			res = res + "#" + s.charAt(i);
		}
		res = res + "#$";
		
		return res;
	}
	
	public static void main(String[] args) {
		//String s = "babad";
		//String s = "cbbd";
		//String s = "qqyuqq";
		//String s = "aaaa";
		//String s ="a";
		String s = "babdaf";
		String res = "";
		res = longestPalindromicSubstringBottonUpManacherAlgorithm.solution(s);
		System.out.println(res);
	}
}