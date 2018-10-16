package LeetCode0729_MyCalendarI;

public class MyCalendarI {
	// solution 1: linear scan
    /*
    List<int[]> calendar;
    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] iterval : calendar) {
            if(iterval[0] < end && start < iterval[1]) return false;
        }
        calendar.add(new int[]{start, end});
        return true;
    }*/
    // solution 2: TreeMap
    /*
    TreeMap<Integer, Integer> calendar;
    
    public MyCalendar() {
        calendar = new TreeMap();
    }
    
    public boolean book(int start, int end) {
        Integer lessThan = calendar.floorKey(start);
        Integer greaterThan = calendar.ceilingKey(start);
        if(lessThan != null && calendar.get(lessThan) > start) return false;
        if(greaterThan != null && greaterThan < end) return false;
        calendar.put(start, end);
        return true;
    }*/
    Node root;
    class Node {
        int start;
        int end;
        Node left;
        Node right;
        public Node (int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public MyCalendar() {
        
    }
    public boolean book(int start, int end) {
        Node n = insert(root, start, end);
        if(n == null) return false;
        if(root == null) root = n;
        return true;
    }
    private Node insert(Node node, int start, int end) {
        if(node == null) {
            return new Node(start, end);
        }
        if(end <= node.start) {
            Node left = insert(node.left, start, end);
            if(left == null) return null;
            node.left = left;
        }else if(node.end <= start) {
            Node right = insert(node.right, start, end);
            if(right == null) return null;
            node.right = right;
        }else{
            return null;
        }
        return node;
    }	
}