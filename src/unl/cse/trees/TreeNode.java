package unl.cse.trees;

public class TreeNode<T> {
	
	private final T item;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	private TreeNode<T> parent;

	/**
	 * @param item
	 */
	public TreeNode(T item) {
		super();
		this.item = item;
	}
	
	public boolean hasParent() {
		return this.parent != null;		
	}
	
	public boolean isRoot() {
		return !this.hasParent();
	}

	public boolean hasLeftChild() {
		return this.leftChild != null;		
	}

	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	public T getItem() {
		return item;
	}
	public TreeNode<T> getLeftChild() {
		return leftChild;
	}
	public TreeNode<T> getRightChild() {
		return rightChild;
	}
	public TreeNode<T> getParent() {
		return parent;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}
	
	
	

}
