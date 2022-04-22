package unl.cse.honors.lists;

import java.util.LinkedList;
import java.util.List;

public class Stack<T> {

	private final int maxSize;
	private List<T> underlyingList;

	public Stack() {
		this(-1);
	}

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.underlyingList = new LinkedList<>();
	}

	public void push(T x) {
		if (x == null) {
			throw new IllegalArgumentException("This stack doesn't support nulls");
		} else if(this.isFull()) {
			throw new IllegalStateException("stack is full!");
		}
		this.underlyingList.add(0, x);
	}
	
	public boolean isFull() {
		return this.underlyingList.size() == maxSize;
	}

	public boolean isEmpty() {
		return this.underlyingList.size() == 0;
	}

	public int getSize() {
		return this.underlyingList.size();
	}
	
	public T peek() {
		// returns the element at the top of the stack, but does not remove it...
		return this.underlyingList.get(0);
	}

	public T pop() {
		if (this.isEmpty()) {
			throw new IllegalStateException("Cannot pop from an empty stack!");
		}
		return this.underlyingList.remove(0);
	}

}
