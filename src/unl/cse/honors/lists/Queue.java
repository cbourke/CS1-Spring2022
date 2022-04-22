package unl.cse.honors.lists;

import java.util.LinkedList;
import java.util.List;

public class Queue<T> {

	private final int maxSize;
	private List<T> underlyingList;

	public Queue() {
		this(-1);
	}

	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.underlyingList = new LinkedList<>();
	}

	public void enqueue(T x) {
		if (x == null) {
			throw new IllegalArgumentException("This stack doesn't support nulls");
		} else if(this.isFull()) {
			throw new IllegalStateException("stack is full!");
		}
		this.underlyingList.add(x);
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
		return this.underlyingList.get(0);
	}

	public T dequeue() {
		if (this.isEmpty()) {
			throw new IllegalStateException("Cannot pop from an empty queue!");
		}
		return this.underlyingList.remove(0);
	}

}
