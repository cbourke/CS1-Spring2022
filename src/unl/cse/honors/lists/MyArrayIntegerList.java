package unl.cse.honors.lists;

import java.util.Arrays;

public class MyArrayIntegerList {
	
	private static final int BLOCK_SIZE = 10;
	
	private Integer arr[];
	private int size;
	
	public MyArrayIntegerList() {
		this.arr = new Integer[BLOCK_SIZE];
		this.size = 0;
	}
	
	public void addElement(Integer x) {
		this.addElementToEnd(x);
	}
	public void addElementToEnd(Integer x) {
		
		if(this.size == this.arr.length) {
			this.arr = Arrays.copyOf(this.arr, this.arr.length + BLOCK_SIZE);
		}
		
		this.arr[this.size] = x;
		this.size++;
	}
	
	public void addElementAtIndex(Integer x, int index) {
		if(this.size == this.arr.length) {
			this.arr = Arrays.copyOf(this.arr, this.arr.length + BLOCK_SIZE);
		}
		//shift stuff up
		for(int i=size-1; i>=index; i--) {
			arr[i+1] = arr[i];
			
		}
		this.arr[index] = x;
		this.size++;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public Integer getElementAtIndex(int index) {
		
		if(index < 0 || index >= this.size) {
			throw new RuntimeException("size of list is " + this.size);
		}
		
		return this.arr[index];
	}
	
	public Integer removeElementAtIndex(int index) {
		
		if(index < 0 || index >= this.size) {
			throw new RuntimeException("size of list is " + this.size);
		}
		//save it off:
		Integer x= arr[index];
		//shift stuff down:		
		for(int i=index; i<size-1; i++) {
			//move arr[i+1] to arr[i]:
			this.arr[i] = this.arr[i+1];
		}
		this.size--;
		return x;
	}
	
	/**
	 * Searches the list for the given element, returns
	 * true if found, false otherwise; uses a linear search
	 * algorithm.
	 * 
	 * @param x
	 * @return
	 */
	public boolean containsElement(Integer x) {
		
		for(int i=0; i<this.size; i++) {
			if(this.arr[i] == x) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Searches the list for the given element, returns
	 * true if found, false otherwise; uses a binary search
	 * algorithm.
	 * 
	 * @param x
	 * @return
	 */
	public boolean efficientContainsElement(Integer x) {
		//make a copy and sort the copy, search the copy
		Arrays.sort(this.arr);
		int index = Arrays.binarySearch(this.arr, x);
		
		return (index >= 0);
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0; i<this.size-1; i++) {
			sb.append(this.arr[i] + ", ");
		}
		sb.append(this.arr[this.size-1]);
		sb.append("]");
		return sb.toString();
	}

}
