package LeetCode0744_FindSmallestLetterGreaterThanTarget;

public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(letters[m] <= target) {
                l = m + 1;
            }else{
                r = m;
            }
        }
        //return Math.abs((letters[l] - '0') - (target - '0')) > Math.abs(target - '0' - (letters[r] - '0')) ? letters[l] : letters[l];
        return letters[l % letters.length];
    }	
}