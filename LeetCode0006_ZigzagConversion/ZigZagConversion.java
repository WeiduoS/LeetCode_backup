package LeetCode0006_ZigzagConversion;

public class ZigZagConversion{
	private static String solution(String s, int numRows) {
		/*
		 *   PAYPALISHIRING
		 * 
		 * 1-P A H N
		 * 2-APLSIIG
		 * 3-Y I R
		 * 
		 *    number: 0 1 2 3 4 5 6 7 8 9 10 11 12 13
		 *            P A Y P A L I S H I R  I  N  G
		 *     index: 1 2 3 2 1 2 3 2 1 2 3  2  1  2
		 * remainder: 0 1 2 3 0 1 2 3 0 1 2  3  0  1
		 * 
		 * circle = 2 * numRows - 2
		 * index = (2 * numRows - 2) % numRows
		 * 
		 * reminder    index
		 *        0 -> 0
		 *      1:3 -> 1
		 *        2 -> 2
		 * reminder = (reminder < numRows)? reminder : 2 * numRows - 2 - reminder
		 * 
		 * A    D      A    
		 * B    C      B   C
		 * C    B      C B
		 * D    A      D 
		 */
		if(numRows <= 1) return s;
		StringBuilder[] sb = new StringBuilder[numRows];
		for(int i = 0; i < sb.length; i++) {
			sb[i] = new StringBuilder("");
		}
		for(int i = 0; i < s.length(); i++) {
			
			// the circle is 2 * numRows - 2
			int index = i % (2 * numRows - 2);
			//System.out.println(index);
			index = (index < numRows)? index : numRows * 2 - 2 - index;
			sb[index].append(s.charAt(i));
		}
		for(int i = 1; i < sb.length; i++) {
			sb[0].append(sb[i]);
		}
		
		return sb[0].toString();
	}
	
	public static void main(String[] args) {
		String res = solution("PAYPALISHIRING", 3);
		System.out.println(res);
	}
}