package LeetCode0635_DesignLogStorageSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignLogStorageSystem {
	TreeMap<String, List<Integer>> tree;
    Map<String, Integer> map;
    String min;
    String max;
    public void LogSystem() {
        tree = new TreeMap<>();
        map = new HashMap<>();
        min = "2000:01:01:00:00:00";
        max = "2017:12:31:23:59:59";
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        tree.computeIfAbsent(timestamp, x-> new ArrayList<>());
        tree.get(timestamp).add(id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> res = new ArrayList<>();
        Map<String, List<Integer>> subMap = tree.subMap(
            s.substring(0, map.get(gra)) + min.substring(map.get(gra)), true,
            e.substring(0, map.get(gra)) + max.substring(map.get(gra)), true
        );
        /*
        for (Map.Entry<String, List<Integer>> entry : subMap.entrySet()) {
            res.addAll(entry.getValue());
        }
        return res;*/
        
        return subMap.values().stream().flatMap(List::stream).collect(Collectors.toList());
    }
}
