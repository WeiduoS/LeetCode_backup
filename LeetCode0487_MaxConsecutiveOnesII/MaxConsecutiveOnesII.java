package LeetCode0487_MaxConsecutiveOnesII;

import java.util.LinkedList;
import java.util.Queue;

public class MaxConsecutiveOnesII {
	/*
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0, cnt = 0;
        for(int num : nums) {
            cnt++;
            if(num == 0) {
                cur = cnt;
                cnt = 0;
            }
            res = Math.max(res, cur + cnt);
        }
        return res;
    }*/
    /* 
     * 面的方法有局限性，如果题目中说能翻转k次怎么办呢，我们最好用一个通解来处理这类问题。我们可以维护一个窗口[left,right]来容纳至少k个0。我们遇到了0，
     * 就累加zero的个数，然后判断如果此时0的个数大于k，那么我们我们右移左边界left，如果移除掉的nums[left]为0，那么我们zero自减1。如果不大于k，那么我      * 们用窗口中数字的个数来更新res
     */
    /*
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, zero = 0, left = 0, k = 1;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zero++;
            while(zero > k) {
                if(nums[left++] == 0) --zero;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }*/
    
    // 上面那种方法对于follow up中的情况无法使用，因为nums[left]需要访问之前的数字。我们可以将遇到的0的位置全都保存下来
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, left = 0, k = 1;
        Queue<Integer> queue = new LinkedList<>();
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) queue.offer(right);
            if(queue.size() > k) {
                left = queue.poll() + 1;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
