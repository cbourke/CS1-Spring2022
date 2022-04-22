package unl.cse.trees;

import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
		
		BinaryTree<String> tree = TreeUtils.largeTree();
		
		System.out.println(tree.inorderTraversal());

		for(String s : tree) {
			System.out.print(s+", ");
		}
		
		Iterator<String> iter = tree.iterator();
		while(iter.hasNext()) {
			String s = iter.next();
			System.out.print(s+", ");
		}
		
		
	}

}
