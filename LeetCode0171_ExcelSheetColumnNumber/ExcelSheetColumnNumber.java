package LeetCode0171_ExcelSheetColumnNumber;

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
        int sum = 0;
        int n = s.length();
        for(int i = n - 1; i >= 0; i--) {
            int temp = (s.charAt(i) - 'A') + 1;
            sum += temp * Math.pow(26, n - i - 1);
        }
        return sum;
    }	
}