package LeetCode0644_MaximumAverageSubarrayII;

public class MaximumAverageSubarrayII {
	/*
    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i < sum.length; i++) sum[i] = sum[i - 1] + nums[i - 1];
        double res = -10000;
        for(int i = sum.length - 1; i >= k; i--) {
            for(int j = i - k; j >= 0; j--) {
                res = Math.max(res, (double)(sum[i] - sum[j]) / (i - j));
                //System.out.println("i: " + i + ", j: " + j + ", res: " + res);
            }
        }
        return res;
    }*/
    public double findMaxAverage(int[] nums, int k) {
        double l = 10000, r = -10000;
        for(int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }
        while(r - l > 1e-5) {
            double m = l + (r - l) / 2.0;
            if(check(nums, m, k)) l = m;
            else r = m;
        }
        return l;
    }
    
    private boolean check(int[] nums, double mid, int k) {
        double[] sum = new double[nums.length + 1];
        double pre_min = 100000;
        for(int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] - mid;
            if(i >= k) {
                pre_min = Math.min(pre_min, sum[i - k]);
            }
            if(i >= k && sum[i] > pre_min) {
                return true;
            }
        }
        return false;
    }
}
