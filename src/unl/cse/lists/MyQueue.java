package unl.cse.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyQueue<T> {

	private final List<T> underlyingList;
	private final int maxSize;

	public MyQueue() {
		this.underlyingList = new LinkedList<>();
		this.maxSize = -1; // unbounded
	}

	public MyQueue(int maxSize) {
		this.underlyingList = new LinkedList<>();
		this.maxSize = maxSize;
	}

	public void enqueue(T x) {
		if (x == null) {
			// return;
			throw new IllegalArgumentException("This queue doesn't allow nulls");
		} else if(this.isFull()) {
			//return;
			throw new IllegalStateException("This queue is full");
		}
		this.underlyingList.add(x);
	}

	public T dequeue() {
		if (this.underlyingList.isEmpty()) {
			// return null;
			throw new RuntimeException("You cannot dequeue from an empty queue!");
		}

		return this.underlyingList.remove(0);
	}

	public T peek() {
		return this.underlyingList.get(0);
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
