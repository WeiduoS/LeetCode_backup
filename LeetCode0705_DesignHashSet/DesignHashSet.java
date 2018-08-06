package LeetCode0705_DesignHashSet;

public class DesignHashSet {
	private static final int DEFAULT_ITEM_PER_TABLE = 1001;
    private static final int DEFAULT_TABLE_SIZE = 1000;
    private boolean[][] table;
    
    /** Initialize your data structure here. */
    public DesignHashSet() {
        table = new boolean[DEFAULT_TABLE_SIZE][];
    }
    
    public int hash(int key) {
        return key % DEFAULT_TABLE_SIZE;
    }
    
    public int pos(int key) {
        return key / DEFAULT_TABLE_SIZE;
    }
    
    public void add(int key) {
        int hashKey = hash(key);
        if(table[hashKey] == null){
            table[hashKey] = new boolean[DEFAULT_ITEM_PER_TABLE];
        }
        table[hashKey][pos(key)] = true;
    }
    
    public void remove(int key) {
        int hashKey = hash(key);
        if(table[hashKey] != null){
            table[hashKey][pos(key)] = false;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hashKey = hash(key);
        return table[hashKey] != null && table[hashKey][pos(key)]; 
    }
}