package unl.cse.trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinarySearchTree<T> {

	private final Comparator<T> cmp;
	private TreeNode<T> root;
	private int size = 0;
	
	public BinarySearchTree(Comparator<T> cmp) {
		this.cmp = cmp;
		this.root = null;
		this.size = 0;
	}
	
	public boolean contains(T x) {
		return this.find(x) != null;
	}
	
	private TreeNode<T> find(T x) {

		TreeNode<T> current  = this.root;
		while(current != null) {
			if( this.cmp.compare(x, current.getItem()) < 0  ) {
				//traverse left
				current = current.getLeftChild();
			} else if( this.cmp.compare(x, current.getItem()) > 0  ) {
				//traverse right
				current = current.getRightChild();
			} else {
				//current = x
				return current;
			}
		}
		
		return current;
	}
	
	public void add(T x) {
		
		if(this.root == null) {
			this.root = new TreeNode<T>(x);
			this.size++;
			return;
		} else if(this.contains(x) ) {
			return; //noop
		}
		
		TreeNode<T> parent = findParent(x);
		TreeNode<T> child = new TreeNode<>(x);
		//x < parent.getItem()
		if( this.cmp.compare(x, parent.getItem()) < 0 ) {
			//insert to the left...
			parent.setLeftChild(child);	
			child.setParent(parent);
		} else if( this.cmp.compare(x, parent.getItem()) > 0 ) {
			//insert to the right...
			parent.setRightChild(child);
			child.setParent(parent);
		} else {
			return; //noop
		}
		
	}
		
	private TreeNode<T> findParent(T x) {

		TreeNode<T> previous = null;
		TreeNode<T> current  = this.root;
		while(current != null) {
			previous = current;
			if( this.cmp.compare(x, current.getItem()) < 0  ) {
				//traverse left
				current = current.getLeftChild();
			} else if( this.cmp.compare(x, current.getItem()) > 0  ) {
				//traverse right
				current = current.getRightChild();
			} else {
				//current = x
				return current.getParent();
			}
		}
		
		return previous;
	}
	
	public List<T> inorderTraversal() {
		List<T> result = new ArrayList<>();

		Deque<TreeNode<T>> stack = new LinkedList<>();
		TreeNode<T> u = this.root;
		while (!stack.isEmpty() || u != null) {
			if(u != null) {
				//first visit
				stack.push(u);
				u = u.getLeftChild();
			} else {
				//second visit, u, the current vertex is null..
				u = stack.pop();
				//process it
				result.add(u.getItem());
				//go to the right
				u = u.getRightChild();
			}
		}

		return result;
	}
	
	/**
	 * Finds the node containing the minimum value of the
	 * tree rooted at u
	 * @param u
	 * @return
	 */
	private TreeNode<T> getMin(TreeNode<T> u) {
		
		TreeNode<T> curr = u;
		while(curr.hasLeftChild()) {
			//keep going left
			curr = curr.getLeftChild();
		}
		return curr;
	}
	
	public void remove(T x) {
				
		if(!this.contains(x)) {
			return;
		}
		
		//TODO: finish this on your own 
		System.out.println(this.getMin(this.root).getItem());
		
		return;
	}
	
	
}
