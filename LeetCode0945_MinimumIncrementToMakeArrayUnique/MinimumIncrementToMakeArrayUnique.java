package LeetCode0945_MinimumIncrementToMakeArrayUnique;

public class MinimumIncrementToMakeArrayUnique {
	// Time limited Expection
    /*
    public int minIncrementForUnique(int[] A) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int num : A) {
            if(set.contains(num)) list.add(num);
            else set.add(num);
        }
        int step = 0;
        for(int dup : list) {
            while(set.contains(dup)) {
                dup++;
                step++;
            }
            set.add(dup);
        }
        return step;
    }*/
    /*
    public int minIncrementForUnique(int[] A) {
        int res = 0;
        Arrays.sort(A);
        for(int i = 1; i < A.length; i++) {
            if(A[i] == A[i - 1]) {
                int index = i;
                while(index < A.length && A[index] <= A[index - 1]) {
                    A[index]++;
                    index++;
                    res++;
                }
            }
        }
        
        return res;
    }*/
    
    public int minIncrementForUnique(int[] A) {
        int[] count = new int[100000];
        for(int num : A) count[num]++;
        
        int res = 0, taken = 0;
        
        /* 
         * In the [1, 1, 1, 1, 3, 5] example, we do taken = 3 and ans -= 3 in advance, 
         * and later we do ans += 2; ans += 4; ans += 6.
         */
        for(int i = 0; i < count.length; i++) {
            if(count[i] >= 2) {
                taken += count[i] - 1;
                res -= i * (count[i] - 1);
            }else if(taken > 0 && count[i] == 0) {
                res += i;
                taken--;
            }
        }
        return res;
    }
}
