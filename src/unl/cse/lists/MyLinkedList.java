package unl.cse.lists;

public class MyLinkedList <T> {
	
	private Node<T> head;
	//private int size;
	//TODO: support a int size variable
	
	public MyLinkedList() {
		this.head = null;
		//this.size = 0;
	}
	
	public void addElementToHead(T x) {
		//1. create the new head node that holds the new element x
		Node<T> newHead = new Node<>(x);
		//2. make the new head node point to the old head node
		newHead.setNext(this.head);
		//3. make this list's head point to the new head node
		this.head = newHead;
		//this.size++;
	}
	
	public int getSize() {
		int size = 0;
		Node<T> current = this.head;
		while(current != null) {
			size++;
			current = current.getNext();
		}

		return size;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("size = " + this.getSize() + ": ");
		Node<T> current = this.head;
		while(current != null) {
			sb.append(current.getElement() + " -> ");
			current = current.getNext();
		}
		return sb.toString();
	}
	
	

}
