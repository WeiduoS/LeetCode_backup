package LeetCode0341_FlattenNestedListIterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator {
	/*
    private List<Integer> list = new ArrayList<>();
    private int index = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger n : nestedList) {
            flatten(n);
            index = 0;
        }
    }
    
    private void flatten(NestedInteger n) {
        if(n.isInteger()) {
            list.add(n.getInteger());
        }else{
            for(NestedInteger s : n.getList()) {
                flatten(s);
            }
        }
    }
    
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }*/
    
	class  NestedInteger {
		private int getInteger(){
			return 0;
		}
		private boolean isInteger(){
			return true;
		}
		private List<NestedInteger> getList() {
			return new ArrayList<NestedInteger>();
		}
	}
    Stack<NestedInteger> stack = new Stack<>();
    
    public void NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }
    
    public Integer next() {
        return stack.pop().getInteger();
    }
    
    public boolean hasNext() {
        while(!stack.isEmpty()) {
            NestedInteger n = stack.peek();
            if(n.isInteger()) {
                return true;
            }else{
                stack.pop();
                List<NestedInteger> ln = n.getList();
                for(int i = ln.size() - 1; i >= 0; i--) {
                    stack.push(ln.get(i));
                }
            }
        }
        return false;
    }}