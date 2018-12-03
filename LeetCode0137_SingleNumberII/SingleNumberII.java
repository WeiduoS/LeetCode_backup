package LeetCode0137_SingleNumberII;

public class SingleNumberII {
	 // solution 1: record each bit, the third times change the 1 bit to 0
    /*
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int num : nums) {
                sum += ((num >>> i) & 1);
            }
            res |= (sum % 3) << i;
        } 
        return res;
    }*/
    /*
    public int singleNumber(int[] nums) {
        int one = 0, two = 0, three = 0;
        for(int num : nums) {
            two |= one & num;
            one ^= num;
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }*/
    
    /* 00 (+) 1 = 01
     * 
     * 01 (+) 1 = 10
     * 
     * 10 (+) 1 = 00 ( mod 3)
     * 
     * 那么我们用ab来表示开始的状态，对于加1操作后，得到的新状态的ab的算法如下：
     *
     * b = b xor r & ~a;
     * 
     * a = a xor r & ~b;
     *
     * 我们这里的ab就是上面的三种状态00，01，10的十位和各位，刚开始的时候，a和b都是0，当此时遇到数字1的时候，b更新为1，a更新为0，就是01的状态；再次
     * 到1的时候，b更新为0，a更新为1，就是10的状态；再次遇到1的时候，b更新为0，a更新为0，就是00的状态，相当于重置了；最后的结果保存在b中。明白了上面
     * 分析过程，就能写出代码如下；*/
    public int singleNumber(int[] nums) {
        int one = 0, two = 0;
        for(int num : nums) {
            one = (one ^ num) & ~two;
            two = (two ^ num) & ~one;
        }
        return one;
    }
}
