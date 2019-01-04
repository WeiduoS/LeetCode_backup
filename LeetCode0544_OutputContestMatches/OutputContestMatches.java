package LeetCode0544_OutputContestMatches;

import java.util.ArrayList;
import java.util.List;

public class OutputContestMatches {
	/*
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(String.valueOf(i));
        while(n != 1) {
            for(int i = 0; i < n / 2; i++) {
                String temp = "(" + list.get(i) + "," + list.get(n - i - 1) + ")";
                list.set(i, temp);
            }
            n /= 2;
        }
        return list.get(0);
    }*/
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) list.add(String.valueOf(i));
        helper(list, n);
        return list.get(0);
    }
    private void helper(List<String> list, int n) {
        if(n == 1) return;
        for(int i = 0; i < n; i++) {
            String temp = "(" + list.get(i) + "," + list.get(n - i - 1) + ")";
            list.set(i, temp);
        }
        helper(list, n / 2);
    }
}
