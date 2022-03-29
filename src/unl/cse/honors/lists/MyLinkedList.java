package unl.cse.honors.lists;

public class MyLinkedList<T> {

	private Node<T> head;
	private int size;
	
	public MyLinkedList() {
		this.head = null;
		this.size = 0;
	}
	
	public void addElementToHead(T element) {
		this.addElementAtIndex(element, 0);
//		Node<T> newHead = new Node<T>(element);
//		newHead.setNext(this.head);
//		this.head = newHead;		
//		this.size++;
	}
	
	public void addElementToTail(T element) {
		this.addElementAtIndex(element, this.size);
//		if(this.isEmpty()) {
//			this.addElementToHead(element);
//			return;
//		}
//		Node<T> current = this.head;
//		while(current.hasNext()) {
//			current = current.getNext();
//		}
//		Node<T> newTail = new Node<>(element);
//		current.setNext(newTail);
//		this.size++;
	}
	
	public T removeElementAtIndex(int index) {
		//TODO: implement
		Node<T> previous = this.getNodeAtIndex(index - 1);
		Node<T> current = previous.getNext();
		Node<T> next = current.getNext();
		previous.setNext(next);
		return current.getElement();
	}
	
	public T getElementAtIndex(int index) {
		if(index < 0 || index >= this.size) {
			throw new RuntimeException("invalid index "+index);
		} 
		return this.getNodeAtIndex(index).getElement();
	}
	
	private Node<T> getNodeAtIndex(int index) {
		
		Node<T> current = this.head;
		for(int i=0; i<index; i++) {
			current = current.getNext();
		}
		return current;
	}
	
	public void addElementAtIndex(T element, int index) {
		
		if(index < 0 || index > this.size) {
			throw new RuntimeException("invalid index "+index);
		} 

		if(this.isEmpty() || index == 0) {
			Node<T> newHead = new Node<T>(element);
			newHead.setNext(this.head);
			this.head = newHead;		
			this.size++;
			return;
		}
		
		// now you need to actually do some work...
		Node<T> previous = this.getNodeAtIndex(index - 1);
		Node<T> next = previous.getNext();

		// create a new node...
		Node<T> newNode = new Node<>(element);
		// make the previous point to new node
		previous.setNext(newNode);
		// make the newNode point to the next
		newNode.setNext(next);
		this.size++;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public String toString() {
		
		if(this.isEmpty()) {
			return "[empty]";
		}
		
		StringBuilder sb = new StringBuilder();
		Node<T> current = this.head;
		while(current.hasNext()) {
			//1. concatentate the node's element
			sb.append(current.getElement() + ", ");
			//2. traverse to the next node
			current = current.getNext();
		}
		sb.append(current.getElement());		
		return sb.toString();
		
	}
	
}
