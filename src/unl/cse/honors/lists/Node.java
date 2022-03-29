package unl.cse.honors.lists;

public class Node<T> {

	private final T element;
	private Node<T> next;
	
	public Node(T element) {
		this.element = element;
		this.next = null;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public T getElement() {
		return element;
	}
	
	public boolean hasNext() {
		return (this.next != null);
	}
	
	public String toString() {
		if(this.element == null) { 
			return "(null)"; 
		} else {
			return this.element.toString();
		}
	}
	
	
	
}
