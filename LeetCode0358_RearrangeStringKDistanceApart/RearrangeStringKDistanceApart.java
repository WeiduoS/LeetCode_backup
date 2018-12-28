package LeetCode0358_RearrangeStringKDistanceApart;

public class RearrangeStringKDistanceApart {
	// i think i'm right
    // 这题有问题
    /*
    public String rearrangeString(String s, int k) {
        if(k == 0) return s;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //for(Map.Entry<Character, Integer> entry : map.entrySet()) {
        //    System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        //}
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>(){
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                if(entry1.getValue() == entry2.getValue()) return entry1.getKey() - entry2.getKey();
                else return entry2.getValue() - entry1.getValue();
            }
        });
        pq.addAll(map.entrySet());
        //for(Map.Entry<Character, Integer> entry : pq) {
        //    System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        //}
        
        while(!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            int cnt = Math.min(len, k);
            for(int i = 0; i < cnt; i++) {
                if(pq.isEmpty()) return "";
                Map.Entry<Character, Integer> cur = pq.poll();
                sb.append(cur.getKey());
                cur.setValue(cur.getValue() - 1);
                list.add(cur);
                len--;
            }
            
            for(Map.Entry<Character, Integer> entry : list) {
                if(entry.getValue() > 0) pq.offer(entry);
            }
        }
        
        return sb.toString();
    }*/
    /*
    public String rearrangeString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        pq.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        
        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> cur = pq.poll();
            sb.append(cur.getKey());
            cur.setValue(cur.getValue() - 1);
            queue.offer(cur);
            if(queue.size() < k) continue;
            Map.Entry<Character, Integer> front = queue.poll();
            if (front.getValue() > 0) {
                pq.offer(front);
            }
        }
        
        return sb.length() == s.length() ? sb.toString() : "";
    }*/
    public String rearrangeString(String s, int k) {
        if(s == null || k == 0) return s;
        int[] count = new int[26];
        int[] valid = new int[26];
        
        for(char c : s.toCharArray()) count[c - 'a']++;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < s.length(); i++) {
            int index = findNext(count, valid, i);
            if(index == -1) return "";
            sb.append((char)('a' + index));
            valid[index] = i + k;
            count[index]--;
        }
        return sb.toString();
    }
    private int findNext(int[] count, int[] valid, int index) {
        int max = 0, res = -1;
        for(int i = 0; i < count.length; i++) {
            if(count[i] > max && valid[i] <= index) {
                res = i;
                max = count[i];
            }
        }
        return res;
    } 
}
