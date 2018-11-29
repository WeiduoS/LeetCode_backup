package LeetCode0284_PeekingIterator;

import java.util.Iterator;

public class PeekingIterator {
	Iterator<Integer> iter;
    Integer nextValue = null;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    iter = iterator;
        if(iter.hasNext()) nextValue = iter.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return nextValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	public Integer next() {
        Integer temp = nextValue;
        nextValue = iter.hasNext() ? iter.next() : null;
	    return temp;
	}

	public boolean hasNext() {
	    return nextValue != null;
	}
}
