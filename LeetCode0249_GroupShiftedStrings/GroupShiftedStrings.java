package LeetCode0249_GroupShiftedStrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            String key = "";
            for(int i = 1; i < str.length(); i++) {
                int diff = str.charAt(i) - str.charAt(i - 1);
                diff = diff >= 0 ? diff : diff + 26;
                key += diff;
            }
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(str);
        }
        return new ArrayList(map.values());
    }
}