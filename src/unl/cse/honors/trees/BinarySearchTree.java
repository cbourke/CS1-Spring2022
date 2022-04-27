package unl.cse.honors.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T> {

	private final Comparator<T> cmp;
	private TreeNode<T> root;
	
	public BinarySearchTree(Comparator<T> cmp) {
		this.root = null;
		this.cmp = cmp;
	}
	
	public void add(T x) {
		
		if(this.root == null) {
			this.root = new TreeNode<T>(x);
			return;
		}
		
		if(this.contains(x)) {
			return;
		}

		TreeNode<T> parent = this.findParentNode(x);
		TreeNode<T> child  = new TreeNode<T>(x);
		child.setParent(parent);
		if( this.cmp.compare(x, parent.getItem()) < 0) {
			parent.setLeftChild(child);
		} else {
			parent.setRightChild(child);
		}
		return;
	}
	
	private TreeNode<T> findNode(T x) {
		TreeNode<T> current = this.root;
		while(current != null) {
			T item = current.getItem();
			if( this.cmp.compare(item, x) == 0) {
				return current;
			} else if(this.cmp.compare(x, item) < 0) {
				//traverse left
				current = current.getLeftChild();
			} else {
				//traverse right
				current = current.getRightChild();
			}
		}
		return current;
	}
	
	private TreeNode<T> findParentNode(T x) {

		TreeNode<T> previous = null;
		TreeNode<T> current  = this.root;
		while(current != null) {
			T item = current.getItem();
			previous = current;
			if( this.cmp.compare(item, x) == 0) {
				return current.getParent();
			} else if(this.cmp.compare(x, item) < 0) {
				//traverse left
				current = current.getLeftChild();
			} else {
				//traverse right
				current = current.getRightChild();
			}
		}
		return previous;
	}
	
	public boolean contains(T x) {
		return (this.findNode(x) != null);
	}
	
	public List<T> inorderTraversal() {
		
		List<T> order = new ArrayList<>();
		
		Deque<TreeNode<T>> stack = new LinkedList<>();
		TreeNode<T> u = this.root;		
		while(!stack.isEmpty() || u != null) {
			if(u != null) {
				stack.push(u);
				u = u.getLeftChild();
			} else {
				u = stack.pop();
				order.add(u.getItem());
				u = u.getRightChild();
			}
		}
		
		return order;
	}
	
	public String toString() {
		return this.inorderTraversal().toString();
	}
	
	private void deleteNode(TreeNode<T> u) {
		//TODO
	}
	
	public void remove(T x) {
		TreeNode<T> u = this.findNode(x);
		if(u == null) {
			return;
		}
		//delete u...
		if(u.isLeaf()) {
			if(u.isLeftChild()) {
				u.getParent().setLeftChild(null);
			} else if(u.isRightChild()) {
				u.getParent().setRightChild(null);
			} else {
				this.root = null;
			}
		} else if(u.numChildren() == 1) {
			//TODO: you do it
		} else {
			//two children, TODO: you do it...
			
		}
	}
	
	private TreeNode<T> getMin(TreeNode<T> u) {
		TreeNode<T> curr = u;
		while(curr.hasLeftChild()) {
			curr = curr.getLeftChild();
		}
		return curr;
	}
	
	public T getMin() {
		TreeNode<T> minimumNode = this.getMin(this.root);
		return minimumNode.getItem();
	}

	public T getMax() {
		TreeNode<T> maxNode = this.getMax(this.root);
		return maxNode.getItem();
	}

	private TreeNode<T> getMax(TreeNode<T> u) {
		TreeNode<T> curr = u;
		while(curr.hasRightChild()) {
			curr = curr.getRightChild();
		}
		return curr;
	}

}
