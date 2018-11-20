package LeetCode0681_NextClosestTime;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {
	/*
    public String nextClosestTime(String time) {
        int cur = 60 * Integer.parseInt(time.substring(0, 2));
        cur += Integer.parseInt(time.substring(3));
        // System.out.println(cur);
        Set<Integer> set = new HashSet<>();
        for(char c : time.toCharArray()) {
            if(c != ':') set.add(c - '0');
        }
        
        for(int i = 0; i < 2440; i++) {
            cur = (cur + 1) % (24 * 60);
            int[] digits = new int[]{cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10};
            if(search(digits, set)) {
                return String.format("%02d:%02d", cur / 60, cur % 60);
            }
        }
        return "";
    }
    
    private boolean search(int[] digits, Set<Integer> set) {
        for(int digit : digits) {
            if(!set.contains(digit)) return false;
        }
        return true;
    }*/
    
    int diff = Integer.MAX_VALUE;
    String result = "";

    public String nextClosestTime(String time) {
        Set<Integer> set = new HashSet<>();
        int[] digits = new int[4];
        int index = 0;
        for(char c : time.toCharArray()) {
            if(c != ':') {
                set.add(c - '0');
                digits[index++] = c - '0';
            }
        }
        if(set.size() == 1) return time;
        int cur = 60 * Integer.parseInt(time.substring(0, 2)) + Integer.parseInt(time.substring(3));
        dfs(digits, new int[4], 0, cur);
        
        return result;
    }
    
    private void dfs(int[] digits, int[] time, int level, int now) {
        if(level == 4) {
            //System.out.println(Arrays.toString(time));
            int time_h = time[0] * 10 + time[1];
            int time_m = time[2] * 10 + time[3];
            if(time_h > 23 || time_m > 59) return;
            int curr_time = time_h * 60 + time_m;
            int d = curr_time - now > 0 ? curr_time - now : curr_time - now + 1440;
            if(d < diff) {
                diff = d;
                String temp = "";
                temp += String.valueOf(time[0]);
                temp += String.valueOf(time[1]);
                temp += ":";
                temp += String.valueOf(time[2]);
                temp += String.valueOf(time[3]);
                result = temp;
            }
            return;
        }
        for(int digit : digits) {
            time[level] = digit;
            dfs(digits, time, level + 1, now);
        }
    }
}
