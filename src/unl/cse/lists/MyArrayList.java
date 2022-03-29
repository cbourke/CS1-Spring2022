package unl.cse.lists;

import java.util.Arrays;

import javax.lang.model.element.Element;

public class MyArrayList <T> {
	
	private static final int BLOCK_SIZE = 10;

	private T arr[];
	private int size;
	
	public MyArrayList() {
		this.arr = (T[]) new Object[BLOCK_SIZE];
		this.size = 0;
	}
	
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Adds the given element <code>x</code> to the end
	 * of the list
	 * @param x
	 */
	public void addElementAtEnd(T x) {		
		this.addElementAtIndex(x, this.size);
	}

	public void addElementAtStart(T x) {		
		this.addElementAtIndex(x, 0);
	}
	
	/**
	 * Returns <code>true</code> if this list contains the
	 * given element <code>x</code>, false otherwise
	 * 
	 * This method performs a linear search algorithm
	 * 
	 * @param x
	 * @return
	 */
	public boolean containsElement(T x) {
		for(int i=0; i<this.size; i++) {
			if(this.arr[i] == x) {
				return true;
			}
		}
		return false;
	}

	
	public void addElementAtIndex(T x, int index) {
		
		if(index < 0 || index > size) {
			throw new RuntimeException("Index "+index+" out of range; list currently holds " + this.size + " elements");
		}
		
		if(this.size == this.arr.length) {
			this.arr = Arrays.copyOf(this.arr, this.arr.length + BLOCK_SIZE);
		}
		//shift things up to make room at index...
		for(int i=size-1; i>=index; i--) {
			this.arr[i+1] = this.arr[i];
		}
		this.arr[index] = x;
		this.size++;
		return;
	}
	
	public T getElementAtIndex(int index) {
		
		if(index < 0 || index >= size) {
			throw new RuntimeException("Index "+index+" out of range; list currently holds " + this.size + " elements");
		}
				
		return this.arr[index];
	}
	
	/**
	 * Removes and returns the element at the given index.
	 * 
	 * @param index
	 * @return
	 */
	public T removeElementAtIndex(int index) {
		if(index < 0 || index >= size) {
			throw new RuntimeException("Index "+index+" out of range; list currently holds " + this.size + " elements");
		}
		T x = this.arr[index];
		for(int i=index; i<this.size-1; i++) {
			this.arr[i] = this.arr[i+1];
		}
		//TODO: consider a "shrink" operation
		this.size--;
		return x;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for(int i=0; i<this.size; i++) {
			sb.append(this.arr[i] + ", ");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
