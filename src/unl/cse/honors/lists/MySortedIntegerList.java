package unl.cse.honors.lists;

import java.util.Arrays;

public class MySortedIntegerList {

	MyArrayIntegerList l;

	public MySortedIntegerList() {
		l = new MyArrayIntegerList();
	}

	public void addElement(Integer x) {

		// find which index it belongs...
		int insertionIndex = 0;
		while (insertionIndex < this.l.getSize() && this.l.getElementAtIndex(insertionIndex) < x) {
			insertionIndex++;
		}

		//want a function in MyArrayIntegerLIst to insert at an index...
		this.l.addElementAtIndex(x, insertionIndex);

	}

	public Integer getElementAtIndex(int index) {
		return this.l.getElementAtIndex(index);
	}

	public Integer removeElementAtIndex(int index) {
		return this.l.removeElementAtIndex(index);
	}

	/**
	 * Searches the list for the given element, returns true if found, false
	 * otherwise; uses a binary search algorithm.
	 * 
	 * @param x
	 * @return
	 */
	public boolean containsElement(Integer x) {
		//TODO: do this better
		return this.l.efficientContainsElement(x);
	}

	public String toString() {
		return this.l.toString();
	}

}
