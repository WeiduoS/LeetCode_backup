package LeetCode0760_FindAnagramMappings;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings {
	public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] res = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]);
        }
        return res;
    }	
}