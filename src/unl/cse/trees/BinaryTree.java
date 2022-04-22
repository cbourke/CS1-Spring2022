package unl.cse.trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree<T> implements Iterable<T> {

	private TreeNode<T> root;

	public BinaryTree(T rootItem) {
		this.root = new TreeNode<T>(rootItem);
	}

	/**
	 * @param root
	 */
	public BinaryTree(TreeNode<T> root) {
		super();
		this.root = root;
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

	public List<T> preorderTraversal() {
		List<T> result = new ArrayList<>();

		Deque<TreeNode<T>> stack = new LinkedList<>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			TreeNode<T> u = stack.pop();
			result.add(u.getItem());
			if (u.hasRightChild()) {
				stack.push(u.getRightChild());
			}
			if (u.hasLeftChild()) {
				stack.push(u.getLeftChild());
			}
		}

		return result;
	}
	
	public List<T> bfs() {
		List<T> result = new ArrayList<>();

		Deque<TreeNode<T>> queue = new LinkedList<>();
		queue.offer(this.root);
		while (!queue.isEmpty()) {
			TreeNode<T> u = queue.poll();
			result.add(u.getItem());
			if (u.hasLeftChild()) {
				queue.offer(u.getLeftChild());
			}
			if (u.hasRightChild()) {
				queue.offer(u.getRightChild());
			}
		}

		return result;
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

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private final Deque<TreeNode<T>> stack = new LinkedList<>();
			private TreeNode<T> u = root;
			
			@Override
			public boolean hasNext() {
				return (!this.stack.isEmpty() || this.u != null);
			}

			@Override
			public T next() {
				T item = null;
				while (!stack.isEmpty() || u != null) {
					if(u != null) {
						//first visit
						stack.push(u);
						u = u.getLeftChild();
					} else {
						//second visit, u, the current vertex is null..
						u = stack.pop();
						//process it
						item = u.getItem();
						//go to the right
						u = u.getRightChild();
						break;
					}
				}
				return item;


			}
			
		};
	}

}
