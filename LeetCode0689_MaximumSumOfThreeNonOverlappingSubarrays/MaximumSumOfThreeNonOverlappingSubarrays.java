package LeetCode0689_MaximumSumOfThreeNonOverlappingSubarrays;

public class MaximumSumOfThreeNonOverlappingSubarrays {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int sum = 0;
        int[] sums = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k - 1) sums[i - k + 1] = sum;
        }
        //System.out.println(Arrays.toString(sums));
        
        int left_max = 0;
        int[] left_sum = new int[sums.length];
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] > sums[left_max]) left_max = i;
            left_sum[i] = left_max;
        }
        //System.out.println(Arrays.toString(left_sum));
        
        int right_max = sums.length - 1;
        int[] right_sum = new int[sums.length];
        for(int i = sums.length - 1; i >= 0; i--) {
            if(sums[i] >= sums[right_max]) right_max = i;
            right_sum[i] = right_max;
        }
        
        //System.out.println(Arrays.toString(right_sum));
        
        int[] res = new int[]{0, k, (2 * k)};
        for(int j = k; j < sums.length - k; j++) {
            int l = left_sum[j - k], r = right_sum[j + k];
            if(res[0] == -1 || sums[l] + sums[j] + sums[r] > sums[res[0]] + sums[res[1]] + sums[res[2]]) {
                res[0] = l;
                res[1] = j;
                res[2] = r;
            }
        }
        return res;
        
    }
}
