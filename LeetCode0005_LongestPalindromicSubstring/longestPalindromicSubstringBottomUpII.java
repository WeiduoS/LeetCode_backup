package LeetCode0005_LongestPalindromicSubstring;

public class longestPalindromicSubstringBottomUpII{
	
	private static String solution(String s) {
		
		String res = "";
		boolean[][] pal = new boolean[s.length()][s.length()];
		int length = s.length();
		int maxPal = 0;
		
		if(length == 0 || s == null) return s;

		for(int j = 0; j < length; j++) {
				loop2: for(int i = 0; i <= j; i++) {
						System.out.print("i:" + i + "," + "j:" + j +"\n");
						if(j - i <= 2){
							pal[i][j] = s.charAt(i) == s.charAt(j);
						}else {
							//pal[i][j] = s.charAt(i) == s.charAt(j) && solutionExtend( s,  pal, i + 1, j - 1);
							pal[i][j] = s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1];
						}
						System.out.print("pal[i][j]:" + pal[i][j] +"\n");
						if(pal[i][j] == false) {
							continue loop2;
						}else {
							if( (j - i + 1) > maxPal) {
								maxPal = j - i + 1;
								res =  s.substring(i, j + 1);
							}
						}
					}
				}
		
				return res;
			}
	
	
	
	public static void main(String[] args) {
		//String s = "babad";
		//String s = "cbbd";
		//String s = "qqyuqq";
		//String s = "aaaa";
		String s ="a";
		String res = "";
		res = longestPalindromicSubstringBottomUpII.solution(s);
		System.out.println(res);
	}
}