package LeetCode0830_PositionsOfLargeGroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups {
	public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int i = 0, n = S.length();
        for(int j = 0; j < n; j++) {
            if(j == n - 1 || S.charAt(j) != S.charAt(j + 1)) {
                if(j - i + 1 >= 3) {
                    res.add(Arrays.asList(new Integer[]{i, j}));
                }
                i = j + 1;
            }
        }
        return res;
    }
}
