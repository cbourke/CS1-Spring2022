package unl.cse.lists;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

	private final List<T> underlyingList;
	private final int maxSize;

	public MyStack() {
		this.underlyingList = new ArrayList<>();
		this.maxSize = -1; // unbounded
	}

	public MyStack(int maxSize) {
		this.underlyingList = new ArrayList<>();
		this.maxSize = maxSize;
	}

	public void push(T x) {
		if (x == null) {
			// return;
			throw new IllegalArgumentException("This stack doesn't allow nulls");
		} else if(this.isFull()) {
			//return;
			throw new IllegalStateException("This stack is full");
		}
		this.underlyingList.add(x);
	}

	public T pop() {
		if (this.underlyingList.isEmpty()) {
			// return null;
			throw new RuntimeException("You cannot pop from an empty stack!");
		}

		return this.underlyingList.remove(this.underlyingList.size()-1);
	}

	public T peek() {
		return this.underlyingList.get(this.underlyingList.size()-1);
	}

	public boolean isEmpty() {
		return this.underlyingList.isEmpty();
	}

	public boolean isFull() {
		return (this.underlyingList.size() == this.maxSize);
	}

	public int size() {
		return this.underlyingList.size();
	}

}
