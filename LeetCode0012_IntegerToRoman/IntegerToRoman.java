package LeetCode0012_IntegerToRoman;

public class IntegerToRoman {
	private static String solution(int num) {
		/*
		 *  I   V   X   L   C   D   M
		 *  1   5   10  50  100 500 1000
		 *  
		 *  3: III
		 * *4: IV
		 * *9: IX
		 *  58: LVIII
		 *  1994: MCMXCIV
		 *  
		 *  4: IV
		 *  40: XL
		 *  400: CD
		 *  9: IX
		 *  90: XC
		 *  900: CM
		 */
		int[] arabrics =  new int[]   {1000, 900, 500, 400,  100,  90,  50,  40,  10,   9,    5,    4,    1};
		String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < arabrics.length; i++) {
			while(num - arabrics[i] >= 0) {
				sb.append(romans[i]);
				num = num - arabrics[i]; 
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		String res = solution(3);
		System.out.println(res);
	}
} 