package LeetCode0832_FlippingAnImage;

public class FlippingAnImage {
	public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++) {
            int l = 0, r = A[0].length - 1;
            while(l < r) {
                A[i][l] ^= A[i][r];
                A[i][r] ^= A[i][l];
                A[i][l] ^= A[i][r];
                l++;
                r--;
            }
            for(int j = 0; j < A[0].length; j++) {
                A[i][j] ^= 1;
            }
        }
        
        return A;
    }
}
