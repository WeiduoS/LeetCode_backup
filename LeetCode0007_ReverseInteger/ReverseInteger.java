package LeetCode0007_ReverseInteger;


public class ReverseInteger{
	private static int solution(int x) {
		int res = 0;
		/*
		 * int : -2147483648 ~ 2147483647
		 * 
		 */
		while(x != 0) {
			int temp = 0;
			temp = res * 10 + x % 10;
			x = x / 10;
			
			if(temp / 10 != res) {
				return 0;
			}
			res = temp;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int res; 
		
		res = solution(123); 
		
		System.out.println(res);
	}
}