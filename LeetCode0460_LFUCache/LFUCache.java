package LeetCode0460_LFUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
	// wrong answer: without record the frequence
    /*
    class Node {
        int key, value;
        Node left, right;
        Node (int key, int value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    int cache_size;
    Map<Integer, Node> map;
    Node start, end;
    
    public LFUCache(int capacity) {
        cache_size = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            removeNode(node);
            addAtTop(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache_size == 0) return;
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addAtTop(node);
        }else{
            Node node = new Node(key, value, null, null);
            if(map.size() == cache_size) {
                map.remove(end.key);
                removeNode(end);
                addAtTop(node);
            }else{
                addAtTop(node);
            }
            map.put(key, node);
        }
    }
    
    public void removeNode(Node node) {
        if(node.left != null) {
            node.left.right = node.right;
        }else{
            start = node.right;
        }
        
        if(node.right != null) {
            node.right.left = node.left;
        }else{
            end = node.left;
        }
    }
    
    public void addAtTop(Node node) {
        node.right = start;
        node.left = null;
        if(start != null) {
            start.left = node;
        }
        start = node;
        
        if(end == null) {
            end = start;
        }
    }*/
    
    /*  head --- FreqNode1 ---- FreqNode2 ---- ... ---- FreqNodeN
     *              |               |                       |               
     *            first           first                   first             
     *              |               |                       |               
     *           KeyNodeA        KeyNodeE                KeyNodeG           
     *              |               |                       |               
     *           KeyNodeB        KeyNodeF                KeyNodeH           
     *              |               |                       |               
     *           KeyNodeC         last                   KeyNodeI           
     *              |                                       |      
     *           KeyNodeD                                 last
     *              |
     *             last
     */
    
    class Node {
        public Node prev, next;
        public final int count;
        public LinkedHashSet<Integer> keys = new LinkedHashSet<>();
        
        public Node(Node prev, Node next, int count, int key) {
            this.prev = prev;
            this.next = next;
            this.count = count;
            keys.add(key);
        }
    }
    
    Node head = null;
    final int capacity;
    Map<Integer, Integer> valueMap;
    Map<Integer, Node> nodeMap;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(valueMap.containsKey(key)) increase(key, valueMap.get(key));
        return valueMap.getOrDefault(key, -1);
    }

    private void increase(int key, int value) {
        Node node = nodeMap.get(key);
        node.keys.remove(key);
        
        if(node.next == null) {
            node.next = new Node(node, null, node.count + 1, key);
        }else if(node.next.count == node.count + 1) {
            node.next.keys.add(key);
        }else{
            
            Node temp = new Node(node, node.next, node.count + 1, key);
            node.next.prev = temp;
            node.next = temp;
        }
        // update (key, value) pairs
        valueMap.put(key, value);
        nodeMap.put(key,node.next);
        if(node.keys.isEmpty()) remove(node);
    }
    
    private void remove(Node node) {
        if(head == node) {
            head = node.next;
        }else{
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(valueMap.containsKey(key)) {
            valueMap.put(key, value);
            increase(key, value);
        }else{
            if(valueMap.size() == this.capacity) remove();
            valueMap.put(key, value);
            addAtHead(key);
        }
    }
    
    private void addAtHead(int key) {
        if(head == null) {
            head = new Node(null, null, 1, key);
        }else if(head.count == 1) {
            head.keys.add(key);
        }else{
            Node temp = new Node(null, head, 1, key);
            head.prev = temp;
            head = temp;
        }
        nodeMap.put(key, head);
    }
    
     private void remove() {
         if(head == null) return;
         int old = 0;
         for(int n : head.keys) {
             old = n;
             break;
         }
         head.keys.remove(old);
         if(head.keys.size() == 0) remove(head);
         nodeMap.remove(old);
         valueMap.remove(old);
     }
}
