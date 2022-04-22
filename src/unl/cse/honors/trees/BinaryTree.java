package unl.cse.honors.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T> {

	private TreeNode<T> root;

	public BinaryTree(T item) {
		this.root = new TreeNode<>(item);		
	}

	/**
	 * @param root
	 */
	public BinaryTree(TreeNode<T> root) {
		this.root = root;
	}
	
	
	public List<T> preorderTraversal() {
		
		List<T> order = new ArrayList<>();
		
		Deque<TreeNode<T>> stack = new LinkedList<>();
		stack.push(this.root);
		while(!stack.isEmpty()) {
			TreeNode<T> u = stack.pop();
			order.add(u.getItem());
			if(u.hasRightChild()) {
				stack.push(u.getRightChild());
			}
			if(u.hasLeftChild()) {
				stack.push(u.getLeftChild());
			}
		}
		
		return order;
	}
	
	public List<T> bfs() {
		
		List<T> order = new ArrayList<>();
		
		Deque<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(this.root);
		while(!queue.isEmpty()) {
			TreeNode<T> u = queue.poll();
			order.add(u.getItem());
			if(u.hasLeftChild()) {
				queue.offer(u.getLeftChild());
			}
			if(u.hasRightChild()) {
				queue.offer(u.getRightChild());
			}
		}
		
		return order;
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
	
	public void preorderRecursive() {
		this.preorderRecursive(this.root);
	}
	
	private void preorderRecursive(TreeNode<T> u) {
		if(u == null) {
			return;
		}
		System.out.println(u.getItem());
		this.preorderRecursive(u.getLeftChild());
		this.preorderRecursive(u.getRightChild());
	}
	
	public void inorderRecursive() {
		this.inorderRecursive(this.root);
	}
	
	private void inorderRecursive(TreeNode<T> u) {
		if(u == null) {
			return;
		}
		this.inorderRecursive(u.getLeftChild());
		System.out.println(u.getItem());
		this.inorderRecursive(u.getRightChild());
	}
	

	public void postorderRecursive() {
		this.postorderRecursive(this.root);
	}
	
	private void postorderRecursive(TreeNode<T> u) {
		if(u == null) {
			return;
		}
		this.postorderRecursive(u.getLeftChild());
		this.postorderRecursive(u.getRightChild());
		System.out.println(u.getItem());
	}
	
}
