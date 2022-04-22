package unl.cse.lists;

import java.util.Iterator;

import javax.lang.model.element.Element;

public class MyLinkedList<T> implements Iterable<T>{

	private Node<T> head;
	private int size;

	public MyLinkedList() {
		this.head = null;
		this.size = 0;
	}

	public boolean isEmpty() {
		return (this.size == 0);
	}

	public void addElementToHead(T x) {
		// 1. create the new head node that holds the new element x
		Node<T> newHead = new Node<>(x);
		// 2. make the new head node point to the old head node
		newHead.setNext(this.head);
		// 3. make this list's head point to the new head node
		this.head = newHead;
		this.size++;
	}

	public void addElementToTail(T x) {

		if (this.isEmpty()) {
			this.addElementToHead(x);
			return;
		}

		// 1. create a new node to hold x...
		Node<T> newTail = new Node<>(x);
		// 2. find the current tail...
		Node<T> current = this.head;
		while (current.hasNext()) {
			current = current.getNext();
		}
		// 3. make the old tail (current) point to the newTail...
		current.setNext(newTail);
		this.size++;
	}

	public void removeElementFromHead() {
		this.head = this.head.getNext();
		this.size--;
	}

	public boolean contains(T x) {

		for(T y : this) {
			if (y.equals(x)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes *all* elements from this list
	 */
	public void clear() {
		this.head = null;
		this.size = 0;
	}

	private Node<T> getNodeAtIndex(int index) {
		Node<T> current = this.head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current;
	}

	public T getElementAtIndex(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new RuntimeException("index out of bounds: " + index);
		}

		return getNodeAtIndex(index).getElement();
	}

	public void removeElementAtIndex(int index) {
		if (index < 0 || index > this.size - 1) {
			throw new RuntimeException("index out of bounds: " + index);
		}
		if (index == 0) {
			this.removeElementFromHead();
			return;
		}
		// want to delete curr...
		Node<T> prev = getNodeAtIndex(index - 1);
		Node<T> curr = prev.getNext();
		// prev -> curr -> next
		// => prev -> next
		prev.setNext(curr.getNext());
		this.size--;
	}

	public void addElementAtIndex(T x, int index) {
		if (index < 0 || index > this.size) {
			throw new RuntimeException("index out of bounds: " + index);
		}

		if (index == 0) {
			this.addElementToHead(x);
		} else if (index == this.size) {
			this.addElementToTail(x);
		} else {
			// step 1: find the node at index index-1
			Node<T> previous = getNodeAtIndex(index - 1);
			// step 2: find the node at index index
			Node<T> next = previous.getNext();
			// create new node, insert between the two nodes...
			Node<T> curr = new Node<>(x);
			// previous -> curr -> next
			previous.setNext(curr);
			curr.setNext(next);
			this.size++;
		}

	}

	public int getSize() {
		return this.size;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("size = " + this.getSize() + ": ");
		Node<T> current = this.head;
		while (current != null) {
			sb.append(current.getElement() + " -> ");
			current = current.getNext();
		}
		return sb.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Node<T> curr = head;
					
			@Override
			public boolean hasNext() {
				return this.curr != null;
			}

			@Override
			public T next() {
				T x = this.curr.getElement();
				this.curr = this.curr.getNext();
				return x;
			}
			
		};
	}

}
