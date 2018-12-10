package LeetCode0388_LongestAbsoluteFilePath;

import java.util.HashMap;
import java.util.Map;

public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        for(String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            //System.out.println("s: " + s + ", len: " + len);
            if(s.contains(".")) {
                res = Math.max(res, map.get(level) + len);
            }else{
                map.put(level + 1, map.get(level) + len + 1);
            }
        }
        /*
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }*/
        return res;
    }
}
