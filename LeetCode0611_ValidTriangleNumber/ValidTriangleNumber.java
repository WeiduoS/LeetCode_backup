package LeetCode0611_ValidTriangleNumber;

public class ValidTriangleNumber {
	// public int triangleNumber(int[] nums) {
    //     Arrays.sort(nums);
    //     int res = 0, n = nums.length;
    //     for(int i = 0; i < nums.length; i++) {
    //         for(int j = i + 1; j < nums.length; j++) {
    //             int sum = nums[i] + nums[j];
    //             int l = j + 1, r = n;
    //             while(l < r) {
    //                 int m = l + (r - l) / 2;
    //                 if(nums[m] < sum) l = m + 1;
    //                 else r = m;
    //             }
    //             res += l - j - 1;
    //         }
    //     }
    //     return res;
    // }
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = nums.length - 1, res = 0;
        for(; i >= 0; i--) {
            int l = 0, r = i - 1;
            while(l < r) {
                if(nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;
    }
}
