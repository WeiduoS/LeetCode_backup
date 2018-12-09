package LeetCode0904_FruitIntoBaskets;

import java.util.HashSet;
import java.util.Set;

public class FruitIntoBaskets {
	public int totalFruit(int[] tree) {
        int[] count = new int[tree.length + 1];
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        int res = 0;
        for(; i < tree.length; i++) {
            set.add(tree[i]);
            count[tree[i]]++;
            while(j <= i && set.size() > 2) {
                count[tree[j]]--;
                if(count[tree[j]] == 0) set.remove(tree[j]);
                j++;
            }
            //System.out.println("i : " + i + ", j: " + j + ", " + Arrays.toString(count));
            res = Math.max(i - j + 1, res);
        }
        return res;
    }
}
