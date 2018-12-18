package LeetCode0911_OnlineElection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OnlineElection {
	Map<Integer, Integer> map = new HashMap<>();
    int[] time;
    public void TopVotedCandidate(int[] persons, int[] times) {
        int n = persons.length, lead = -1;
        Map<Integer, Integer> count = new HashMap<>();
        time = times;
        for(int i = 0; i < n; i++) {
            count.put(persons[i], count.getOrDefault(persons[i], 0) + 1);
            if(i == 0 || count.get(persons[i]) >= count.get(lead)) lead = persons[i];
            map.put(times[i], lead);
        }
    }
    
    public int q(int t) {
        int i = Arrays.binarySearch(time, t);
        return i < 0 ? map.get(time[-(i + 1) - 1]) : map.get(time[i]);
    }
}
