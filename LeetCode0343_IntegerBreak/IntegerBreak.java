package LeetCode0343_IntegerBreak;

public class IntegerBreak {
	public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= i; j++) {
                int temp1 = dp[j] * dp[i - j];
                int temp2 = j * (i - j);
                int temp3 = j * dp[i - j];
                int temp4 = dp[j] * (i - j);
                //System.out.println("j: " + j + ", i - j: " + (i - j));
                //System.out.println("temp1: " + temp1 + ", temp2: " + temp2);
                dp[i] = Math.max(dp[i], Math.max(Math.max(temp1, temp2), Math.max(temp3, temp4)));
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
