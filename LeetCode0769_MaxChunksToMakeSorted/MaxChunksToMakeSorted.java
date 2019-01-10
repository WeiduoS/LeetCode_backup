package LeetCode0769_MaxChunksToMakeSorted;

public class MaxChunksToMakeSorted {
	public int maxChunksToSorted(int[] arr) {
        int res = 0;
        for(int i = 0; i < arr.length; i++) {
            //System.out.println("arr[i]: " + arr[i] + ", i: " + i);
            int target = arr[i];
            int j = i;
            for(; j <= target; j++) {
                target = Math.max(target, arr[j]);
                if(target == arr[arr.length - 1]) return res + 1;
            }
            //System.out.println("j: " + j);
            i = j - 1;
            res++;
        }
        return res;
    }
}
