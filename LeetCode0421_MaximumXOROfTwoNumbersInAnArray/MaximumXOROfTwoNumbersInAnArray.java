package LeetCode0421_MaximumXOROfTwoNumbersInAnArray;

public class MaximumXOROfTwoNumbersInAnArray {
	// solution 1: bitwise
    /*
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(Integer num : nums) {
                set.add(num & mask);
            }
            //System.out.println("before: " + Integer.toBinaryString(max));
            int temp = max | (1 << i);
            //System.out.println("after: " + Integer.toBinaryString(temp));
            for(int prefix : set) {
                if(set.contains(temp ^ prefix)) {
                    max = temp;
                    break;
                }
            }
        }
        return max;
    }*/
    // solution 2: prefix tree (Trie)
    class Trie {
        Trie[] children = new Trie[2];
        
    }
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        Trie root = new Trie();
        for(Integer num : nums) {
            Trie cur = root;
            for(int i = 31; i >=0; i--) {
                int curBit = (num >>> i) & 1;
                if(cur.children[curBit] == null) cur.children[curBit] = new Trie();
                cur = cur.children[curBit];
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(Integer num : nums) {
            Trie cur = root;
            int tempSum = 0;
            for(int i = 31; i >=0; i--) {
                int curBit = (num >>> i) & 1;
                if(cur.children[curBit ^ 1] != null){
                    tempSum += (1 << i);
                    cur = cur.children[curBit ^ 1];
                }else{
                    cur = cur.children[curBit];
                }
            }
            max = Math.max(tempSum, max);
            
        }
        return max;
        
    }	
}