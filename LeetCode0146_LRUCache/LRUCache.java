package LeetCode0146_LRUCache;

import java.util.HashMap;

public class LRUCache {
	class Node {
        Node pre;
        Node next;
        int key; //need key fields for look back to delete in Map
        int val;
        public Node (int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    private void removeNode(Node n) {
        Node preN = n.pre;
        Node nextN = n.next;
        if(n == head) head = nextN;
        if(n == end) end = preN;
        if(preN != null) preN.next = nextN;
        if(nextN != null) nextN.pre = preN;
    }
    
    private void setHead(Node n) {
        n.next = head; //head is most recent val
        n.pre = null;
        if(head != null) head.pre = n;
        head = n;
        if(end == null) end = head;
    }
    
    Node head = null;
    Node end = null;
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node cur = map.get(key);
        removeNode(cur);
        setHead(cur);
        return cur.val;
    }
    
    public void put(int key, int value) {
        if(!map.containsKey(key)) {
            if(map.size() >= capacity) {
                map.remove(end.key);
                removeNode(end);
            }
            Node cur = new Node(key, value);
            map.put(key, cur);
            setHead(cur);
        }else{
            Node cur = map.get(key);
            cur.val = value;
            removeNode(cur);
            setHead(cur);
        }
    }	
}