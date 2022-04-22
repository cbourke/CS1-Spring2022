package unl.cse.honors.trees;

public class TreeNode<T> {
	
	private final T item;
	private TreeNode<T> parent;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	/**
	 * @param item
	 */
	public TreeNode(T item) {
		super();
		this.item = item;
	}

	public TreeNode<T> getParent() {
		return parent;
	}

	public void setParent(TreeNode<T> parent) {
		this.parent = parent;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getItem() {
		return item;
	}

	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	public boolean hasParent() {
		return this.parent != null;
	}
	
	public boolean isRoot() {
		return !this.hasParent();
	}
	
	public boolean isLeaf() {
		return !this.hasLeftChild() && !this.hasRightChild();
	}

	

}
